package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Student.class)
													.buildSessionFactory();
		try {
			int studentId = 1;
		
			// create session
			Session session = factory.getCurrentSession();
			
			// start a transaction
			session.beginTransaction();
			
			Student theStudent = session.get(Student.class, studentId);
			
			theStudent.setFirstName("Fuzhen");
			
			// save the student object
			System.out.println("Updating the student object " + theStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email='hebe@atune.com'").executeUpdate();
			
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
