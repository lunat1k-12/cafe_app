import {FETCHED_FOOD, fetchFoodAsync} from "../components/FoodMenu/actions";
import {takeEvery} from 'redux-saga/effects';
import {fetchCocktailsAsync, FETCHED_COCKTAILS} from "../components/CocktailsMenu/actions";
import {
    FETCHED_USER_UUID,
    fetchUserUuidAsync,
    GENERATE_USER_UUID,
    generateUserUuidAsync
} from "../components/Home/actions";


export function* watchFetch() {
    yield takeEvery(FETCHED_FOOD, fetchFoodAsync);
    yield takeEvery(FETCHED_COCKTAILS, fetchCocktailsAsync);
    yield takeEvery(FETCHED_USER_UUID, fetchUserUuidAsync);
    yield takeEvery(GENERATE_USER_UUID, generateUserUuidAsync);
}