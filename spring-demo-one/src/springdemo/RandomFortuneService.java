package springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	private String[] fortuneList = { 
			"Beware of the wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};
	
	private Random random = new Random();

	@Override
	public String getFortune() {
		return fortuneList[random.nextInt(fortuneList.length)];
	}

}
