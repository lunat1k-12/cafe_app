import React from 'react';
import { StyleSheet, Text, View, Button } from 'react-native';
import { connect } from 'react-redux';
import {fetchCocktails} from "./actions";

export class CocktailsMenu extends React.Component {

    componentDidMount() {
        this.props.loadCocktails();
    }

    renderCocktails = () => {
        return this.props.cocktails.map((f, key) => <View key={key}>
            <Text >{f.title}  -  {f.description} - {f.price}</Text>

        </View>);
    };

    render() {
        return (
            <View style={styles.container}>
                {this.renderCocktails()}
                <Button
                    title="Go to Food Details"
                    onPress={() => this.props.navigation.navigate('FoodMenu')}
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
        cocktails: state.cocktails
    }
};

mapDispatchToProps = dispatch => {
    return {
        loadCocktails: () => dispatch(fetchCocktails())
    };
};

export default connect(mapStateToProps,mapDispatchToProps)(CocktailsMenu);
