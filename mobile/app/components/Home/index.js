import React from 'react';
import {StyleSheet, Text, View} from 'react-native';
import {Button} from 'react-native-elements';
import {connect} from 'react-redux';
import {fetchUserUuid, GENERATE_USER_UUID, generateUserUuid, openUserOrder, setUserUUid} from "./actions";


export class Home extends React.Component {

    componentDidMount() {
       if(this.props.userUuid === 'N/A') {
           this.props.getUserUuid();
       } else if(this.props.userUuid === GENERATE_USER_UUID) {
           this.props.generateUuid();
       }
    };

    componentDidUpdate() {
        if(this.props.userUuid === GENERATE_USER_UUID) {
            this.props.generateUuid();
        }
    };

    cleanUserIdHolder = () => {
       this.props.cleanUserUuid();
    };

    openNewOrder = () => {
        if(this.props.orders && this.props.orders.length) {
            console.log('Order already opened.');
            return;
        }

        this.props.openOrder(this.props.userUuid, 1);
    };

  render() {
    return (
      <View style={styles.container} >
        <Text>Start Ordering Here BITCH !!!!!</Text>

          <Button
              large
              title="Open Order"
              onPress={this.openNewOrder}
          />

          <Button
              large
              title="Clean user ID"
              onPress={this.cleanUserIdHolder}
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
        userUuid: state.userUuid,
        orders: state.orders
    }
};

mapDispatchToProps = dispatch => {
    return {
        getUserUuid: () => dispatch(fetchUserUuid()),
        generateUuid: () => dispatch(generateUserUuid()),
        openOrder: (userUuid, tableId) => dispatch(openUserOrder(userUuid, tableId)),
        cleanUserUuid: () => dispatch(setUserUUid(GENERATE_USER_UUID))
    };
};

export default connect(mapStateToProps, mapDispatchToProps)(Home);