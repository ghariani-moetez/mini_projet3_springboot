package com.moetez.employees.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moetez.employees.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
