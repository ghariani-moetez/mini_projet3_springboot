package com.moetez.employees;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.moetez.employees.entities.Employee;
import com.moetez.employees.service.EmployeeService;

@SpringBootApplication
public class EmployeesApplication implements CommandLineRunner{
	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(EmployeesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		employeeService.saveEmployee(new Employee("hamdi korbi",1000.0,new Date()));
		employeeService.saveEmployee(new Employee("dhia ksibi",1400.0,new Date()));
		employeeService.saveEmployee(new Employee("aabslem hsan",900.0,new Date()));

	}
	
}
