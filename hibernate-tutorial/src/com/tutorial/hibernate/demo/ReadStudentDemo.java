package com.tutorial.hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

import java.util.List;

import javax.sound.midi.Soundbank;

import org.hibernate.Session;

import com.tutorial.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// use session object to save java object
			Student theStudent = new Student("Asmir", "Kopic", "asmir.kopic@email.com");
			
			System.out.println("Beggining transaction...");
			session.beginTransaction();
			
			System.out.println("Saving the object..");
			session.save(theStudent);
			
			session.getTransaction().commit();
			System.out.println("Object saved. Object ID generated: " + theStudent.getId());
			
			// retrieve object from database
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, theStudent.getId());
			session.getTransaction().commit();
			
			System.out.println(myStudent);
			
			// get list from table
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			List<Student> students = session.createQuery("from Student s where s.firstName='Asmir'").getResultList();
			
			students.forEach(student -> System.out.println(student));
			
			
			
		} finally {
			session.close();
		}
	
	}

}
