import React from 'react';
import { StyleSheet, View, Text } from 'react-native';

export default class Toolbar extends React.Component {
  render() {
    return (
      <View styles={styles.container}>
        <Text>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquam consequatur culpa </Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    height: 40,
    backgroundColor: 'red'
  },
});
