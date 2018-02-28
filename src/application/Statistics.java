package application;

import java.util.Map;

public class Statistics 
{
	private double profit;
	private double loss;
	private Map<String,Drink> productRange;
	
	
	public Statistics(Map<String,Drink> productRange)
	{
		this.productRange = productRange;
	}
	
	public void productSoldReport(Drink drink, double price)
	{
		this.profit += price - drink.getPurPrice();
	}
	
	public void productPurchasedReport(Drink drink, int amount)
	{
		
	}
	
	public String toString()
	{
		return "";
	}
}
