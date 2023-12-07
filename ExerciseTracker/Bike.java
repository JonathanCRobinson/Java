// Jonathan Robinson
// COP2552.0M1

public class Bike extends Exercise{
	
	static String bike = "";	// Static value to hold the information of the Bicycle activity
	String prompt = "How many minutes did you ride a bicycle?";	
	String exercise = "Biking Exercise";
	
	public String GetCaloriesBurned(int choice)
	{
		// Sets the bike value to the result String from the GetExerciseValues method
		// Moderate being 10 calories burned per minute
		// Vigorous being 14.3 calories burned per minute
		bike = GetExerciseValues(choice, prompt, exercise, 10, 14.3);
		
		// After the method is used from the Exercise parent class, the menu will display again
		String pick = DisplayMenu();
		return pick;
	}
}
