import React, {Fragment} from 'react';
import {connect} from 'react-redux';
import {Text} from 'react-native';
import {List, ListItem} from 'react-native-elements';
import {fetchCocktails} from "../Menu/CocktailsMenu/actions";
import {fetchFood} from "../Menu/FoodMenu/actions";

export class UserOrders extends React.Component {

    componentDidMount() {
        if(!this.props.cocktails.length || !this.props.food.length) {
            this.props.loadCocktails();
            this.props.loadFood();
        }
    };

    getItemTitle = menuItemId => {
        let itemTitle = 'N/A';
        const allItems = [...this.props.cocktails, ...this.props.food];

        allItems.forEach(item => {
           if(menuItemId === item.id) {
               itemTitle = item.title;
           }
        });

        return itemTitle;
    };

    renderItems = (items) => {
        if(!items) {
            return;
        }

        return items.map((orderItem, key) => <ListItem
            avatar={{uri:'https://s3.amazonaws.com/uifaces/faces/twitter/ladylexy/128.jpg'}}
            key={key}
            title={this.getItemTitle(orderItem.menuItemId)}>
        </ListItem>)
    };

    render() {
       //  console.log(this.props.orders);
       // return (<View>
       //     <Text>{JSON.stringify(this.props.orders)}</Text>
       // </View>);
        return this.props.orders.map((order, key) => <Fragment key={key}>
            <Text>Order#: {order.id}</Text>
            <Text>Status: {order.status}</Text>
            <List>
            {this.renderItems(order.orderItems)}
        </List>
        </Fragment>);
    };
}

mapStateToProps = (state) => {
    return {
        userUuid: state.userUuid,
        cocktails: state.cocktails,
        food: state.food,
        orders: state.orders
    }
};

mapDispatchToProps = dispatch => {
    return {
        loadCocktails: () => dispatch(fetchCocktails()),
        loadFood: () => dispatch(fetchFood())
    };
};

export default connect(mapStateToProps, mapDispatchToProps)(UserOrders);
