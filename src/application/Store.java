package application;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Store
{
	//Fields
	private boolean Is_Open;
	private double cashBox;
	private Hashtable<String, Drink> productRange;
	private int extraCharge;
	
	
	//Constructors
	public Store()
	{
		this.Is_Open = false;
		this.cashBox = 0;
		this.productRange = new Hashtable<String, Drink>();
		
	}
	
	
	//Methods
	public void open ()
	{
		this.Is_Open = true;
		this.productRange = Reader.read(Constants.DATABASE_FILE_NAME);
	}
	
	public void close()
	{
		this.Is_Open = false;
		Writer.write(Constants.DATABASE_FILE_NAME, this.productRange);
	}

	public void addDrink(String name, double purPrice, String kind, double volume, int amount, double alcoAmount, String...constituents )
	{
		try
		{
			if(constituents != null)
			{
				//this.productRange.add(new UnAlñoholDrink(name, purPrice, kind, volume, amount, constituents));
				this.productRange.put(name, new UnAlñoholDrink(name, purPrice, kind, volume, amount, constituents));
				System.out.println(name + " added in amount of " + amount);
			}
			else
			{
				//this.productRange.add(new AlcoholDrink(name, purPrice, kind, volume, amount, alcoAmount));
				this.productRange.put(name, new AlcoholDrink(name, purPrice, kind, volume, amount, alcoAmount));
				System.out.println(name + " added in amount of " + amount);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Hashtable<String, Drink> getProductRange()
	{
		return this.productRange;
	}
	
	public void purchaseExistingDrink(String name, int amount)
	{
		this.productRange.get(name).addAmount(amount);
	}
	
	public void setProductRange(Hashtable<String, Drink> productRange)
	{
		this.productRange = productRange;
	}
	
}
