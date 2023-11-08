
import axios from "axios";

const BASE_URL = "http://localhost:8080/employees";
class EmployeeService{

    //**Method to get all employee from our api or database */
//    async getAllEmployee(){
//        let result = await axios.get(BASE_URL, {
//             validateStatus: function (status) {
//                 // if this function returns true, exception is not thrown, so
//                 // in simplest case just return true to handle status checks externally.
//                 return true;
//             }
//         });
//         return result


// if (result.status === 302) {
//    // GET YOUR RESPONSE HERE
//    console.log(result.data);
   
// }
    getAllEmployee(){
        return axios.get(BASE_URL)
    }
    /**MEthod to save employee */
    saveEmployee(employeeData){
        return axios.post(BASE_URL, employeeData);
    }
    updateEmployee(id, employeeData){
        return axios.put(`${BASE_URL}/${id}`, employeeData)
    }
    getEmployeeById(id){
        return axios.get(`${BASE_URL}/${id}`);
    }
    deleteEmployee(id){
        return axios.delete(BASE_URL +"/" +id);
    }

}
export default new EmployeeService();
