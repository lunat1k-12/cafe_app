import React from 'react';
import {connect} from 'react-redux';
import {fetchFood} from './actions';
import MenuGrid from "../MenuGrid";
import {orderItem} from "../actions";

export class FoodMenu extends React.Component {

    componentDidMount() {
        this.props.loadFood();
    }

    clickHandler = (food) => {
        if(!this.props.orders.length) {
            console.log('Too many open orders.');
            return;
        }

        const newOrder = {
            menuItemId: food.id,
            count: 1,
            totalCost: 1 * food.price,
            orderId: this.props.orders[0].id
        };

        this.props.orderNewItem(newOrder, this.props.userUuid);
    };

    render() {
        return(
            <MenuGrid
                items={this.props.food}
                itemOnClick={this.clickHandler}/>
        );

    }
}

mapStateToProps = (state) => {
    return {
        userUuid: state.userUuid,
        food: state.food,
        orders: state.orders
    }
};

mapDispatchToProps = dispatch => {
    return {
        loadFood: () => dispatch(fetchFood()),
        orderNewItem: (order, userUuid) => dispatch(orderItem(order, userUuid))
    };
};

export default connect(mapStateToProps,mapDispatchToProps)(FoodMenu);
