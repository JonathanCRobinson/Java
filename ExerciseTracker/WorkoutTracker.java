// Jonathan Robinson
// COP2552.0M1
/*
* For any person with an active lifestyle and trying to maintain weight, 
keeping up with the number of minutes exercising and the number of calories burned is important.

* This project will keep track of a person's activity in minutes and calculating 
the number of calories burned while exercising.

* The number of calories burned depends on several factors such as the weight of the
individual, duration, and intensity. To keep this project within scope, only a few options will be available in which to choose.

* When the application begins, the number of minutes exercised and the number of calories 
burned will be 0. The user will continue to be prompted what they have completed until the user wishes to exit.

* Give the user a menu of various types of exercises. From 
there, prompt the user for the intensity level used when exercising.
 */

public class WorkoutTracker {
	public static void main(String[] args) {
		
		SwitchSelection();
	}
	
	// Method to be called into main to start the main menu
	public static void SwitchSelection() {
		
		// Creates instances of each of the child classes of Exercise.java Class
		Bike bike = new Bike();
		Run run = new Run();
		Swim swim = new Swim();
		Walk walk = new Walk();
		Weight weight = new Weight();
		
		// Starts the menu and gets the users activity from the method
		String choice = Exercise.DisplayMenu();
		boolean end = false;	// Creates an end for the switch loop
		while(end == false) 
		{
			// Switch case for the first menu to select which exercise was done
			switch(choice) {
				case "1": //Switch for the biking calories burned
					int intensity = Exercise.GetIntensity();
					choice = bike.GetCaloriesBurned(intensity);
					break;
				case "2": //Switch for the Running calories burned
					intensity = Exercise.GetIntensity();
					choice = run.GetCaloriesBurned(intensity);
					break;
				case "3": //Switch for the Swimming calories burned
					intensity = Exercise.GetIntensity();
					choice = swim.GetCaloriesBurned(intensity);
					break;
				case "4": //Switch for the Walking calories burned
					intensity = Exercise.GetIntensity();
					choice = walk.GetCaloriesBurned(intensity);
					break;
				case "5": //Switch for the Weight Training calories burned
					intensity = Exercise.GetIntensity();
					choice = weight.GetCaloriesBurned(intensity);
					break;
				case "6": //Exits the program and displays all the activities participated in and the stats
					ExitProgram.DisplayTotals();
					end = true;
			}
		}
	}
}
