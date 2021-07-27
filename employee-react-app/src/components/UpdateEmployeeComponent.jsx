import React, {Component} from 'react';
import EmployeeService from './../service/EmployeeService';

class UpdateEmployeeCompoent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: Number(this.props.match.params.id),
            empCode: '',
            firstName: '',
            lastName: '',
            emailId: '',
            designation: ''
        }
    }

    updateEmployeeForm(response) {
        this.setState({
            id: response.id,
            empCode: response.empCode,
            firstName: response.firstName,
            lastName: response.lastName,
            emailId: response.emailId,
            designation: response.designation
        });
    }

    componentDidMount() {
        EmployeeService.getEmployeeById(this.state.id).then(response => {
            this.updateEmployeeForm(response.data);
            console.log("redirect to update employee component");
        }).catch(error => {
            alert("employee not found");
        });
    }

    changeHandler = (event) => {
        this.setState({ 
            [event.target.name]: event.target.value }
        );
    }

    cancel = () => {
        this.props.history.push("/employees");
    }

    updateEmployee = (e) => {
        e.preventDefault();

        EmployeeService.updateEmployee(this.state).then(response => {
            this.cancel();
        }).catch(error => {
            alert("Error in Update");
        })
    }

    render () {
        return (
            <div>
                <br></br>
                   <div className = "container"> 
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Employee</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Id: </label>
                                            <input placeholder="empId" name="empCode" className="form-control" 
                                                value={this.state.empCode} onChange={this.changeHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> First Name: </label>
                                            <input placeholder="First Name" name="firstName" className="form-control" 
                                                value={this.state.firstName} onChange={this.changeHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Last Name: </label>
                                            <input placeholder="Last Name" name="lastName" className="form-control" 
                                                value={this.state.lastName} onChange={this.changeHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Email Id: </label>
                                            <input placeholder="Email Address" name="emailId" className="form-control" 
                                                value={this.state.emailId} onChange={this.changeHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Designation: </label>
                                            <input placeholder="Designation" name="designation" className="form-control" 
                                                value={this.state.designation} onChange={this.changeHandler}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.updateEmployee}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateEmployeeCompoent