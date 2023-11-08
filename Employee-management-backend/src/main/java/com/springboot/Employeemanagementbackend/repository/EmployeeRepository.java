package com.springboot.Employeemanagementbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.Employeemanagementbackend.model.Employee;
//4
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	Optional<Employee> findByEmail(String email);

}
