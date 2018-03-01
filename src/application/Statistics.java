package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Statistics 
{
	private double profit;
	private double loss;
	private Map<String,Drink> productRange;
	private List<DrinkStatistic> drinkStatistics; 
	
	private StringProperty profitProperty;
	
	
	public Statistics(Map<String,Drink> productRange)
	{
		this.productRange = productRange;
		this.drinkStatistics = new ArrayList<DrinkStatistic>();
		for(String s : productRange.keySet())
		{
			this.drinkStatistics.add(new DrinkStatistic(s));
		}
		this.profit = 0;
		this.loss = 0;
		this.profitProperty = new SimpleStringProperty(Double.toString(this.profit));
	}
	
	public void productSoldReport(Drink drink, double price)
	{
		this.profit += price - drink.getPurPrice();
		DrinkStatistic currentDs = null;
		for(DrinkStatistic ds : this.drinkStatistics)
		{
			if(ds.getName().equals(drink.getName()))
			{
				currentDs = ds;
			}
		}
		currentDs.incrimentSold();
		
		this.profit += price - drink.getPurPrice();
		this.profitProperty.set(Double.toString(this.profit));
	}
	
	public void productPurchasedReport(String name, int amount)
	{
		DrinkStatistic currentDs = null;
		for(DrinkStatistic ds : this.drinkStatistics)
		{
			if(ds.getName().equals(name))
			{
				currentDs = ds;
			}
		}
		currentDs.addPurchased(amount);
		this.loss += this.productRange.get(name).getPurPrice() * amount;
	}
	
	public StringProperty getProfitProperty()
	{
		return this.profitProperty;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(this.profit + System.lineSeparator());
		sb.append(this.loss + System.lineSeparator());
		for(DrinkStatistic ds : this.drinkStatistics)
		{
			sb.append(ds.toString());
		}
		
		return sb.toString();
	}
}
