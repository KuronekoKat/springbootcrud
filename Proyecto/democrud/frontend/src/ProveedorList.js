import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class ProveedorList extends Component {

    constructor(props) {
        super(props);
        this.state = {proveedores: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/proveedor')
            .then(response => response.json())
            .then(data => this.setState({proveedores: data}));
    }
	
	async remove(id) {
        await fetch(`/proveedor/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedProveedores = [...this.state.proveedores].filter(i => i.id !== id);
            this.setState({proveedores: updatedProveedores});
        });
    }
	 render() {
        const {proveedores} = this.state;

        const proveedoresList = proveedores.map(proveedor => {
            return <tr key={proveedor.idProveedor}>
                <td style={{whiteSpace: 'nowrap'}}>{proveedor.nombreProveedor}</td>
                <td>{proveedor.telefonoProveedor}</td>
				<td>{proveedor.descripcion}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/proveedores/" + proveedor.idProveedor}>Editar</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(proveedor.idProveedor)}>Borrar</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/proveedores/new">Agregar Proveedor</Button>
                    </div>
                    <h3>Proveedores</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">Nombre</th>
                            <th width="30%">Telefono</th>
							<th width="30%">Descripcion</th>
                            <th width="40%">Acciones</th>
                        </tr>
                        </thead>
                        <tbody>
                        {proveedoresList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }

	
}
export default ProveedorList;