import {COCKTAILS_MENU_LOADED} from "./actions";

export const cocktails = (state = [], action) => {
    switch (action.type) {
        case COCKTAILS_MENU_LOADED:
            return action.cocktails;
        default:
            return state
    }
};