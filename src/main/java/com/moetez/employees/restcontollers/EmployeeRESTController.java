package com.moetez.employees.restcontollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moetez.employees.entities.Employee;
import com.moetez.employees.service.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmployeeRESTController {
	@Autowired
	EmployeeService employeeService;
	@RequestMapping(method=RequestMethod.GET)
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();	
		}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable("id") Long id) {
	return employeeService.getEmployee(id);
	 }
	@RequestMapping(method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee employee) {
	return employeeService.saveEmployee(employee);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee employee) {
	return employeeService.updateEmployee(employee);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable("id") Long id)
	{
		employeeService.deleteEmployeeById(id);
	}
	@RequestMapping(value="/emplsdep/{idDep}",method = RequestMethod.GET)
	public List<Employee> getEmployeesByCatId(@PathVariable("idDep") Long idDep) {
	return employeeService.findByDepartementIdDep(idDep);
	}
}
