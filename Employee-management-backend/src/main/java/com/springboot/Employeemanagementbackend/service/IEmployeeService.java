package com.springboot.Employeemanagementbackend.service;

import java.util.List;
import java.util.Optional;

import com.springboot.Employeemanagementbackend.model.Employee;

//2
public interface IEmployeeService {
	Employee saveEmployee(Employee employee);

	Optional<Employee> getEmployeeById(int id);

	List<Employee> getAllEmployees();

	Employee updateEmployee(int id, Employee employee);

	void deleteEmployee(int id);

}
