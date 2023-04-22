package com.sudeepta.restapi.service;

import com.sudeepta.restapi.dao.EmployeeDAO;
import com.sudeepta.restapi.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        Employee employee = employeeDAO.findById(id);
        return employee;
    }
    @Transactional
    @Override
    public void save(Employee theEmployee) {
        employeeDAO.save(theEmployee);
    }
    @Transactional
    @Override
    public void deleteById(Integer Id) {
        employeeDAO.deleteById(Id);
    }
}
