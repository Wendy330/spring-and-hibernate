package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Student.class)
													.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a student object
			
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Hebe new", "Tien", "hebe.tien@atune.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student object " + tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			// get new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student theStudent = session.get(Student.class, tempStudent.getId());
			
			session.getTransaction().commit();
			
			System.out.println("Get student: " + theStudent);
			System.out.println("Get student first name: " + theStudent.getFirstName());

			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
