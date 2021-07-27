import axios from 'axios';

const EMPLOYEE_BASE_URL = "http://localhost:8081/employee"

class EmployeeService {

    getAllEmployees() {
        return axios.get(EMPLOYEE_BASE_URL);
    }

    addEmployee(employee) {
        return axios.post(EMPLOYEE_BASE_URL + "/create", employee);
    }

    getEmployeeById(id) {
        return axios.get(EMPLOYEE_BASE_URL + "/view/" + id);
    }

    updateEmployee(employee) {
        return axios.put(EMPLOYEE_BASE_URL + "/update", employee);
    }

    deleteEmployee(id) {
        return axios.delete(EMPLOYEE_BASE_URL + "/delete/" + id);
    }
}

export default new EmployeeService();
