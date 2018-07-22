import {call, put} from "redux-saga/es/effects";
import {URL_BASE} from "../../Utils/constants";
import {AsyncStorage} from 'react-native';

export const SET_USER_ID = 'SET_USER_ID';
export const FETCHED_USER_UUID = 'FETCHED_USER_UUID';
export const GENERATE_USER_UUID = 'GENERATE_USER_UUID';

export const setUserUUid = (userUuid) => {
    return {
        type: SET_USER_ID,
        userUuid
    };
};

export function fetchUserUuid() {
    return {type: FETCHED_USER_UUID};
};

export function generateUserUuid() {
    return {type: GENERATE_USER_UUID};
};

export function* fetchUserUuidAsync() {
    try {
        const data = yield call(() => {
                return AsyncStorage.getItem("userUuid");
            }
        );

        yield put(setUserUUid(data ? data : GENERATE_USER_UUID));
    } catch (error) {
        yield put(setUserUUid("N/A"));
    }
};

export function* generateUserUuidAsync() {
    try {
        const data = yield call(() => {
                return fetch(URL_BASE + '/client/generate-user-id')
                    .then(res => res.json())
            }
        );
        yield put(setUserUUid(data.domain));
    } catch (error) {
        yield put(setUserUUid("N/A"));
    }
};