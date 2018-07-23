import React from 'react';
import {
  StyleSheet,
  StatusBar,
  View
} from 'react-native';

export default class Layout extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <StatusBar
          backgroundColor={this.props.HeaderBg}
          barStyle="light-content"
        />
        {this.props.children}
      </View>
    );
  }
}


const styles = StyleSheet.create({
  container: {
    flex: 1,
  }
});