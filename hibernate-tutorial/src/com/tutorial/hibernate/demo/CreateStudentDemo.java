package com.tutorial.hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import com.tutorial.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// use session object to save java object
			Student theStudent = new Student("Asmir", "Kopic", "asmir@email.com");
			
			System.out.println("Beggining transaction...");
			session.beginTransaction();
			
			System.out.println("Saving the object..");
			session.save(theStudent);
			
			session.getTransaction().commit();
			System.out.println("Done.");
			
		} finally {
			session.close();
		}
	
	}

}
