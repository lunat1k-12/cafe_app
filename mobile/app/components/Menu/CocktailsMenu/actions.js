import {call, put} from 'redux-saga/effects';
import {DEFAULT_PASS, URL_BASE} from "../../../Utils/constants";
import {AsyncStorage} from "react-native";
import {btoa} from "Base64";

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
        const userUuid = yield call(() => {
                return AsyncStorage.getItem("userUuid");
            }
        );

        const data = yield call(() => {
                return fetch(URL_BASE + '/menu/cocktails',{
                    method: 'GET',
                    headers: {
                        'Authorization': 'Basic ' + btoa(`${userUuid}:${DEFAULT_PASS}`),
                        'Content-Type': 'application/json'
                    }
                })
                    .then(res => res.json())
            }
        );
        yield put(cocktailsLoaded(data));
    } catch (error) {
        yield put(cocktailsLoaded([]));
    }
}