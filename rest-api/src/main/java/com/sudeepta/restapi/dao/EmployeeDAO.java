package com.sudeepta.restapi.dao;

import com.sudeepta.restapi.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(Integer id);

    void save(Employee theEmployee);

    void deleteById(Integer Id);




}
