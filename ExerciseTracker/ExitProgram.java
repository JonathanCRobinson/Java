import javax.swing.JOptionPane;
//Jonathan Robinson
//COP2552.0M1

public class ExitProgram{
	public static void DisplayTotals() 
	{
		// Gets the values of the Strings from each of the child classes and creates a display dialog box
		String display = "Activity Monitor\n\n" + Bike.bike + Run.run + Swim.swim + Walk.walk + Weight.weight +"Thank you for using the program!\n\n";
		JOptionPane.showMessageDialog(null, display);
	}
}
