package com.tutorial.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {
			
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read JSON file and map/convert to JAVA pojo
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// print data
			System.out.println("First name = " + theStudent.getFirstName());
			System.out.println("Last name = " + theStudent.getLastName());
			System.out.println(theStudent.getLanguages());
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		

	}

}
