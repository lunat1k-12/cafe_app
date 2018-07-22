import {fetchFoodAsync} from "../components/FoodMenu/actions";
import {takeEvery} from 'redux-saga/effects';


export function* watchFetchFood() {
    yield takeEvery('FETCHED_FOOD', fetchFoodAsync);
}