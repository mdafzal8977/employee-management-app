package com.springboot.Employeemanagementbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.Employeemanagementbackend.exception.EmployeeAlreadyExistsException;
import com.springboot.Employeemanagementbackend.exception.EmployeeNotFoundException;
import com.springboot.Employeemanagementbackend.model.Employee;
import com.springboot.Employeemanagementbackend.repository.EmployeeRepository;

//3
//5
@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
		
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		if(employeeAlreadyExists(employee.getEmail())) {
			throw new EmployeeAlreadyExistsException(employee.getEmail()+" already exists!");
		}
		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> getEmployeeById(int id) {
		if(employeeRepository.findById(id).isEmpty())
			throw new EmployeeNotFoundException("id: "+id);
		return employeeRepository.findById(id);
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		Employee employeeToUpdate=employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Sorry,this student could not be found-> id: "+id));
		employeeToUpdate.setFirstName(employee.getFirstName());
		employeeToUpdate.setLastName(employee.getLastName());
		employeeToUpdate.setEmail(employee.getEmail());
		return employeeRepository.save(employeeToUpdate);
	}

	@Override
	public void deleteEmployee(int id) {
		if(!employeeRepository.existsById(id)) {
			throw new EmployeeNotFoundException("id: "+id);
		}
		employeeRepository.deleteById(id);

	}
	private boolean employeeAlreadyExists(String email) {
		return employeeRepository.findByEmail(email).isPresent();
	}

}
