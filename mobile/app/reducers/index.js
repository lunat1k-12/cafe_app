import {food} from '../components/Menu/FoodMenu/reducers';
import {cocktails} from '../components/Menu/CocktailsMenu/reducers';
import {orders} from '../components/Menu/reducers';
import {userUuid} from '../components/Home/reducers';
import { combineReducers } from 'redux';

export default combineReducers(
    {
        food,
        cocktails,
        userUuid,
        orders
    });