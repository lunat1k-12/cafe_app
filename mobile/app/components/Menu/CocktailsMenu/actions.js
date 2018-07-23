import {call, put} from 'redux-saga/effects';
import {URL_BASE} from "../../../Utils/constants";

export const COCKTAILS_MENU_LOADED = 'COCKTAILS_MENU_LOADED';
export const FETCHED_COCKTAILS = 'FETCHED_COCKTAILS';

export const cocktailsLoaded = (cocktails) => {
    return {
        type: COCKTAILS_MENU_LOADED,
        cocktails
    };
};

export function fetchCocktails() {
    return {type: FETCHED_COCKTAILS};
};

export function* fetchCocktailsAsync() {
    try {
        const data = yield call(() => {
                return fetch(URL_BASE + '/menu/cocktails')
                    .then(res => res.json())
            }
        );
        yield put(cocktailsLoaded(data));
    } catch (error) {
        yield put(cocktailsLoaded([]));
    }
}