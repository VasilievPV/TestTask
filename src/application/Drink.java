package application;

import java.util.Comparator;

public class Drink
{
	private String name;
	private double purPrice;
	private String kind;
	private double volume;
	private int amount;
	
	public Drink()
	{
		this.name = "";
		this.purPrice = 0;
		this.kind = "";
		this.volume = 0d;
		this.amount = 0;
	}
	
	public Drink(String name, double purPrice, String kind, double volume, int amount)
	{
		this.name = name;
		this.purPrice = purPrice;
		this.kind = kind;
		this.volume = volume;
		this.amount = amount;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("\"" + this.name + "\", ");
		sb.append(this.purPrice + ", ");
		sb.append("\"" + this.kind + "\", ");
		sb.append(this.volume + ", ");
		sb.append(this.amount);
		
		return sb.toString();
	}
	
	public void addAmount(int amount)
	{
		this.amount += amount;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int compareTo(Drink d)
	{
		return 0;
	}

}
