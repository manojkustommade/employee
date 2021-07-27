import React, { Component } from 'react';
import EmployeeService from './../service/EmployeeService';

class AddEmployeeComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
        
            empCode: '',
            firstName: '',
            lastName: '',
            emailId: '',
            designation: ''
        }
    }

    changeHandler = (event) => {
        this.setState({ 
            [event.target.name]: event.target.value }
        );
    }

    saveOrUpdateEmployee = (event) => {
        event.preventDefault();

        EmployeeService.addEmployee(this.state).then(response => {
            this.cancel();
        }).catch(error => {
            alert("employee not added");
        });
    }

    cancel = () => {
        this.props.history.push("/employees");
    }

    getTitle() {
        return <h3 className="text-center">Add Employee</h3>
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Employee Id: </label>
                                            <input placeholder="id" name="empCode" className="form-control" 
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateEmployee}>Save</button>
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

export default AddEmployeeComponent