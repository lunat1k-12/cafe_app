import React from 'react';
import {
  Button
} from 'react-native';
import { createStackNavigator, createDrawerNavigator } from 'react-navigation';

import Layout from "./app/containers/Layout";
import Burger from "./app/components/Burger";
import FoodMenu from "./app/components/Menu/FoodMenu";
import Home from "./app/components/Home";
import { createStore, applyMiddleware } from 'redux';
import createSagaMiddleware from 'redux-saga';
import reducer from './app/reducers';
import { Provider } from 'react-redux';
import {watchFetch} from "./app/sagas";
import CocktailsMenu from "./app/components/Menu/CocktailsMenu";
import {COLORS} from "./app/Utils/constants";

const sagaMiddleware = createSagaMiddleware();
const store = createStore(reducer, applyMiddleware(sagaMiddleware));
sagaMiddleware.run(watchFetch);

export default class App extends React.Component {
  render() {
    return (
        <Provider store={store}>
            <Layout headerBg={COLORS.black}>
                <Navigation/>
            </Layout>
        </Provider>
    );
  }
}

const MyApp = createDrawerNavigator({
  Hom: {
    screen: Home,
    navigationOptions: { title: 'Home' }
  },
  CocktailsMenu: {
    screen: CocktailsMenu,
    navigationOptions: { title: 'Cocktails Menu' }
  },
  FoodMenu: {
    screen: FoodMenu,
    navigationOptions: { title: 'Food Menu' }
  }
}, {
  drawerBackgroundColor: COLORS.black,
  contentOptions: {
    activeBackgroundColor: COLORS.orange,
    activeTintColor: COLORS.black,
    inactiveTintColor: COLORS.orange
  }
});

const Navigation = createStackNavigator({
  Main: {screen: MyApp}
}, {
  initialRouteName: 'Main',
  navigationOptions: ({ navigation }) => ({
    title: 'Cafe App',
    headerLeft: (
      <Burger navigate={navigation}/>
    ),
    headerRight: (
      <Button title='User' onPress={() => console.log('User Data')}/>
    ),
    headerStyle: {
      backgroundColor: COLORS.black,
      borderBottomWidth: 0
    },
    headerTintColor: COLORS.black,
    headerTitleStyle: {
      fontWeight: 'bold',
      color: COLORS.orange
    }
  }),
});