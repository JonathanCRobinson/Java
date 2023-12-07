/*
 Jonathan Robinson
 COP2552.0M1 Object Oriented Programming 2
 Write a Java program that will use array lists, inheritance, and files to display a movie list by genre.

	To keep the scope within the current sprint, I have been tasked to write a program that will read in an input file of movie data.
 There are multiple genres of movies listed within the input file.  The object is to read each movie and its corresponding data from 
 the input file and place it into the proper movie genre.  When the program ends, the program will display a list of movies for each 
 genre using dialog boxes.

		~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
	This class will create the displays for the information pulled from the input file. As the data is read from the input file, the information
	will be separated and organized into their respected fields to be reassembled into the display format of genres.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;

public class InputMovies {

    // reference of the movie file name
    private File movieFile = new File("C:/SFC/COP2552/Project5/MovieListing.txt");
    
    // Store Director and Composer
    ArrayList<String> productionTeam = new ArrayList<>();

    // Store for each ArrayList this will allow for easier manipulation of each array list
    ArrayList<ArrayList<Movie>> genreStore = new ArrayList<>();

    // Genre Storage lists
    ArrayList<Movie> scifi = new ArrayList<>();
    ArrayList<Movie> adventure = new ArrayList<>();
    ArrayList<Movie> drama = new ArrayList<>();
    ArrayList<Movie> war = new ArrayList<>();
    ArrayList<Movie> romance = new ArrayList<>();
    ArrayList<Movie> thriller = new ArrayList<>();
    ArrayList<Movie> fantasy = new ArrayList<>();

    // Read values from the file and store each movie object into the movieInfo array list
    private void readMovieInfo() {

        try (Scanner scanner = new Scanner(movieFile);) {

            // step through the file
            while (scanner.hasNext()) {

                String line = scanner.nextLine();

                String[] tokens = line.split("[,]");

                // If no commas are detected it is a name, so store this name
                if (!line.contains(",")) {

                    productionTeam.add(line);
                }
                
                // If file format is proper the movie objects will start to be created
                else if (line.contains(",") && tokens.length == 4) {

                    setGenres(new Movie(productionTeam.get(0), productionTeam.get(1), tokens[0], tokens[1], tokens[2],
                            tokens[3]));
                }
                
                // Invalid data in file
                else {
                	System.out.println("Error in the movie data file.");
                }
            }

        } catch (FileNotFoundException e) {

            System.out.println("Files do not exist in the current directory, please locate the files then try again.");
            System.exit(0);
        }
    }

    /*
    Receive a movie object from the reader function for movie data sort to proper
    list based on the genre of the movie.
     
    Once added to the proper genre list the list reference will be added to the
    genre store ArrayList.
    */
    private void setGenres(Movie movie) {

        switch (movie.getMovieGenre().replaceAll("\\s", "").toLowerCase()) {

        case "scifi":
            scifi.add(movie);
            break;

        case "adventure":
            adventure.add(movie);
            break;

        case "drama":
            drama.add(movie);
            break;

        case "war":
            war.add(movie);
            break;

        case "romance":
            romance.add(movie);
            break;

        case "thriller":
            thriller.add(movie);
            break;

        case "fantasy":
            fantasy.add(movie);
            break;
        default:
            JOptionPane.showMessageDialog(null, "Genre type specified does not exist!");
            System.exit(1);
            break;
        }
    }

    //Order every list stored within the genre store ArrayList
    private void orderGenreLists() {

        for (ArrayList<Movie> movie : genreStore) {

            sortListObject(movie);	// receives movie object to be sorted
        }
    }

    // Order lists then display the lists to the user
    private void displayGenreLists() {

        for (ArrayList<Movie> movie : genreStore) {

            formatMovieInfo(movie);	// receives movie object to be formated 
        }
    }

	// Add each genre ArrayList to the Genre Storage list for manipulation
    private void createGenreList() {

        genreStore.add(scifi);
        genreStore.add(adventure);
        genreStore.add(drama);
        genreStore.add(war);
        genreStore.add(romance);
        genreStore.add(thriller);
        genreStore.add(fantasy);
    }

    // Receive a movie object from the reader function for movie data sort to proper list based on the genre of the movie  
    private void sortListObject(ArrayList<Movie> aList) {

        // receives ArrayList of Movie objects to be sorted
        aList.sort((Movie m1, Movie m2) -> Integer.compare(Integer.parseInt(m1.getMovieYear().replaceAll("\\s", "")),
                Integer.parseInt(m2.getMovieYear().replaceAll("\\s", ""))));
    }

    // Format the movie output of a given genre array list
    private void formatMovieInfo(ArrayList<Movie> genreArrayList) {

        // Constants for the JEditorPane
        JEditorPane display = new JEditorPane();
        display.setContentType("text/html"); // Will be set to organize the data into a table format.
        display.setEditable(false);

        // Variable to be used as the final display string
        String output = "";

        // Get composer and director data and add to the output variable
        String productionString = "<HTML><H2>" + "Director: " + genreArrayList.get(0).getDirector() + "</H2>";
        productionString += "\n<H2>" + "Composer: " + genreArrayList.get(0).getComposer() + "</H2>";

        // Get current genre for the display
        String genreString = "\n\n<H2>Genre: " + genreArrayList.get(0).getMovieGenre() + "</H2>\n";

        // Adds the headers for the data table
        String dataHeaderString = "<table> <tr><th align = 'left'><H2>Movie Title</H2></th> <th align = 'left'><H2>Year Released</H2></th> <th align = 'left'><H2>Rating</H2></th> </tr>";

        // Concatenate all data
        output += productionString + genreString + dataHeaderString;

        // Loop through all entries in the current genre array list then add to output
        for (int i = 0; i < genreArrayList.size(); i++) {
            String movieInfo = genreArrayList.get(i).formatMovieTable();
            output += movieInfo;
        }

        // Display formatted output
        display.setText(output + "</table>"); // </table> is the ending for the dataHeaderString variable
        JOptionPane.showMessageDialog(null, display, genreArrayList.get(0).getMovieGenre() + " Movies",1);

    }

    // Calls the functions in the order of completion to then be called into main using the driver() function.
    public void driver() {

        readMovieInfo();
        createGenreList();
        orderGenreLists();
        displayGenreLists();

    }

}