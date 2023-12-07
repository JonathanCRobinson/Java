/*
 * Jonathan Robinson
 * COP2552 OBJ ORIENT PG 2
 * Project 4 Storm Organizer
 * March 2023
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

import javax.swing.*;

public class Year {
	Hurricane[] storms = new InputHurricanes().getArray();
	
	private void setOrder(String choice) {
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
	
	private void getOrder() {
		String choice;
		choice = JOptionPane.showInputDialog(null, "Major Florida Hurricanes 1950 - 2020 \n\n Sort By Year\n\n "
				+ "Press 1 for Ascending Order \n Press 2 for Descending Order");
		
		setOrder(choice);
	}
	
	private void sortAscending() {
		String sort = "Ascending";
		Arrays.sort(storms, (first, second) ->

		Integer.compare(first.GetYear(), (second.GetYear())));
		
		displayOrderOutput(sort);

	}
	
	private void sortDescending() {
		String sort = "Descending";
		Arrays.sort(storms, (first, second) ->

		Integer.compare(second.GetYear(), (first.GetYear())));

		displayOrderOutput(sort);
	}
	
	private void displayOrderOutput(String order) {
		JTextArea textArea = new JTextArea("Major Florida Hurricanes 1950 - 2020 \n\n"
				+ "Sort By Year in " + order + " Order\n\n" 
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
			PrintWriter write = new PrintWriter("C:/SFC/COP2552/Project4/SortByYear.txt");
			write.println("Major Florida Hurricanes 1950 - 2020");
			write.println("Sort By Hurricane Year\n");
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
	
	Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

    private void getYearCount() {
        Arrays.stream(storms).collect(Collectors.groupingBy(storms -> storms.GetYear()))
                .forEach((occurrence, count) -> hashMap.put(occurrence, count.size()));  
    }
    
    private void getLargestValue() {
        String[] result = new String[hashMap.size()];
        int maxVal = Collections.max((hashMap.values()));
        int i = 0;

        for (java.util.Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == maxVal) {
                result[i] = entry.getKey().toString();
                i++;
            }
        }
        displayMostActive(result);
    }
    
    private void displayMostActive(String[] str) {
        StringBuilder build = new StringBuilder(str.length);
        for (int i = 0; i < str.length && str[i] != null; build.append(str[i++]))
            if (i > 0) {
                build.append(" and ");
            } else if (i > 1) {
                build.append(", ");
            }
        JOptionPane.showMessageDialog(null, "Major Florida Hurricanes 1950 - 2020 \n\n" 
            + "Most active year were " + build.toString() + "\n"
            + "totaling at " + Collections.max((hashMap.values())) 
            + " Named Storms.");
    }
	
    private void getYearAggregate() {
    	Arrays.sort(storms, (first, second) ->
		Integer.compare(second.GetYear(), (first.GetYear())));
    	
    	JTextArea aggregateYear = new JTextArea("Major Florida Hurricanes 1950 - 2020 \n\n"
    			+ "Aggregate Totals by Year \n\n" 
    			+ "Year      Number of Storms\n");
		
    	Arrays.stream(storms).collect(Collectors.groupingBy(storms -> storms.GetYear()))
        .forEach((occurrence, count) -> hashMap.put(occurrence, count.size())); 
    	
    	
    	
    	for (java.util.Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int occurrence = entry.getKey();
            int count = entry.getValue();
            
            aggregateYear.append(occurrence + "\t" + count + "\n");
    	}
        JOptionPane.showMessageDialog(null, aggregateYear);
    }
    
	public void displayOrder() {
		getOrder();
	}
	
	public void displayActive() {
		getYearCount();
		getLargestValue();
	}
	
	public void displayAggregate() {
		getYearAggregate();
	}
}

