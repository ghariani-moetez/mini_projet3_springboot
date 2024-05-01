package com.moetez.employees.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomEmpl", types = { Employee.class })
public interface EmployeeProjection {
	public String getNomEmployee();

}
