package springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {
	
	private String fileName = "src/fortune-data.txt";
	private List<String> fortunes;
	
	private Random myRandom = new Random();
	
	public DatabaseFortuneService() {
		File theFile = new File(fileName);
		
		System.out.println("Reading fortunes from file: " + theFile);
		System.out.println("File exists: " + theFile.exists());
		
		// initialize array list
		fortunes = new ArrayList<String>();
		
		// read fortunes from file
		try (BufferedReader br = new BufferedReader(new FileReader(theFile))) {

			String tempLine;

			while ((tempLine = br.readLine()) != null) {
				fortunes.add(tempLine);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String getFortune() {
		return fortunes.get(myRandom.nextInt(fortunes.size()));
	}

}