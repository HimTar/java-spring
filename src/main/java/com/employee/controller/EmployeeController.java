package com.employee.controller;

import com.employee.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
// import com.employee.repository.EmployeeRepository;
// import org.springframework.http.ResponseEntity;
import java.util.*;

@RestController
public class EmployeeController {
    // controller ->service(business logic) -> repository
    @Autowired
    EmployeeService employeeService;

    // This route will return list of employees
    @GetMapping("/get-employee")
    public List<Employee> fetchEmployees(){
        return employeeService.fetchEmployees();
    }

    // This route will add new employee
    @PostMapping("/add-new-employee")
    public Map<String, String> addNewEmployees(@RequestBody Employee employee){
        return employeeService.addNewEmployee(employee);
    }

}
