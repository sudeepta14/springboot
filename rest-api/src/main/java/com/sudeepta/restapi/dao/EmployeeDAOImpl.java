package com.sudeepta.restapi.dao;

import com.sudeepta.restapi.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(Integer id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void save(Employee theEmployee) {
        entityManager.merge(theEmployee);
    }

    @Override
    public void deleteById(Integer Id) {
        Employee employee = entityManager.find(Employee.class, Id);
        entityManager.remove(employee);
    }
}
