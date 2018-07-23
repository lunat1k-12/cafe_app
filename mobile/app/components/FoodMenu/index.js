import React from 'react';
import {Button, StyleSheet, Text, View} from 'react-native';
import {connect} from 'react-redux';
import {fetchFood} from './actions';
import {CocktailsMenu} from "../CocktailsMenu";

export class FoodMenu extends React.Component {

    componentDidMount() {
        this.props.loadFood();
    }

    renderFoods = () => {
        return this.props.food.map((f, key) => <View key={key}>
            <Text >{f.title}  -  {f.description} - {f.price}</Text>

        </View>);
    };

    render() {
        return (
            <View style={styles.container}>
                {this.renderFoods()}
                <Button
                    title="Go to Cocktails Details"
                    onPress={() => this.props.navigation.navigate('CocktailsMenu')}
                />
                <Button
                    title="Open"
                    onPress={() => this.props.navigation.openDrawer()}
                />
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    },
});

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
