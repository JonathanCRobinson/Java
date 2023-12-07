// Jonathan Robinson
// COP2552.0M1

public class Walk extends Exercise{

	static String walk = "";	// Static value to hold the information of the Walking activity
	String prompt = "How many minutes did you walk?";
	String exercise = "Walking Exercise";
	
	public String GetCaloriesBurned(int choice)
	{
		// Sets the walk value to the result String from the GetExerciseValues method
		// Moderate being 5 calories burned per minute
		// Vigorous being 5.6 calories burned per minute
		walk = GetExerciseValues(choice, prompt, exercise, 5, 5.6);
		String pick = DisplayMenu();
		return pick;
	}
}
