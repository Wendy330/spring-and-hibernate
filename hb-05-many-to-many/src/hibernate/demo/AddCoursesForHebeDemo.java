package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;
import hibernate.demo.entity.Student;

public class AddCoursesForHebeDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.addAnnotatedClass(Course.class)
													.addAnnotatedClass(Review.class)
													.addAnnotatedClass(Student.class)
													.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			Student theStudent = session.get(Student.class, 1);
			
			Course tempCourse1 = new Course("Java");
			Course tempCourse2 = new Course("C#");

			tempCourse1.addStudent(theStudent);
			tempCourse2.addStudent(theStudent);
			
			session.save(tempCourse1);
			session.save(tempCourse2);
	
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
