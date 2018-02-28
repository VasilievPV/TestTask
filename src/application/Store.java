package application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import java.util.TreeMap;

public class Store
{
	//Fields
	private boolean isOpen;
	private double cashBox;
	private Map<String, Drink> productRange;
	private int extraCharge;
	private StoreEmulation storeEmulation;
	
	
	//Constructors
	public Store()
	{
		this.isOpen = false;
		this.cashBox = 0;
		this.productRange =new TreeMap<String,Drink>(
				new Comparator<String>() {
					@Override
					public int compare(String k1, String k2)
					{
						return productRange.get(k2).compareTo(productRange.get(k1));
					}
				}
			);
		this.storeEmulation = new StoreEmulation(this);
		this.storeEmulation.startEmulation();
		
	}
	
	
	//Methods
	public void open ()
	{
		this.isOpen = true;
		this.productRange = Reader.read(Constants.DATABASE_FILE_NAME);
		this.sortProductRange();
		
		System.out.println("Store opened");
	}
	
	public void close()
	{
		this.isOpen = false;
		Writer.write(Constants.DATABASE_FILE_NAME, this.sortProductRange());
		
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
	
	private Collection<Drink> sortProductRange()
	{
		List<Drink> pRange = new ArrayList<Drink>(this.productRange.values());
		Comparator<Drink> cmp = new Comparator<Drink>() {
			
			@Override
			public int compare(Drink d1, Drink d2)
			{
				return d2.compareTo(d1);
			}
		};
		
		Collections.sort(pRange, cmp);
		return pRange;
	}
	
	public void cellProducts()
	{
		Buyer b = new Buyer();
		String[] drinksToBuy = b.buy(new ArrayList<String>(this.productRange.keySet()));
		for (String drink : drinksToBuy)
		{
			try
			{
				Drink d = this.productRange.get(drink);
				d.reduceAmount();
				double price = d.getPurPrice() + (d.getPurPrice() * 100 / this.extraCharge);
				this.cashBox += price;
				System.out.println("Drink " + d.getName() + " was sold. price: " + price);
			}
			catch(NullPointerException e)
			{
				System.out.println("Visitor didn`t purchases");
			}
		}
	}
}
