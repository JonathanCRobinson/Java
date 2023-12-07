// Jonathan Robinson
// COP2552.0M1
// Markup price calculator program. Asks a user for a price, price increase percentage
// and then tells the user the new price.

import javax.swing.JOptionPane;

public class Markup {
	public static void main(String[] args) {
		
		String inputString;
		String itemNumber, itemDescription;
		float price, markup;
		
		// Get the item information using popup input boxes
		// Asks for the item number
		itemNumber = JOptionPane.showInputDialog("Markup Calculator\n\n"
				+ "Item Number:");
		
		//Asks for the previous item number's description
		itemDescription= JOptionPane.showInputDialog("Item " + itemNumber + " Description:");
		
		// Asks for the price of the item
		inputString = JOptionPane.showInputDialog("Current price of item " + itemNumber + ":");
		price = Float.parseFloat(inputString);
		
		// Finally asks for the percent that will increase the base price of the item.
		inputString = JOptionPane.showInputDialog("Enter the price markup percent:");
		markup = Float.parseFloat(inputString);
		
		// Create new instance for the MarkupCalculator Class to get the new price
		MarkupCalculator item = new MarkupCalculator();
		
		// Method in the other class to return the new price value  
		// using the original price and it's markup percentage.
		item.Price(price, markup);
		
		// Display inputs
		JOptionPane.showMessageDialog(null, 
				"Item Number: " + itemNumber + "\n" +
				"Description: " + itemDescription + "\n" +
				String.format("Current Price: $%,.2f\n\n", price) + 
				String.format("New Price: $%,.2f", item.getPrice()));
	}
}