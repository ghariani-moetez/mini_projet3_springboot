package com.moetez.employees.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moetez.employees.entities.Employee;
import com.moetez.employees.service.EmployeeService;

@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/ListeEmployees")
    public String listeEmployees(ModelMap modelMap,
    		@RequestParam (name="page",defaultValue = "0") int page,
    		@RequestParam (name="size", defaultValue = "4") int size) {
    	Page<Employee> empls = employeeService.getAllEmployeesParPage(page, size);
    	modelMap.addAttribute("employees", empls);
    	 modelMap.addAttribute("pages", new int[empls.getTotalPages()]);
    	modelMap.addAttribute("currentPage", page);
        return "listeEmployees"; 
    }

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createEmployee";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee, @RequestParam("date") String date,
            ModelMap modelMap) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateEmbauche = dateFormat.parse(date);
        employee.setDateEmbauche(dateEmbauche);

        Employee savedEmployee = employeeService.saveEmployee(employee);
        String msg = "Employee enregistré avec Id " + savedEmployee.getIdEmployee();
        modelMap.addAttribute("msg", msg);
        return "createEmployee";
    }

    @RequestMapping("/supprimerEmployee")
    public String supprimerEmployee(@RequestParam("id") Long id, ModelMap modelMap,
    		@RequestParam (name="page",defaultValue = "0") int page,
    		@RequestParam (name="size", defaultValue = "4") int size) {
        employeeService.deleteEmployeeById(id);
        Page<Employee> empls = employeeService.getAllEmployeesParPage(page,
        		size);
        		modelMap.addAttribute("employees", empls);
        		modelMap.addAttribute("pages", new int[empls.getTotalPages()]);
        		modelMap.addAttribute("currentPage", page);
        		modelMap.addAttribute("size", size);

        return "listeEmployees"; 
    }

    @RequestMapping("/modifierEmployee")
    public String editerEmployee(@RequestParam("id") Long id, ModelMap modelMap) {
        Employee employee = employeeService.getEmployee(id);
        modelMap.addAttribute("employee", employee);
        return "editerEmployee";
    }

    @RequestMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employee") Employee employee, @RequestParam("date") String date,
            ModelMap modelMap) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateEmbauche = dateFormat.parse(date);
        employee.setDateEmbauche(dateEmbauche);

        employeeService.updateEmployee(employee);
        List<Employee> employees = employeeService.getAllEmployees();
        modelMap.addAttribute("employees", employees);
        return "listeEmployees"; // Corrected the return value
    }
}
