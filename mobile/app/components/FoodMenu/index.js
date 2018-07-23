import React from 'react';
import {connect} from 'react-redux';
import {fetchFood} from './actions';
import MenuGrid from "../MenuGrid";

export class FoodMenu extends React.Component {

    componentDidMount() {
        this.props.loadFood();
    }

    clickHandler = (food) => {
        console.log(food);
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
        food: state.food
    }
};

mapDispatchToProps = dispatch => {
    return {
        loadFood: () => dispatch(fetchFood())
    };
};

export default connect(mapStateToProps,mapDispatchToProps)(FoodMenu);
