package com.example.employeemanagement.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping(path = "api/v1")
public class EmployeeController{

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // @GetMapping("/employees")
    // public String listEmployees(Model model) {
    //     List<Employee> employees = employeeService.getAllEmployees();
    //     model.addAttribute("employees", employees);
    //     return "list-employees";
    // }
    // // /employee/new
    // @GetMapping("/showFormForAdd")
    // public String showFormForAdd(Model model) {
    //     model.addAttribute("employee", new Employee());
    //     return "employee-form";
    // }

    // // /employee/{id}
    // @PostMapping("/employee/{id}")
	// public String updateStudent(@PathVariable Long id,
	// 		@ModelAttribute("employee") Employee employee,
	// 		Model model) {
		
	// 	// get student from database by id
	// 	Employee existingEmployee = employeeService.getEmployeeById(id);
	// 	existingEmployee.setId(id);
	// 	existingEmployee.setFirstName(employee.getFirstName());
	// 	existingEmployee.setLastName(employee.getLastName());
	// 	existingEmployee.setEmail(employee.getEmail());
		
	// 	// save updated student object
	// 	employeeService.updateEmployee(existingEmployee);
	// 	return "redirect:/employees";		
	// }

    // // /employee
    // @PostMapping("/saveEmployee")
    // public String saveEmployee(@ModelAttribute("employee") Employee employee) {
    //     employeeService.saveEmployee(employee);
    //     return "redirect:/employees";
    // }
    // // /employee/edit/{id}
    // @GetMapping("/showFormForUpdate")
    // public String showFormForUpdate(@RequestParam("employeeId") Long id, Model model) {
    //     Employee employee = employeeService.getEmployeeById(id);
    //     model.addAttribute("employee", employee);
    //     return "edit_employees";
    // }

    // // /employee/{id}
    // @GetMapping("/delete")
    // public String deleteEmployee(@RequestParam("employeeId") Long id) {
    //     employeeService.deleteEmployee(id);
    //     return "redirect:/employees";
    // }

    @GetMapping("/employees")
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "list-employees";
	}
	
	@GetMapping("/employee/new")
	public String createStudentForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employee-form";
		
	}
	
	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/edit/{id}")
	public String editEmployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit_employee";
	}

	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable Long id,
			@ModelAttribute("employee") Employee employee,
			Model model) {
		
		Employee existingEmployee = employeeService.getEmployeeById(id);
		existingEmployee.setId(id);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		
		employeeService.updateEmployee(existingEmployee);
		return "redirect:/employees";		
	}
	
	
	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}





}