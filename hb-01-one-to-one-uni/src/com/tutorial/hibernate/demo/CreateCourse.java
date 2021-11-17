package com.tutorial.hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import com.tutorial.hibernate.demo.entity.Course;
import com.tutorial.hibernate.demo.entity.Instructor;
import com.tutorial.hibernate.demo.entity.InstructorDetails;
import com.tutorial.hibernate.demo.entity.Student;

public class CreateCourse {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetails.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			// get instructor from database
			int instrctorId = 1;
			Instructor tempInstructor = session.get(Instructor.class, instrctorId);
			
			Course courseOne = new Course("Java programming");
			Course courseTwo = new Course("Spring & Hibernate programming");
			
			tempInstructor.add(courseOne);
			tempInstructor.add(courseTwo);
			
			session.save(courseOne);
			session.save(courseTwo);

			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	
	}

}
