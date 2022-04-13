package com.dchan68.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dchan68.springboot.exception.ResourceNotFoundException;
import com.dchan68.springboot.model.Employee;
import com.dchan68.springboot.repository.EmployeeRepository;
import com.dchan68.springboot.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent())
			return employee.get();
		else
			throw new ResourceNotFoundException("Employee", "Id", "id");
	}
	
}
