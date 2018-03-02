package application;


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
		this.setVolume(0d);
		this.amount = 0;
	}
	
	public Drink(String name, double purPrice, String kind, double volume, int amount)
	{
		this.name = name;
		this.purPrice = purPrice;
		this.kind = kind;
		this.setVolume(volume);
		this.amount = amount;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("\"" + this.name + "\", ");
		sb.append(this.purPrice + ", ");
		sb.append("\"" + this.kind + "\", ");
		sb.append(this.getVolume() + ", ");
		sb.append(this.amount);
		
		return sb.toString();
	}
	
	public void addAmount(int amount)
	{
		this.amount += amount;
	}
	
	public void reduceAmount()
	{
		this.amount --;
	}
	
	public int getAmount()
	{
		return this.amount;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int compareTo(Drink d)
	{
		return 0;
	}
	
	public double getPurPrice()
	{
		return this.purPrice;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	
}
