/*
 Jonathan Robinson
 COP2552.0M1 Object Oriented Programming 2
 Write a Java program that will use array lists, inheritance, and files to display a movie list by genre.

	To keep the scope within the current sprint, I have been tasked to write a program that will read in an input file of movie data.
 There are multiple genres of movies listed within the input file.  The object is to read each movie and its corresponding data from 
 the input file and place it into the proper movie genre.  When the program ends, the program will display a list of movies for each 
 genre using dialog boxes.

		~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
	Subclass that extends from the Production Superclass to define the data more clearly
*/

public class Movie extends Production {
	
	// Fields
    private String movieTitle;
    private String movieYear;
    private String movieGenre;
    private String movieRating;

    // Constructor for the class
    public Movie(String dir, String comp, String title, String year, String genre, String rating) {

        super(dir, comp);
        movieTitle = title;
        movieYear = year;
        movieGenre = genre;
        movieRating = rating;
    }

    // Initialize the object with default values
    Movie() {

        movieTitle = "";
        movieYear = "";
        movieGenre = "";
        movieRating = "";
    }

    // Methods for retrieving data about the movie
    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public String formatMovieTable() {

        return "<tr><td align = 'left'>" + movieTitle + "</td><td align = 'center'>" + movieYear + "</td><td align = 'center'>" + movieRating + "</td></tr>";        
    }

}