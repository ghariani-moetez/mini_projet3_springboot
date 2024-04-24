package com.moetez.employees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.moetez.employees.entities.Employee;
import com.moetez.employees.repos.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public Employee saveEmployee(Employee e) {
		return employeeRepository.save(e);
	}

	@Override
	public Employee updateEmployee(Employee e) {
		return employeeRepository.save(e);
		
	}

	@Override
	public void deleteEmployee(Employee e) {
		employeeRepository.delete(e);		
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);		
	}

	@Override
	public Employee getEmployee(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Page<Employee> getAllEmployeesParPage(int page, int size) {
		return employeeRepository.findAll(PageRequest.of(page, size));

	}

}
