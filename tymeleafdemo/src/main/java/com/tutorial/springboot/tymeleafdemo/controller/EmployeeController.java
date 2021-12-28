package com.tutorial.springboot.tymeleafdemo.controller;

import com.tutorial.springboot.tymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> theEmployees;

    // load employee data
    @PostConstruct
    private void loadData(){

        Employee emp1 = new Employee(1, "John", "Johny", "testemail@email.com");
        Employee emp2 = new Employee(1, "Tim", "Tomy", "testemail@email.com");
        Employee emp3 = new Employee(1, "Merry", "Merry", "testemail@email.com");

        theEmployees = new ArrayList<>();

        theEmployees.add(emp1);
        theEmployees.add(emp2);
        theEmployees.add(emp3);

    }

    @GetMapping("/list")
    public String listEmployees(Model theModel){

        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }

}
