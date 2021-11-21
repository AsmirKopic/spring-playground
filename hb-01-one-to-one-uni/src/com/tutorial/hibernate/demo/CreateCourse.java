package com.tutorial.hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import com.tutorial.hibernate.demo.entity.Course;
import com.tutorial.hibernate.demo.entity.Instructor;
import com.tutorial.hibernate.demo.entity.InstructorDetails;
import com.tutorial.hibernate.demo.entity.Review;
import com.tutorial.hibernate.demo.entity.Student;

public class CreateCourse {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetails.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			// get instructor from database
			
			Course course = session.get(Course.class, 10);
//			
//			course.addReview(new Review("Great course!!!"));
//			course.addReview(new Review("One of the best, keep going"));
//			course.addReview(new Review("Dont waste your time, learn faster!"));
//			
//			
//			
//			System.out.println("List of reviews for " + course + "\n" + course.getReviews());

			session.delete(course);
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	
	}

}
