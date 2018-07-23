import {call, put} from "redux-saga/es/effects";
import {NEW_ORDER_UUID, URL_BASE} from "../../Utils/constants";

export const ITEMS_ORDERED = 'ITEMS_ORDERED';
export const ORDER_REQUEST = 'ORDER_REQUEST';

export const itemsOrdered = (orders) => {
    return {
        type: ITEMS_ORDERED,
        orders
    };
};

export const orderItem = (order) => {
    return {
        type: ORDER_REQUEST,
        order,
        sessionUuid: order.sessionUuid ? order.sessionUuid : NEW_ORDER_UUID
    };
};

export function* orderItemsAsync(action) {
    try {
        const data = yield call(() => {
                return fetch(URL_BASE + `/order/${action.sessionUuid}/add-item`,
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
        yield put(itemsOrdered(data));
    } catch (error) {
        yield put(itemsOrdered([]));
    }
}