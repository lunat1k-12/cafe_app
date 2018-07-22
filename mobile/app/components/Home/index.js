import React from 'react';
import {Button, StyleSheet, Text, View} from 'react-native';
import {connect} from 'react-redux';
import {fetchUserUuid, GENERATE_USER_UUID, generateUserUuid} from "./actions";


export class Home extends React.Component {

    componentDidMount() {
       if(this.props.userUuid === 'N/A') {
           this.props.getUserUuid();
       } else if(this.props.userUuid === GENERATE_USER_UUID) {
           this.props.generateUuid();
       }
    };

  render() {
    return (
      <View style={styles.container} >
        <Text>Open up App.js to start working on your app!</Text>
        <Text>Changes you make will automatically reload.</Text>
        <Text>Shake your phone to open the developer menu.</Text>
        <Text>It Works !!!</Text>
        <Button
          title="Open"
          onPress={this.props.navigation.openDrawer}
        />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    backgroundColor: 'red',
    // alignItems: 'center',
    // justifyContent: 'center',
  },
});

mapStateToProps = (state) => {
    return {
        userUuid: state.userUuid
    }
};

mapDispatchToProps = dispatch => {
    return {
        getUserUuid: () => dispatch(fetchUserUuid()),
        generateUuid: () => dispatch(generateUserUuid())
    };
};

export default connect(mapStateToProps, mapDispatchToProps)(Home);