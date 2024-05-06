package com.moetez.employees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.moetez.employees.entities.Departement;
import com.moetez.employees.entities.Employee;
import com.moetez.employees.repos.DepartementRepository;
import com.moetez.employees.repos.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartementRepository departementRepository;
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

	@Override
	public List<Employee> findByNomEmployee(String nom) {
		return employeeRepository.findByNomEmployee(nom);
	}

	@Override
	public List<Employee> findByNomEmployeeContains(String nom) {
		return  employeeRepository.findByNomEmployeeContains(nom);
	}

	@Override
	public List<Employee> findByNomSalaire(String nom, Double salaire) {
		return employeeRepository.findByNomSalaire(nom,salaire);
	}
	@Override
	public List<Employee> findByDepartement(Departement departement) {
		return employeeRepository.findByDepartement(departement);
	}

	@Override
	public List<Employee> findByDepartementIdDep(Long id) {
		return employeeRepository.findByDepartementIdDep(id);
	}

	@Override
	public List<Employee> findByOrderByNomEmployeeAsc() {
		return employeeRepository.findByOrderByNomEmployeeAsc();
	}

	@Override
	public List<Employee> trierEmployeesNomsSalaire() {
		return employeeRepository.trierEmployeesNomsSalaire();
	}

	@Override
	public List<Departement> getAllDepartements() {
		// TODO Auto-generated method stub
		return  departementRepository.findAll();
	}

}
