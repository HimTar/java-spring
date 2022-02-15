package com.employee.service;

import com.employee.repository.EmployeeRepository;
import com.employee.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    // This function returns list of all the employees registered
    public List<Employee> fetchEmployees(){
        return employeeRepository.findAll();
    }

    // This function adds new employee to the table
    public Map<String,String> addNewEmployee(Employee employee){
        
    	boolean idExists = employeeRepository.existsById(employee.getId());
    	
    	// Checking if user id already exists
    	if(idExists){
            HashMap<String, String> map = new HashMap<>();
            
            // Failure message returning
            map.put("message", "The user id already exists");
            map.put("status","failed");
            
            return map;
        }
    	
        // Saving the employee after validation
        employeeRepository.save(employee);
           
        HashMap<String, String> map = new HashMap<>();
           
        // Success message returning
        map.put("message", "New Employee created Successfully");
        map.put("status", "success");
            
        return map;
             
    }
}
