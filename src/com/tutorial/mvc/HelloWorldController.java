package com.tutorial.mvc;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.modeler.modules.ModelerSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello") //parent mapping
public class HelloWorldController {
	
	//controller method to show intial HTML form
	@RequestMapping("/showForm")
	private String showForm() {
		return "helloworld-form";		
	}
	
	//controller method to process the form
	@RequestMapping("/processForm")
	private String processForm() {
		return "helloworld";
	}
	
	// new controller method to read data
	// add data to model
	@RequestMapping("/processFormVersionTwo")
	public String displayMessage(@RequestParam("studentName") String theName, Model model) {
		
		theName = theName.toUpperCase();
		
		String result = "Greetings to " + theName;
		
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	
	
}
