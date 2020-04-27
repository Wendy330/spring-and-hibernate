package aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		// Read Spring config Java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from Spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> theAccounts = theAccountDAO.findAccounts(false);
		
		System.out.println("\n\nMain Program: AfterReturningDemoApp\n----");
		
		System.out.println(theAccounts);
		
		// Close the context
		context.close();
	}

}
