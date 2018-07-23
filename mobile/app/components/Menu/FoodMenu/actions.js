import {put, call} from 'redux-saga/effects';
import {URL_BASE} from "../../../Utils/constants";

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
        const data = yield call(() => {
                return fetch(URL_BASE + '/menu/food')
                    .then(res => res.json())
            }
        );
        yield put(foodLoaded(data));
    } catch (error) {
        yield put(foodLoaded([]));
    }
}