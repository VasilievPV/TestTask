package application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextArea;

public class Store
{
	//Fields
	@SuppressWarnings("unused")
	private boolean isOpen;
	private Map<String, Drink> productRange;
	private int extraCharge;
	private StoreEmulation storeEmulation;
	private TextArea output;
	private Statistics statistics;
	
	//Properties (javaFX)
	private StringProperty productRangeProperty;
	private StringProperty extraChargeProperty;
	
	
	//Constructors
	public Store(TextArea output)
	{
		this.productRangeProperty=new SimpleStringProperty();
		this.extraChargeProperty=new SimpleStringProperty();
		this.isOpen = false;
		this.productRange = new HashMap<String, Drink>();
		this.storeEmulation = new StoreEmulation(this);
		this.storeEmulation.startEmulation();
		this.output = output;
	}
	
	
	//Methods
	public void open ()
	{
		this.isOpen = true;
		this.productRange = Reader.read(Constants.DATABASE_FILE_NAME);
		this.statistics = Reader.readStatistics(Constants.STATISTICS_FILE_NAME, this.productRange);
		this.productRangeProperty.set(this.productRangeToString());
		
		//this.statistics=new Statistics(this.productRange);
		
		this.printReport("Store opened!");
	}
	
	public void close()
	{
		this.isOpen = false;
		Writer.write(Constants.DATABASE_FILE_NAME, this.sortProductRange());
		Writer.writeStatistics(Constants.STATISTICS_FILE_NAME, this.statistics);
		
		this.printReport("Store closed!");
	}

	public void addDrink(String name, double purPrice, String kind, double volume, int amount, double alcoAmount, String...constituents )
	{
		try
		{
			this.productRange.put(name, this.createDrink(name, purPrice, kind, volume, amount, alcoAmount, constituents));
			this.printReport(name + " added in amount of " + amount);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		this.productRangeProperty.set(this.productRangeToString());
	}
	
	public Map<String, Drink> getProductRange()
	{
		return this.productRange;
	}
	
	public void purchaseExistingDrink(String name, int amount)
	{
		this.productRange.get(name).addAmount(amount);
		this.statistics.productPurchasedReport(name, amount);
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
		this.extraChargeProperty.set(Integer.toString(extraCharge));
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
		int count = 0;
		double extraCharge = this.extraCharge;
		try
		{
			for (String drink : drinksToBuy)
			{
				count ++;
				Drink d = this.productRange.get(drink);
				if(count > 2)
				{
					extraCharge = Constants.MIN_EXTRACHARGE;
				}
					
				if(d.getAmount() > 0)
				{
					d.reduceAmount();
					double price = d.getPurPrice() + ((d.getPurPrice() * extraCharge )/ 100 );
					this.printReport("Drink \"" + d.getName() + "\" was sold. price: " + price);
					this.statistics.productSoldReport(d, price);
				}
				else
					this.printReport("Drink \"" + d.getName() + "\" is over");
			}
			
		}
		catch(NullPointerException e)
		{
			this.printReport("Visitor didn`t purchases");
		}
		
		this.productRangeProperty.set(this.productRangeToString());
	}
	
	public void printReport(String report)
	{
		try
		{
			this.output.appendText(report + System.lineSeparator());
		}
		catch(NullPointerException e)
		{
			System.out.println("Can`t print message!");
		}
	}
	
	public Statistics getStatistics()
	{
		return this.statistics;
	}
	
	public StringProperty getExtraChargeProperty()
	{
		return this.extraChargeProperty;
	}
	public StringProperty getProductRangeProperty()
	{
		return this.productRangeProperty;
	}
	public String productRangeToString()
	{
		StringBuilder sb = new StringBuilder();
		for(Drink d : this.productRange.values())
		{
			sb.append("\"" + d.getName() + "\" Amount: " + d.getAmount() + " Volume: "+ d.getVolume() + " Price: " + (d.getPurPrice() + this.extraCharge) + System.lineSeparator());
		}
		
		return sb.toString();
	}
}
