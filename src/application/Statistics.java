package application;

public class Statistics 
{
	private double profit;
	private double loss;
	
	public Statistics()
	{
		
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
