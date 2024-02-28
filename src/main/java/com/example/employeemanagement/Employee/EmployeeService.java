package com.example.employeemanagement.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public void deleteEmployeeById(Long id) {
    }

    
}
