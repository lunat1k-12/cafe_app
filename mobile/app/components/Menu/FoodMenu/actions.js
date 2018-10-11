import {put, call} from 'redux-saga/effects';
import {DEFAULT_PASS, URL_BASE} from "../../../Utils/constants";
import {AsyncStorage} from "react-native";
import {btoa} from 'Base64';

export const FOOD_MENU_LOADED = 'FOOD_MENU_LOADED';
export const FETCHED_FOOD = 'FETCHED_FOOD';

export const foodLoaded = (food) => {
    return {
        type: FOOD_MENU_LOADED,
        food
    };
};

export function fetchFood() {
    return {type: FETCHED_FOOD};
};

export function* fetchFoodAsync() {
    try {
        const userUuid = yield call(() => {
                return AsyncStorage.getItem("userUuid");
            }
        );

        const data = yield call(() => {
                return fetch(URL_BASE + '/menu/food', {
                    method: "GET",
                    headers: {
                        'Authorization': 'Basic ' + btoa(`${userUuid}:${DEFAULT_PASS}`),
                        'Content-Type': 'application/json'
                    }
                }).then(res => res.json())
            }
        );

        yield put(foodLoaded(data));
    } catch (error) {
        console.log('Failed to load food !!');
        console.log(error);
        yield put(foodLoaded([]));
    }
}