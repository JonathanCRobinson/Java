// Jonathan Robinson
// COP2552.0M1

public class Run extends Exercise{

	static String run = "";	// Static value to hold the information of the Run/Jog activity
	String prompt = "How many minutes did you run or jog?";
	String exercise = "Running Exercise";

	public String GetCaloriesBurned(int choice)
	{		
		// Sets the run value to the result String from the GetExerciseValues method
		// Moderate being 12 calories burned per minute
		// Vigorous being 17 calories burned per minute
		run = GetExerciseValues(choice, prompt, exercise, 12, 17);
		String pick = DisplayMenu();
		return pick;
	}
}
