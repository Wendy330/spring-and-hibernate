package hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Student.class)
													.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			displayStudents(session.createQuery("from Student").list());
			
			displayStudents(session.createQuery("from Student s where s.lastName='tien'").list());
			
			displayStudents(session.createQuery("from Student s where " + "s.lastName='Moon' or s.firstName='Gakki'").getResultList());
			
			displayStudents(session.createQuery("from Student s where " + "s.email LIKE '%gmail.com'").getResultList());
			 
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
