import {ITEMS_ORDERED} from "./actions";
import {ORDER_OPENED} from "../Home/actions";

export const orders = (state = [], action) => {
    switch (action.type) {
        case ITEMS_ORDERED:
            return action.orders;
        case ORDER_OPENED:
            return [action.order];
        default:
            return state
    }
};