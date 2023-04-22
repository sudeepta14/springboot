package com.sudeepta.restapi.service;

import com.sudeepta.restapi.entity.Employee;

import java.util.List;
public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Integer id);

    void save(Employee theEmployee);

    void deleteById(Integer Id);
}
