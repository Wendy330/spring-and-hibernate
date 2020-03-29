package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;
import hibernate.demo.entity.Student;

public class DeleteMathCourseDemo {

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
			
			Course theCourse = session.get(Course.class, 10);
			
			session.delete(theCourse);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
