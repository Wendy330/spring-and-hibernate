package aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aopdemo.dao.AccountDAO;
import aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// Read Spring config Java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from Spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class); 
		
		// Call the business method
		theAccountDAO.addAccount(new Account(), true);
		theAccountDAO.doWork();
		
		theMembershipDAO.addAccount();
		theMembershipDAO.goToSleep();
		
		// Close the context
		context.close();
	}

}
