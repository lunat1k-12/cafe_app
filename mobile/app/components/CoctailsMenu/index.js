import React from 'react';
import { StyleSheet, Text, View, Button } from 'react-native';

export default class CoctailsMenu extends React.Component {
    render() {
        return (
            <View style={styles.container}>
                <Text>Coctails</Text>
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
