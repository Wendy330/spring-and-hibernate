package aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	
	public static void main(String[] args) {
		// Read Spring config Java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from Spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("\nMain Program: AroundDemoApp");
		myLogger.info("\nCalling getFortune");
		
		boolean tripWire = true;
		String data = theFortuneService.getFortune(tripWire);
		
		myLogger.info("\nMy fortune is: " + data + "\nFinished");
		
		// Close the context
		context.close();
	}

}
