import {call, put} from "redux-saga/es/effects";
import {URL_BASE} from "../../Utils/constants";
import {loadUserOrders} from "../Home/actions";

export const ITEMS_ORDERED = 'ITEMS_ORDERED';
export const ORDER_REQUEST = 'ORDER_REQUEST';

export const itemsOrdered = (orders) => {
    return {
        type: ITEMS_ORDERED,
        orders
    };
};

export const orderItem = (order, userUuid) => {
    return {
        type: ORDER_REQUEST,
        order,
        userUuid
    };
};

export function* orderItemsAsync(action) {
    try {
        console.log(action);
        const data = yield call(() => {
                return fetch(URL_BASE + `/order/add-item`,
                    {
                        headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                        },
                        method: "POST",
                        body: JSON.stringify(action.order)
                    })
                    .then(res => res.json())
            }
        );
        yield put(loadUserOrders(action.userUuid));
    } catch (error) {
        yield put(loadUserOrders(action.userUuid));
    }
}