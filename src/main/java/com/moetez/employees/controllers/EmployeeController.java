package com.moetez.employees.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moetez.employees.entities.Departement;
import com.moetez.employees.entities.Employee;
import com.moetez.employees.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/accessDenied")
    public String error()
    {
    return "accessDenied";
    }

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
    public String showCreate(ModelMap modelMap) {
    	List<Departement> empls = employeeService.getAllDepartements();
    	modelMap.addAttribute("employee", new Employee());
    	modelMap.addAttribute("mode", "new");
    	modelMap.addAttribute("departements", empls);
    	return "formEmployee";
    }

    @RequestMapping("/saveEmployee")

    public String saveProduit(@Valid Employee employee,
    		 BindingResult bindingResult,@RequestParam (name="page",defaultValue = "0") int page,
     		@RequestParam (name="size", defaultValue = "4") int size)
    {
    	int currentPage;
    	boolean isNew = false;

    if (bindingResult.hasErrors()) return "formEmployee";
    //if (employee.getIdEmployee()== null) 
    	//isNew=true;
	  
    employeeService.saveEmployee(employee);
    if (isNew) //ajout
    {
    Page<Employee> empls = employeeService.getAllEmployeesParPage(page, size);
    currentPage = empls.getTotalPages()-1;
    }
    else //modif
    	currentPage=page;
    return ("redirect:/ListeEmployees?page="+currentPage+"&size="+size);
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
    public String editerEmployee(@RequestParam("id") Long id, ModelMap modelMap,
    		@RequestParam (name="page",defaultValue = "0") int page,
    		@RequestParam (name="size", defaultValue = "4") int size) {
        
    	Employee employee = employeeService.getEmployee(id);
    	List<Departement> empls = employeeService.getAllDepartements();

        modelMap.addAttribute("employee", employee);
        modelMap.addAttribute("mode", "edit");
    	modelMap.addAttribute("departements", empls);
    	modelMap.addAttribute("page", page);

    	modelMap.addAttribute("size", size);
        return "formEmployee";
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
    @GetMapping(value = "/")
    public String welcome() {
     return "index";
    }
}
