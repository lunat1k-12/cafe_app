import React from 'react';
import {
  StyleSheet,
  TouchableHighlight,
  View
} from 'react-native';

export default class Burger extends React.Component {
  render() {
    let styles = {
      burger: {
        position: 'relative',
        width: 70,
        height: 20
      },
      topLine: {
        position: 'absolute',
        top: 0,
        left: 10,
        right: 30,
        height: 4,
        backgroundColor: '#ff7110'
      },
      middleLine: {
        position: 'absolute',
        top: '50%',
        marginTop: -2,
        left: 10,
        right: 30,
        height: 4,
        backgroundColor: '#ff7110'
      },
      botLine: {
        position: 'absolute',
        left: 10,
        right: 30,
        bottom: 0,
        height: 4,
        backgroundColor: '#ff7110'
      }
    };

    const mainStyles = StyleSheet.create(styles);

    return (

      <TouchableHighlight
        onPress={() => this.props.navigate.toggleDrawer()}
      >
        <View style={mainStyles.burger}>
          <View style={mainStyles.topLine}></View>
          <View style={mainStyles.middleLine}></View>
          <View style={mainStyles.botLine}></View>
        </View>
      </TouchableHighlight>
    );
  }
}


