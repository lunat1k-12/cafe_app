import React from 'react';
import {connect} from 'react-redux';
import {fetchCocktails} from "./actions";
import MenuGrid from "../MenuGrid";
import {ORDER_OPEN} from "../../../Utils/constants";
import {orderItem} from "../actions";

export class CocktailsMenu extends React.Component {

    componentDidMount() {
        this.props.loadCocktails();
    }

    clickHandler = (cocktail) => {
        const newOrder = {
            userId: this.props.userUuid,
            menuItem: cocktail.id,
            status: ORDER_OPEN,
            sessionUuid: this.findSessionUuid()
        };
        this.props.orderNewItem(newOrder);
      //console.log(this.props.orders);
    };

    findSessionUuid = () => {
        let sessionUuid = null;

        this.props.orders.forEach(function(item) {
            if(ORDER_OPEN === item.status) {
                sessionUuid = item.sessionUuid;
            }
        });

        return sessionUuid;
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
        orderNewItem: (order) => dispatch(orderItem(order))
    };
};

export default connect(mapStateToProps,mapDispatchToProps)(CocktailsMenu);
