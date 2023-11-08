package com.springboot.Employeemanagementbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Employeemanagementbackend.model.Employee;
import com.springboot.Employeemanagementbackend.service.IEmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService;

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(employeeService.getAllEmployees());//Yaha pe FOUND nahi available h
		//return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.FOUND);
		//Iss line ki wajah se axios 302 error aara tha FrontEnd pe....May be axios sirf 302 status n leta ho 200 leta ho
	}

	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.updateEmployee(id, employee), HttpStatus.OK);
		// HttpStatus.Accepted would also be fine
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable int id) {
		//return ResponseEntity.ok(employeeService.getEmployeeById(id)); //Here ResponseEntity.FOUND jaisa nahi hai kuch balki notFound hai
		return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.FOUND);
	}

}
