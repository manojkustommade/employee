import React, {Component} from 'react';
import EmployeeService from '../service/EmployeeService';

class EmployeesComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            employees: []
        }
    }

    addEmployee = () => {
        this.props.history.push("/employee/create");
    }

    viewEmployee = (id) => {
        this.props.history.push(`/employee/view/${id}`);
    }

    editEmployee = (id) => {
        this.props.history.push(`/employee/update/${id}`);
    }

    deleteEmployee = (id) => {
        EmployeeService.deleteEmployee(Number(id)).then(response => {
            this.setState({
                employees: this.state.employees.filter(employee => employee.id !== id)
            });
            
            alert("Record deleted successfully");
        }).catch(error => {
            alert("Error deleting record");    
        })
    }

    componentDidMount() {
        EmployeeService.getAllEmployees().then(response => {
            this.setState({
                employees : response.data.reverse()
            })
        }).catch(error => {
            console.log(error);
        });
    }

    render() {
        return (
            <div className="App">
                 <div className = "row">
                    <button className="btn btn-primary" style={{marginTop: "10px", width: "132px"}} onClick= {this.addEmployee}> Add Employee</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">
                            <thead>
                                <tr>
                                    <th> Code</th>
                                    <th> First Name</th>
                                    <th> Last Name</th>
                                    <th> Email Id</th>
                                    <th> Designation</th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.employees.map(
                                        employee => 
                                        <tr key = {employee.id}>
                                             <td>{ employee.empCode }</td>
                                             <td> { employee.firstName} </td>   
                                             <td> {employee.lastName}</td>
                                             <td> {employee.emailId}</td>
                                             <td> {employee.designation}</td>
                                             <td>
                                                 <button onClick={ () => this.editEmployee(employee.id)} className="btn btn-info">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEmployee(employee.id)} className="btn btn-danger">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewEmployee(employee.id)} className="btn btn-info">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>
                 </div>
            </div>
        )
    }
}

export default EmployeesComponent