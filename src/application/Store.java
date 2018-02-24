package application;

import java.util.ArrayList;
import java.util.List;

public class Store
{
	//Fields
	private boolean Is_Open;
	private double cashBox;
	private List<Drink> productRange;
	
	//Constructors
	public Store()
	{
		this.Is_Open = false;
		this.cashBox = 0;
		this.productRange = new ArrayList<Drink>();
	}
	
	
	//Methods
	public void open ()
	{
		this.Is_Open = true;
	}
	
	public void close()
	{
		this.Is_Open = false;
	}

	public void addDrink(String name, double purPrice, String kind, double volume, int amount, double alcoAmount, String...constituents )
	{
		try
		{
			if(constituents != null)
			{
				this.productRange.add(new UnAlñoholDrink(name, purPrice, kind, volume, amount, constituents));
				System.out.println(name + " added in amount of " + amount);
			}
			else
			{
				this.productRange.add(new AlcoholDrink(name, purPrice, kind, volume, amount, alcoAmount));
				System.out.println(name + " added in amount of " + amount);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<Drink> getProductRange()
	{
		return this.productRange;
	}
	
}
