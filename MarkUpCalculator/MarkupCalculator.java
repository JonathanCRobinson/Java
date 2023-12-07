// Jonathan Robinson
// COP2552.0M1
// Markup price calculator class.

public class MarkupCalculator {
	
	// Fields
	private float percentage, newPrice;
	
	// Method to get the new price of a Markup sale item
	public void Price(float firstPrice, float markup)
	{
		percentage = markup/100;
		newPrice = firstPrice + (firstPrice * percentage);
	}
	
	// returns the new price value
	public float getPrice()
	{
		return newPrice;
	}
}
