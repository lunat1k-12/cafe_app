import {call, put} from "redux-saga/es/effects";
import {DEFAULT_PASS, URL_BASE} from "../../Utils/constants";
import {AsyncStorage} from 'react-native';
import {itemsOrdered} from "../Menu/actions";
import {btoa} from "Base64";

export const SET_USER_ID = 'SET_USER_ID';
export const FETCHED_USER_UUID = 'FETCHED_USER_UUID';
export const FETCHED_USER_ORDERS = 'FETCHED_USER_ORDERS';
export const GENERATE_USER_UUID = 'GENERATE_USER_UUID';
export const OPEN_NEW_USER_ORDER = 'OPEN_NEW_USER_ORDER';
export const ORDER_OPENED = 'ORDER_OPENED';

export const orderOpened = (order) => {
    return {
        type: ORDER_OPENED,
        order
    };
};

export const setUserUUid = (userUuid) => {
    return {
        type: SET_USER_ID,
        userUuid
    };
};

export const loadUserOrders = (userUuid) => {
    return {
        type: FETCHED_USER_ORDERS,
        userUuid
    };
};

export const openUserOrder = (userUuid, tableId) => {
    return {
        type: OPEN_NEW_USER_ORDER,
        userUuid,
        tableId
    };
};

export function fetchUserUuid() {
    return {type: FETCHED_USER_UUID};
};

export function generateUserUuid() {
    return {type: GENERATE_USER_UUID};
};

export function* fetchOpenNewOrder(action) {
    try {
        const userUuid = yield call(() => {
                return AsyncStorage.getItem("userUuid");
            }
        );

        const order = yield call(() => {
                return fetch(URL_BASE + `/order/${action.userUuid}/${action.tableId}/open`, {
                    method: 'GET',
                    headers: {
                        'Authorization': 'Basic ' + btoa(`${userUuid}:${DEFAULT_PASS}`),
                        'Content-Type': 'application/json'
                    }
                })
                    .then(res => res.json());
            }
        );

        yield put(orderOpened(order));
    } catch (error) {
        console.log('Error while opening order.');
    }
};

export function* fetchUserUuidAsync() {
    try {
        const data = yield call(() => {
                return AsyncStorage.getItem("userUuid");
            }
        );

        yield put(setUserUUid(data ? data : GENERATE_USER_UUID));

        if(data) {
            yield put(loadUserOrders(data));
        }

    } catch (error) {
        yield put(setUserUUid("N/A"));
    }
};

export function* generateUserUuidAsync() {
    try {
        const data = yield call(() => {
                return fetch(URL_BASE + '/client/generate-user-id')
                    .then(res => res.json());
            }
        );
        yield put(setUserUUid(data.domain));

        if(data) {
            yield put(loadUserOrders(data));
        }

    } catch (error) {
        yield put(setUserUUid("N/A"));
    }
};

export function* fetchUserOrdersAsync(action) {
    try {
        const orders = yield call(() => {
                return fetch(URL_BASE + `/order/${action.userUuid}/get-open-orders`,{
                    method: 'GET',
                    headers: {
                        'Authorization': 'Basic ' + btoa(`${action.userUuid}:${DEFAULT_PASS}`),
                        'Content-Type': 'application/json'
                    }
                })
                    .then(res => res.json());
            }
        );

        yield put(itemsOrdered(orders));
    } catch (error) {
        console.log('Error while loading orders.')
    }
}