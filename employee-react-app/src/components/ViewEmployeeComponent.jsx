import React, {Component} from 'react';
import EmployeeService from './../service/EmployeeService';

class ViewEmployeeComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: this.props.match.params.id,
            employee: {}
        }
    }

    componentDidMount(){
        EmployeeService.getEmployeeById(Number(this.state.id)).then( res => {
            this.setState({employee: res.data});
        })
    }

    goBack = () => {
        this.props.history.push("/employees");
    }

    render () {
        return (
            <div>
                <button className="btn btn-primary" onClick={this.goBack}>Back</button>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Employee Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            
                            <div> <label> Id: </label>{ this.state.employee.empCode }</div>
                        </div>
                        <div className = "row">
                            
                            <div><label> First Name: </label> { this.state.employee.firstName }</div>
                        </div>
                        <div className = "row">
                            
                            <div><label> Last Name: </label> { this.state.employee.lastName }</div>
                        </div>
                        <div className = "row">
                           
                            <div>  <label> Email ID: </label>{ this.state.employee.emailId }</div>
                        </div>
                        <div className = "row">
                            
                            <div> <label> Designation: </label>{ this.state.employee.designation }</div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewEmployeeComponent;