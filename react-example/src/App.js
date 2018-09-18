import React, { Component } from 'react';
import {Toolbar} from 'primereact/toolbar';
import {InputText} from 'primereact/inputtext';
import {Button} from 'primereact/button';
import {Growl} from 'primereact/growl';
import {DataTable} from 'primereact/datatable';
import {Column} from 'primereact/column';
import 'primereact/resources/themes/nova-light/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';
import 'primeflex/primeflex.css';
import './App.css';

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            zipcode: '',
            addresses: []
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(e) {
        this.setState({zipcode: e.target.value});
    }

    handleSubmit(e) {
        fetch(`https://api.zipaddress.net/?zipcode=${this.state.zipcode}`, {
            mode: 'cors'
        })
            .then((response) => {
                return response.json();
            })
            .then((myJson) => {
                if (200 === myJson.code) {
                    myJson.data.zipcode = this.state.zipcode;
                    let addresses = this.state.addresses;
                    addresses.unshift(myJson.data);
                    this.setState({zipcode: '', addresses: addresses});
                }
                else if (404 === myJson.code) {
                    this.growl.show({severity: 'error', summary: myJson.code, detail: 'Not found.'});
                }
                else {
                    this.growl.show({severity: 'error', summary: myJson.code});
                }
            });
        e.preventDefault();
    }

    render() {
        return (
            <div className="App">
                <header>
                    <form onSubmit={this.handleSubmit}>
                        <Growl ref={(el) => this.growl = el} />
                        <Toolbar>
                            <div className="p-toolbar-group-right">
                                <div className="p-inputgroup">
                                    <span className="p-inputgroup-addon">郵便番号</span>
                                    <InputText value={this.state.zipcode} onChange={this.handleChange}/>
                                    <Button icon="pi pi-search"/>
                                </div>
                            </div>
                        </Toolbar>
                    </form>
                </header>
                <article>
                    <DataTable value={this.state.addresses}>
                        <Column field="zipcode" header="郵便番号" sortable={true} style={{width: '10em'}}/>
                        <Column field="fullAddress" header="住所"/>
                    </DataTable>
                </article>
            </div>
        );
    }
}

export default App;
