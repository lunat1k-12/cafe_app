import React from 'react';
import { Card, Button } from 'react-native-elements';
import {StyleSheet,ScrollView,Text} from "react-native";

export default class MenuGrid extends React.Component {

    renderItems = () => {
        return this.props.items.map((f, key) =>
            <Card key={key} title={f.title}
                  image={{uri: "data:image/jpeg;base64,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"}}
                  >
                <Text style={{marginBottom: 10}}>
                    {f.description}
                </Text>
                <Text style={{marginBottom: 10}}>
                    ${f.price}
                </Text>
                <Button
                    icon={{name: 'code'}}
                    backgroundColor='#03A9F4'
                    buttonStyle={{borderRadius: 0, marginLeft: 0, marginRight: 0, marginBottom: 0}}
                    title='Order'
                    onPress={() => this.props.itemOnClick(f)}/>
            </Card>);
    };

    render() {
        return (<ScrollView contentContainerStyle={styles.container}>
            {this.renderItems()}
        </ScrollView>);
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    }
});