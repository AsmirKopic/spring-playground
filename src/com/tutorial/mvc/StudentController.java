package com.tutorial.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		//create student object
		Student theStudent = new Student();
		
		//add student to model
		model.addAttribute("student", theStudent);
	
		return "student-form";
	}
	
	/*
	 * Add an initBinder to convert trim input string
	 * remove leading and trailing whitespace
	 * resolve issue for validation 
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("processForm")
	public String processForm(@Valid @ModelAttribute("student") Student theStudent, 
								BindingResult theBindingResult) {
		
		if (theBindingResult.hasErrors()) {
			return "student-form";	
		} else {
			return "student-confirmation";
		}
		
	}

}
