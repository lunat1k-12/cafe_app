import React from 'react';
import { Card, Button } from 'react-native-elements';
import {StyleSheet,ScrollView,Text,Modal,TextInput,View} from "react-native";

export default class MenuGrid extends React.Component {

    constructor(props) {
        super(props);
        this.state = {modalVisible: false,
                      selectedItem: {},
                      count: 1};
    }

    showItemModal = (item) => {
        this.setState({modalVisible: true, selectedItem: item});
    };

    renderItems = () => {
        return this.props.items.map((f, key) =>
            <Card key={key} title={f.title}
                  image={{uri: f.image ? `data:image/jpeg;base64,${f.image}` : defaultImage}}
                  >
                <Text style={{marginBottom: 10}}>
                    {f.description}
                </Text>
                <Text style={{marginBottom: 10}}>
                    ${f.price}
                </Text>
                <Button
                    icon={{name: 'add-box'}}
                    backgroundColor='#03A9F4'
                    buttonStyle={{borderRadius: 0, marginLeft: 0, marginRight: 0, marginBottom: 0}}
                    title='Details'
                    onPress={() => this.showItemModal(f)}/>
            </Card>);
    };
//onPress={() => this.props.itemOnClick(f)}/>
    render() {
        return (<ScrollView
            contentContainerStyle={styles.container}
            >
            {this.renderItems()}
            {this.renderModalItem()}
        </ScrollView>);
    }

    setCount = count => {
        if(count < 0) {
            count = 0;
        }
        this.setState({count});
    };

    orderItem = () => {
        this.setState({modalVisible:false});
        this.props.itemOnClick(this.state.selectedItem, this.state.count);
    };

    renderModalItem = () => {
        const { selectedItem }  = this.state;
        return (<Modal
            animationType="slide"
            transparent={false}
            visible={this.state.modalVisible}
            onRequestClose={() => {
                alert('Modal has been closed.');
            }}>
            <View style={{marginTop: 22}}>
                <Card title={selectedItem.title}
                      image={{uri: selectedItem.image ? `data:image/jpeg;base64,${selectedItem.image}` : defaultImage}}
                >
                    <Text style={{marginBottom: 10}}>
                        {selectedItem.description}
                    </Text>
                    <Text style={{marginBottom: 10}}>
                        ${selectedItem.price}
                    </Text>
                    <View>
                        <Text>Count: {this.state.count}</Text>
                        <Button
                            buttonStyle={styles.countButton}
                            title='+'
                            onPress={() => this.setCount(this.state.count + 1)}/>
                        <Button
                            buttonStyle={styles.countButton}
                            title='-'
                            onPress={() => this.setCount(this.state.count - 1)}/>
                    </View>
                    <Button
                        icon={{name: 'add-box'}}
                        backgroundColor='#03A9F4'
                        buttonStyle={{borderRadius: 0, marginLeft: 0, marginRight: 0, marginBottom: 0}}
                        title='Order'
                        onPress={this.orderItem}/>
                    <Button
                        backgroundColor='#03A9F4'
                        buttonStyle={{borderRadius: 0, marginLeft: 0, marginRight: 0, marginBottom: 0}}
                        title='Cancel'
                        onPress={() => this.setState({modalVisible:false})}/>
                </Card>
            </View>
        </Modal>);
    };
}

const styles = StyleSheet.create({
    container: {
        //flex: 1,
        backgroundColor: '#fff',
        //alignItems: 'center',
        //justifyContent: 'center',
    },
    countButton: {
        height: 40,
        width: 40
    }
});

const defaultImage = 'data:image/jpeg;base64,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';