import {food} from '../components/FoodMenu/reducers';
import {cocktails} from '../components/CocktailsMenu/reducers';
import {userUuid} from '../components/Home/reducers';
import { combineReducers } from 'redux';

export default combineReducers(
    {
        food,
        cocktails,
        userUuid
    });