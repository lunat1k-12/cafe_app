import {ITEMS_ORDERED} from "./actions";

export const orders = (state = [], action) => {
    switch (action.type) {
        case ITEMS_ORDERED:
            return action.orders;
        default:
            return state
    }
};