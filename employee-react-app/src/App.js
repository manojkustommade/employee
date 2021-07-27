import './App.css';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import EmpoyeesComponent from './components/EmployeesComponent';
import AddEmployeeComponent from './components/AddEmployeeComponent';
import ViewEmployeeComponent from './components/ViewEmployeeComponent';
import UpdateEmployeeComponent from './components/UpdateEmployeeComponent';

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />

        <div className="container">
          <Switch>
            <Route path="/" exact component = { EmpoyeesComponent }></Route>
            <Route path="/employees" component = { EmpoyeesComponent }></Route>
            <Route path="/employee/create" component = { AddEmployeeComponent }></Route>
            <Route path="/employee/view/:id" component = { ViewEmployeeComponent }></Route>
            <Route path="/employee/update/:id" component = { UpdateEmployeeComponent }></Route>
          </Switch>
        </div> 

        {/* <FooterComponent /> */}
      </Router>
    </div>
  );
}

export default App;
