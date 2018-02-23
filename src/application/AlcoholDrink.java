package application;

public class AlcoholDrink extends Drink
{
	private double alkoAmount;
	
	public AlcoholDrink()
	{
		super();
		this.alkoAmount = 0d;
	}
	
	public AlcoholDrink(String name, double purPrice, String kind, double volume, int amount, double alcoAmount)
	{
		super(name, purPrice, kind, volume, amount);
		this.alkoAmount = alcoAmount;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder(super.toString());
		
		sb.append(", \"" + this.alkoAmount + System.lineSeparator());
		
		return sb.toString();
	}
}