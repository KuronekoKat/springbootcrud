import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class ProveedorEdit extends Component {

    emptyItem = {
        nombreProveedor: '',
        telefonoProveedor: '',
		descripcion: ''		
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }


    async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            const proveedor = await (await fetch(`/proveedor/${this.props.match.params.id}`)).json();
            this.setState({item: proveedor});
        }
    }
	
	handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
		console.log(item);
    }
	
async handleSubmit(event) {
	
    event.preventDefault();
    const {item} = this.state;
	console.log(item);
    await fetch('/proveedor' + (item.idProveedor ? '/' + item.idProveedor : '/'), {
        method: (item.idProveedor) ? 'PUT' : 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(item),
    });
    this.props.history.push('/proveedores');
}
	render() {
        const {item} = this.state;
        const title = <h2>{item.idProveedor ? 'Editar Proveedor' : 'Agregar Proveedor'}</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="name">Nombre</Label>
                        <Input type="text" name="nombreProveedor" id="name" defaultValue={item.nombreProveedor}
                               onChange={this.handleChange} autoComplete="name"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="phone">Telefono</Label>
                        <Input type="text" name="telefonoProveedor" id="phone" defaultValue={item.telefonoProveedor}
                               onChange={this.handleChange} autoComplete="phone"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="description">Descripcion</Label>
                        <Input type="text" name="descripcion" id="description" defaultValue={item.descripcion}
                               onChange={this.handleChange} autoComplete="description"/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Guardar</Button>{' '}
                        <Button color="secondary" tag={Link} to="/proveedores">Cancelar</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
	
}


export default withRouter(ProveedorEdit);