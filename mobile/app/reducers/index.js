import {food} from '../components/FoodMenu/reducers';
import {cocktails} from '../components/CoctailsMenu/reducers';
import {userUuid} from '../components/Home/reducers';
import { combineReducers } from 'redux';

export default combineReducers(
    {
        food,
        cocktails,
        userUuid
    });