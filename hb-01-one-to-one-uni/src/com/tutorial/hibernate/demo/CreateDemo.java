package com.tutorial.hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import com.tutorial.hibernate.demo.entity.Course;
import com.tutorial.hibernate.demo.entity.Instructor;
import com.tutorial.hibernate.demo.entity.InstructorDetails;
import com.tutorial.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetails.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// create instructor object
			Instructor tempInstructor = new Instructor("Asmir", "Kopic", "asmir@email.com");
			InstructorDetails tempInstructorDetails = new InstructorDetails("youtube.com", "design");
			
			tempInstructor.setInstructorDetail(tempInstructorDetails);
			
			session.beginTransaction();
			
			// add data to database
			session.save(tempInstructor);
			

			session.getTransaction().commit();
			System.out.println("Done.");
			
		} finally {
			session.close();
			factory.close();
		}
	
	}

}
