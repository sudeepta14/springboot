package com.sudeepta.restapi.rest;
import com.sudeepta.restapi.entity.Employee;
import com.sudeepta.restapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {
    private EmployeeService employeeService;
    // constructor injection
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null){
            throw new RuntimeException("Employee id not found " + employeeId);
        }
        return employee;
    }
    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        employeeService.save(theEmployee);
        System.out.println("Added new Employee");
    }

    @PutMapping ("/employees")
    public void updateEmployee(@RequestBody Employee theEmployee){
        employeeService.save(theEmployee);
        System.out.println("Updated Employee");
    }

    @DeleteMapping ("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){
        employeeService.deleteById(employeeId);
        System.out.println("Deleted Employee");
    }

}
