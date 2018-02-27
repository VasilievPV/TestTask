package application;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

public class Store
{
	//Fields
	private boolean isOpen;//rename
	private double cashBox;
	private Map<String, Drink> productRange;
	private int extraCharge;
	private StoreEmulation storeEmulation;
	
	
	//Constructors
	public Store()
	{
		this.isOpen = false;
		this.cashBox = 0;
		this.setComparator();
		this.storeEmulation= new StoreEmulation(this);
		this.storeEmulation.startEmulation();
		
	}
	
	
	//Methods
	public void open ()
	{
		this.isOpen = true;
		this.productRange = Reader.read(Constants.DATABASE_FILE_NAME);
		
		System.out.println("Store opened");
	}
	
	public void close()
	{
		this.isOpen = false;
		Writer.write(Constants.DATABASE_FILE_NAME, this.productRange);
		
		System.out.println("Store closed");
	}

	public void addDrink(String name, double purPrice, String kind, double volume, int amount, double alcoAmount, String...constituents )
	{
		try
		{
			this.productRange.put(name, this.createDrink(name, purPrice, kind, volume, amount, alcoAmount, constituents));
			System.out.println(name + " added in amount of " + amount);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Map<String, Drink> getProductRange()
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


	public int getExtraCharge() 
	{
		return extraCharge;
	}


	public void setExtraCharge(int extraCharge)
	{
		this.extraCharge = extraCharge;
	}
	
	public Drink createDrink(String name, double purPrice, String kind, double volume, int amount, double alcoAmount, String...constituents)
	{
		if(constituents != null)
		{
			return new NonAlcoholDrink(name, purPrice, kind, volume, amount, constituents);
		}
		else
		{
			return new AlcoholDrink(name, purPrice, kind, volume, amount, alcoAmount);
		}
	}
	
	private void setComparator()
	{
		this.productRange = new TreeMap<String,Drink>(
				new Comparator<String>() {
					@Override
					public int compare(String k1, String k2)
					{
						return productRange.get(k2).compareTo(productRange.get(k1));
					}
				}
				);
	}
}
