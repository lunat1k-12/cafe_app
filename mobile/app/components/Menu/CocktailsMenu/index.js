import React from 'react';
import {connect} from 'react-redux';
import {fetchCocktails} from "./actions";
import MenuGrid from "../MenuGrid";
import {orderItem} from "../actions";

export class CocktailsMenu extends React.Component {

    componentDidMount() {
        this.props.loadCocktails();
    }

    clickHandler = (cocktail, count) => {
        if(!this.props.orders.length) {
            console.log('no open orders.');
            return;
        }

        const newOrder = {
            menuItemId: cocktail.id,
            count,
            totalCost: count * cocktail.price,
            orderId: this.props.orders[0].id
        };

        this.props.orderNewItem(newOrder, this.props.userUuid);
    };


    render() {
        return(
            <MenuGrid
                items={this.props.cocktails}
                itemOnClick={this.clickHandler}/>
        );
    }
}

mapStateToProps = (state) => {
    return {
        userUuid: state.userUuid,
        cocktails: state.cocktails,
        orders: state.orders
    }
};

mapDispatchToProps = dispatch => {
    return {
        loadCocktails: () => dispatch(fetchCocktails()),
        orderNewItem: (order, userUuid) => dispatch(orderItem(order, userUuid))
    };
};

export default connect(mapStateToProps,mapDispatchToProps)(CocktailsMenu);
