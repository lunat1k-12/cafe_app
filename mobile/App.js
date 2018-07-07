import React from 'react';
import { StyleSheet, Text, View, Button } from 'react-native';
import { createStackNavigator, createDrawerNavigator } from 'react-navigation';

import Layout from "./app/containers/Layout";
import CoctailsMenu from "./app/components/CoctailsMenu";
import FoodMenu from "./app/components/FoodMenu";
import Home from "./app/components/Home";



export default class App extends React.Component {
  render() {
    return (
      <Layout>
        <MyApp />
      </Layout>
    );
  }
}

const MyApp = createDrawerNavigator({
    Home: {screen: Home},
    CoctailsMenu: { screen: CoctailsMenu },
    FoodMenu: {screen: FoodMenu}
}, {
    // Default config for all screens
    headerMode: 'none',
    initialRouteName: 'Home'
});