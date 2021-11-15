package com.tutorial.hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import com.tutorial.hibernate.demo.entity.Instructor;
import com.tutorial.hibernate.demo.entity.InstructorDetails;
import com.tutorial.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetails.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int theId = 5;
			int theId2 = 6;
			
			Instructor tempInstructor = session.get(Instructor.class, theId);
			Instructor tempInstructorTwo = session.get(Instructor.class, theId2);
			
			
			if(tempInstructor != null && tempInstructorTwo != null) {
				
				session.delete(tempInstructor);
				session.delete(tempInstructorTwo);
				
			} else {
				System.out.println("No records in table.");
			}
			
			
			session.getTransaction().commit();
			System.out.println("Done.");
			
		} finally {
			session.close();
		}
	
	}

}
