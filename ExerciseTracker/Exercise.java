import javax.swing.JOptionPane;
//Jonathan Robinson
//COP2552.0M1

public class Exercise {
	
	//Fields to be used in this class and the Child classes.
	double time = 0;
	double totalTime = 0;
	double totalCal = 0;
	
	// Method to catch if the user enters in a number out of the correct range.
	public static void EntryError(int number, int low, int high) 
	{
		// If the number is less than the lowest number or higher than the highest number 
		// a Dialog will display telling them to enter in a proper number
		if(number < low || number > high)
		{
			JOptionPane.showMessageDialog(null, "Incorrect Entry\n Please enter a correct number");
		}
	}
	
	// Displays a menu for the user to select which activity they did.
	public static String DisplayMenu() 
	{
		int pick; 	// Place holder to change String choice to an integer
		String choice;	// For the users entry
		
		// Do while loop to welcome the user and if they enter in a wrong number
		// display the EntryError method to prompt for reEntry
		do {
				// Dialog box to take the users input
			choice = JOptionPane.showInputDialog("Activity Monitor\n\n"		
					+ "Press 1 for Bicycle\n"
					+ "Press 2 for Running/Jogging\n"
					+ "Press 3 for Swimming\n"
					+ "Press 4 for Walking\n"
					+ "Press 5 for Weight Training\n"
					+ "Press 6 for Exit\n");
			pick = Integer.parseInt(choice);	// Changes the choice to an integer
			EntryError(pick, 1, 6);
		}while(pick < 1 || pick > 6); 	// If pick is less or more than the menu numbers it will display the menu again
		return choice;	// Returns the users choice to be used elsewhere as a string
	}
	
	// Displays a choice of how intense the activity.
	// very similar to the DisplayMenu method but returns a different data type
	public static int GetIntensity() 
	{
		int intensity;	// Used to convert choice to an integer
		String choice;	// For the users entry
		do {
		choice = JOptionPane.showInputDialog("Your Workout Intensity\n\n"
				+ "Press 1 for moderate\n"
				+ "Press 2 for vigorous");
		intensity = Integer.parseInt(choice);	// Changes the choice to an integer
		EntryError(intensity, 1, 2);
		}while(intensity < 1 || intensity > 2);	// If intensity is less or more than the users entry it will display the choices again
		return intensity;
	}
	
	// Sets the time to what the user enters in then adds it to the total time
	public double setTime(double time)
	{
		this.time = time;
		totalTime = totalTime + time;
		return totalTime;
	}
	
	// Formula method to calculate the total number of calories burned in the time entered.
	public double GetTotalCal(double time, double calories) 
	{
		double burn = time * calories;	//Holds value for the calories burned
		totalCal = totalCal + burn;	// Adds the value of burned calories to the total 
		return totalCal;	// returns the value
		
	}
	
	public String GetExerciseValues(int choice, String prompt, String exercise, double mod, double vig) 
	{
		String result;	//This will be the phrase for the final amount of calories and time for the exercise
		String timeInput = JOptionPane.showInputDialog(prompt);	// Prompts the user with data that is needed from the child classes
		time = Double.parseDouble(timeInput);	//Converts the users time entry into a double
		totalTime = setTime(time);	// Sets the total time to be updated with the current amount of exercise time.
		
		// Moderate exercise activity
		if(choice == 1) {
			GetTotalCal(time, mod);	// mod represents what the child class designates calorie burn should be for moderate
		}
		// Vigorous exercise
		else {
			GetTotalCal(time, vig);	// vig represents what the child class designates calorie burn should be for vigorous
		}
		// name of the exercise, total calories burned, and the total time made into a String 
		result = exercise + "\n" +
				"Calories: " + String.format("%.1f", totalCal) + "\n" +
				"Total Time: " + String.format("%.1f", totalTime) + " min\n\n";
		return result;
	}
}
