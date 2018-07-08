import React from 'react';
import {
  Button
} from 'react-native';
import { createStackNavigator, createDrawerNavigator } from 'react-navigation';

import Layout from "./app/containers/Layout";
import Burger from "./app/components/Burger";
import CoctailsMenu from "./app/components/CoctailsMenu";
import FoodMenu from "./app/components/FoodMenu";
import Home from "./app/components/Home";


const HeaderBg = "#000";

export default class App extends React.Component {
  render() {
    return (
      <Layout headerBg={HeaderBg}>
        <Navigation />
      </Layout>
    );
  }
}

const MyApp = createDrawerNavigator({
  Home: {screen: Home},
  CoctailsMenu: { screen: CoctailsMenu },
  FoodMenu: {screen: FoodMenu}
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
      backgroundColor: HeaderBg,
      borderBottomWidth: 0
    },
    headerTintColor: HeaderBg,
    headerTitleStyle: {
      fontWeight: 'bold',
      color: '#ff7110'
    }
  }),
});