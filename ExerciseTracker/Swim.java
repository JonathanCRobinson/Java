// Jonathan Robinson
// COP2552.0M1

public class Swim extends Exercise{

	static String swim = "";	// Static value to hold the information of the Swimming activity
	String prompt = "How many minutes did you swim?";
	String exercise = "Swimming Exercise";
	
	public String GetCaloriesBurned(int choice)
	{
		// Sets the swim value to the result String from the GetExerciseValues method
		// Moderate being 6.8 calories burned per minute
		// Vigorous being 14.8 calories burned per minute
		swim = GetExerciseValues(choice, prompt, exercise, 6.8, 14.8);
		String pick = DisplayMenu();
		return pick;
	}
}
