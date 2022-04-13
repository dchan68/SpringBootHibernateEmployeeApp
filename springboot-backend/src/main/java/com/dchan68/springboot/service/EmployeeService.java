package com.dchan68.springboot.service;

import java.util.List;

import com.dchan68.springboot.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
}