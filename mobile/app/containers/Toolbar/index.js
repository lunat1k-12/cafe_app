import React from 'react';
import { StyleSheet, View, Text } from 'react-native';

export default class Toolbar extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <Text>TOOLBAR</Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    height: 40,
    backgroundColor: '#2089dc'
  }
});
