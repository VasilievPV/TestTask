package application;

import java.util.ArrayList;
import java.util.List;


public class UnAlñoholDrink extends Drink
{
	private List<String> composition;
	
	public UnAlñoholDrink()
	{
		super();
		this.composition = new ArrayList<String>();
	}
	
	public UnAlñoholDrink(String name, double purPrice, String kind, double volume, int amount, String... constituents)
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
		}
		else
			System.out.println("Error: Drink havn`t composition;");
		
		return sb.toString();
	}
}
