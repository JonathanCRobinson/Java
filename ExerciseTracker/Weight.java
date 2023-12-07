// Jonathan Robinson
// COP2552.0M1

public class Weight extends Exercise{
	
	static String weight = "";	// Static value to hold the information of the Weight Training activity
	String prompt = "How many minutes did you lift weights?";
	String exercise = "Weight Training Exercise" ;
	
	public String GetCaloriesBurned(int choice)
	{
		// Sets the Weight value to the result String from the GetExerciseValues method
		// Moderate being 3.7 calories burned per minute
		// Vigorous being 5.9 calories burned per minute
		weight = GetExerciseValues(choice, prompt, exercise, 3.7, 5.9);
		String pick = DisplayMenu();
		return pick;
	}
}
