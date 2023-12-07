/*
 Jonathan Robinson
 COP2552.0M1 Object Oriented Programming 2
 Write a Java program that will use array lists, inheritance, and files to display a movie list by genre.

	To keep the scope within the current sprint, I have been tasked to write a program that will read in an input file of movie data.
 There are multiple genres of movies listed within the input file.  The object is to read each movie and its corresponding data from 
 the input file and place it into the proper movie genre.  When the program ends, the program will display a list of movies for each 
 genre using dialog boxes.

		~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
	This will be the Superclass that the program will use to build the objects.
*/

public class Production {

	protected String directorName;
	protected String composerName;

	//Constructor for the class
	public Production(String dir, String comp) {

		directorName = dir;
		composerName = comp;
	}

	//Initialize the object with default values
	Production() {

		directorName = "";
		composerName = "";
	}

	//Methods for accessing the directors and composers names.
	public void setDirector(String name) {

		directorName = name;
	}

	public void setComposer(String name) {

		directorName = name;
	}

	//Methods for retrieving the directors and composers names.
	public String getDirector() {

		return directorName;
	}

	public String getComposer() {

		return composerName;
	}

	//Print out the organized Production Object into a readable string
	@Override
	public String toString() {

		// Print to the Console also
		System.out.println("Director Name: " + directorName);
		System.out.println("Composer Name: " + composerName);

		return "Director Name: " + directorName + "\n" + "Composer Name: " + composerName;
	}
}