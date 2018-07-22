import {URL_BASE} from "../../Utils/constants";
import {put, call} from 'redux-saga/effects';

export const foodLoaded = (food) => {
    return {
        type: 'FOOD_MENU_LOADED',
        food
    };
};

export function fetchFood() {
    return {type: 'FETCHED_FOOD'};
};

export function* fetchFoodAsync() {
    try {
        const data = yield call(() => {
                return fetch(URL_BASE + '/menu/food')
                    .then(res => res.json())
            }
        );
        const action = foodLoaded(data);
        yield put(foodLoaded(data));
    } catch (error) {
        yield put(foodLoaded([]));
    }
}