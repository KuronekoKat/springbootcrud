import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ProveedorList from './ProveedorList';
import ProveedorEdit from "./ProveedorEdit";

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/proveedores' exact={true} component={ProveedorList}/>
            <Route path='/proveedores/:id' component={ProveedorEdit}/>
          </Switch>
        </Router>
    )
  }
}

export default App;