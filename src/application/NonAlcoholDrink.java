package application;

import java.util.ArrayList;
import java.util.List;


public class NonAlcoholDrink extends Drink
{
	private List<String> composition;
	
	public NonAlcoholDrink()
	{
		super();
		this.composition = new ArrayList<String>();
	}
	
	public NonAlcoholDrink(String name, double purPrice, String kind, double volume, int amount, String constituents)
	{
		super(name,purPrice,kind,volume,amount);
		this.composition = new ArrayList<String>();
		String line = constituents.substring(1, constituents.length() - 1);
		String[] arrConstituents = line.split(", ");
		for(String s : arrConstituents)
		{
			this.composition.add(s);
		}
	}
	
	public NonAlcoholDrink(String name, double purPrice, String kind, double volume, int amount, String... constituents)
	{
		super(name,purPrice,kind,volume,amount);
		this.composition = new ArrayList<String>();
		for(String s : constituents)
		{
			this.composition.add(s);
		}
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder(super.toString());
		
		if (this.composition.size() > 0)
		{
			sb.append(", \"");
			for(String s : this.composition)
			{
				sb.append(s);
				if (this.composition.indexOf(s) == this.composition.size() - 1)
					sb.append("\"");
				else
					sb.append(", ");
			}
			sb.append(System.lineSeparator());
		}
		else
			System.out.println("Error: Drink havn`t composition;");
		
		return sb.toString();
	}
	
	public String getName()
	{
		return super.getName();
	}
	
	public int compareTo(Drink d)
	{
		if(d instanceof AlcoholDrink)
		{
			return -1;
		}
		if(d instanceof NonAlcoholDrink)
		{
			return 1;
		}
		return 66;
	}
}
