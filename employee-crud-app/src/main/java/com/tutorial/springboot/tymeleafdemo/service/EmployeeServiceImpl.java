package com.tutorial.springboot.tymeleafdemo.service;

import com.tutorial.springboot.tymeleafdemo.dao.EmployeeRepository;
import com.tutorial.springboot.tymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;

        if (result.isPresent()){
            theEmployee = result.get();

        } else {
            throw new RuntimeException("Did not find employee with id " + theId);
        }

        return theEmployee;
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
