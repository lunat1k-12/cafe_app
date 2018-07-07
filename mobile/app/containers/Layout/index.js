import React from 'react';
import {
  StyleSheet,
  Text,
  StatusBar,
  View,
  Button
} from 'react-native';

import Toolbar from "../Toolbar"



export default class Layout extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <StatusBar
          backgroundColor="blue"
          barStyle="light-content"
        />
        <Toolbar />
        {this.props.children}
      </View>
    );
  }
}


const styles = StyleSheet.create({
  container: {
    // flex: 1,
    // backgroundColor: 'red'
  },
});