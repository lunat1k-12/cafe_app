import React from 'react';
import { StyleSheet, Text, View, Button } from 'react-native';
import { createStackNavigator, createDrawerNavigator } from 'react-navigation';
import CoctailsMenu from "./app/components/CoctailsMenu";
import FoodMenu from "./app/components/FoodMenu";


class App extends React.Component {
  render() {
    return (
      <View style={styles.container} >
        <Text>Open up App.js to start working on your app!</Text>
        <Text>Changes you make will automatically reload.</Text>
        <Text>Shake your phone to open the developer menu.</Text>
          <Text>It Works !!!</Text>
          <Button
              title="Open"
              onPress={() => this.props.navigation.openDrawer()}
          />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});

export default createDrawerNavigator({
    App: {screen: App},
    CoctailsMenu: { screen: CoctailsMenu },
    FoodMenu: {screen: FoodMenu}
}, {
    // Default config for all screens
    headerMode: 'none',
    initialRouteName: 'App'
});
