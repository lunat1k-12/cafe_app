import { AsyncStorage } from 'react-native';
import {SET_USER_ID} from "./actions";

export const userUuid = (state = "N/A", action) => {
    switch (action.type) {
        case SET_USER_ID:
            AsyncStorage.setItem("userUuid",action.userUuid);
            return action.userUuid;
        default:
            return state
    }
};