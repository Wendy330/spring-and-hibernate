package springdemo;

public class GolfCoach implements Coach {
	
	private RandomFortuneService randomFortuneService;
	
	private GolfCoach(RandomFortuneService randomFortuneService) {
		this.randomFortuneService = randomFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Play Golf everyday for 30 mins";
	}

	@Override
	public String getDailyFortune() {
		return randomFortuneService.getFortune();
	}

}
