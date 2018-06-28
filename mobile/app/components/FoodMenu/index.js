import React from 'react';
import { StyleSheet, Text, View, Button } from 'react-native';

export default class FoodMenu extends React.Component {
    render() {
        return (
            <View style={styles.container}>
                <Text>Food</Text>
                <Button
                    title="Go to Coctails Details"
                    onPress={() => this.props.navigation.navigate('CoctailsMenu')}
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
