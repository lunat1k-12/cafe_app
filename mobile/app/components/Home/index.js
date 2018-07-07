import React from 'react';
import { StyleSheet, Text, View, Button } from 'react-native';


export default class Home extends React.Component {
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
    alignItems: 'center',
    justifyContent: 'center',
  },
});