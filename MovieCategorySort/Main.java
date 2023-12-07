/*
 Jonathan Robinson
 COP2552.0M1 Object Oriented Programming 2
 Write a Java program that will use array lists, inheritance, and files to display a movie list by genre.

	To keep the scope within the current sprint, I have been tasked to write a program that will read in an input file of movie data.
 There are multiple genres of movies listed within the input file.  The object is to read each movie and its corresponding data from 
 the input file and place it into the proper movie genre.  When the program ends, the program will display a list of movies for each 
 genre using dialog boxes.

		~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
	Main class will only execute the methods from the InputMovies Class.
*/

public class Main {

    public static void main(String[] args) {
        InputMovies genre = new InputMovies();
        genre.driver();
    }

}