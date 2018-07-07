import React from 'react';
import {
  StyleSheet,
  StatusBar,
  View,
  Platform
} from 'react-native';

import Toolbar from "../Toolbar"



export default class Layout extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <StatusBar
          backgroundColor="#3d6dcc"
          barStyle="light-content"
        />
        <View style={styles.statusBarBackground}></View>
        <Toolbar />
        {this.props.children}
      </View>
    );
  }
}


const styles = StyleSheet.create({
  container: {
    flex: 1,
    // backgroundColor: 'red'
  },
  statusBarBackground: {
    height: (Platform.OS === 'ios') ? 20 : 0,
    backgroundColor: "#3d6dcc",
  }
});