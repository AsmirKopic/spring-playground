package com.tutorial.springboot.tymeleafdemo.dao;

import com.tutorial.springboot.tymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
