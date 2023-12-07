/*
 * Jonathan Robinson
 * COP2552 OBJ ORIENT PG 2
 * Project 4 Storm Organizer
 * March 2023
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Category {
	Hurricane[] storms = new InputHurricanes().getArray();
	String sort;
	
	public void setOrder(String choice) {
		switch (choice) {
			case "1":
				sortAscending();
				break;
			
			case "2":
				sortDescending();
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "Choice not selected.");
				System.exit(0);
				break;
		}
	}
	
	public void getOrder() {
		String choice;
		choice = JOptionPane.showInputDialog(null, "Major Florida Hurricanes 1950 - 2020 \n\n Sort By Hurricane Category\n\n "
				+ "Press 1 for Ascending Order \n Press 2 for Descending Order");
		
		setOrder(choice);
	}
	
	public void sortAscending() {
		sort = "Ascending";
		Arrays.sort(storms, (first, second) ->

		Integer.compare(first.GetCategory(), (second.GetCategory()))
		);


		displayOutput(sort);

	}
	
	public void sortDescending() {
		sort = "Desceding";
		Arrays.sort(storms, (first, second) ->

		Integer.compare(second.GetCategory(), (first.GetCategory()))
		);

		displayOutput(sort);
	}
	
	public void displayOutput(String order) {
		JTextArea textArea = new JTextArea("Major Florida Hurricanes 1950 - 2020 \n\n"
				+ "Sort By Hurricane Category in " + order + " Order\n\n" 
				+ " Name \t Category \t    Date\n");
		for(int i = 0; i < storms.length; i++) {
			String name = storms[i].GetName();
			int category = storms[i].GetCategory();
			String date = storms[i].GetDate();
			textArea.append(name + "\t    " + category + "\t" + date +"\n");
		}
		JOptionPane.showMessageDialog(null, textArea);	
		writeToFile();
	}
	
	private void writeToFile() {
		try {
			PrintWriter write = new PrintWriter("C:/SFC/COP2552/Project4/SortByCategory.txt");
			write.println("Major Florida Hurricanes 1950 - 2020");
			write.println("Sort By Hurricane Category\n");
			for(int i = 0; i < storms.length; i++) {
				String name = storms[i].GetName();
				int category = storms[i].GetCategory();
				String date = storms[i].GetDate();
				
				write.println(name + "," + category + ":" + date);
			}
			write.close();
		} 
		catch (FileNotFoundException e) {
			System.exit(0);
		}
		
	}
	
	public float getTotal() {
		float total = 0;
		for(int i = 0; i < storms.length; i++) {
			total = total + storms[i].GetCategory();
		}
		return total;
	}
	
	public void getAverage() {
		String averageDisplay;
		float average = getTotal()/storms.length;
		averageDisplay = String.format("Major Florida Hurricanes 1950 - 2020 \n\n"
				+ "Average Storm Category by Saffir-Simpson Scale \n\n"
				+ "Average storm category is %.1f", average);
		JOptionPane.showMessageDialog(null, averageDisplay);	
	}
	
	String[] str = new String[6];
	 
	private void getCategoryCount() {
		Arrays.stream(storms).collect(Collectors.groupingBy(storms -> storms.GetCategory()))
        .forEach((occurrence, count) -> str[occurrence] = "Total category " + occurrence + " hurricanes: " + count.size());           
    }
	
	public void displayAggregate() { 
        StringBuilder builder = new StringBuilder(str.length);
        for (int i = 1; i < str.length; builder.append(str[i++])) {
            builder.append("\n");
        }
        JOptionPane.showMessageDialog(null, "Major Florida Hurricanes 1950 - 2020\n\n"
        		+ "Aggregate Totals by Category (Saffor-Simpson scale)\n\n"
        		+ "Total Number of Hurricanes listed: " + storms.length 
        		+ "\n" + builder.toString());
	}
	
	public void getAggregate() {
		getCategoryCount();
		displayAggregate();
	}
	
	public void displayCategory() {
		getOrder();
	}
}
