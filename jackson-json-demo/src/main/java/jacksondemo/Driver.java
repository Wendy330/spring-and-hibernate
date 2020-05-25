package jacksondemo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {
			
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON from file and map/convert to Java POJO
			Student myStudent = mapper.readValue(new File("data/sample.json"), Student.class);
			
			// also print individual items
			System.out.println("First name = " + myStudent.getFirstName());
			System.out.println("Last name = " + myStudent.getLastName());	
			
			Address tempAddress = myStudent.getAddress();
			System.out.println("Street = " + tempAddress.getStreet());
			System.out.println("City = " + tempAddress.getCity());
			
			for(String tempLang : myStudent.getLanguages()) {
				System.out.println(tempLang);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
