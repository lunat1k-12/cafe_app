import {FETCHED_FOOD, fetchFoodAsync} from "../components/Menu/FoodMenu/actions";
import {takeEvery} from 'redux-saga/effects';
import {fetchCocktailsAsync, FETCHED_COCKTAILS} from "../components/Menu/CocktailsMenu/actions";
import {
    FETCHED_USER_ORDERS,
    FETCHED_USER_UUID, fetchOpenNewOrder, fetchUserOrdersAsync,
    fetchUserUuidAsync,
    GENERATE_USER_UUID,
    generateUserUuidAsync, OPEN_NEW_USER_ORDER
} from "../components/Home/actions";
import {ORDER_REQUEST, orderItemsAsync} from "../components/Menu/actions";


export function* watchFetch() {
    yield takeEvery(FETCHED_FOOD, fetchFoodAsync);
    yield takeEvery(FETCHED_COCKTAILS, fetchCocktailsAsync);
    yield takeEvery(FETCHED_USER_UUID, fetchUserUuidAsync);
    yield takeEvery(GENERATE_USER_UUID, generateUserUuidAsync);
    yield takeEvery(ORDER_REQUEST, orderItemsAsync);
    yield takeEvery(FETCHED_USER_ORDERS, fetchUserOrdersAsync);
    yield takeEvery(OPEN_NEW_USER_ORDER, fetchOpenNewOrder);
}