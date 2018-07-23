import React from 'react';
import {connect} from 'react-redux';
import {fetchCocktails} from "./actions";
import MenuGrid from "../MenuGrid";

export class CocktailsMenu extends React.Component {

    componentDidMount() {
        this.props.loadCocktails();
    }

    clickHandler = (cocktail) => {
        console.log(cocktail);
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
    console.log(state);
    return {
        cocktails: state.cocktails
    }
};

mapDispatchToProps = dispatch => {
    return {
        loadCocktails: () => dispatch(fetchCocktails())
    };
};

export default connect(mapStateToProps,mapDispatchToProps)(CocktailsMenu);
