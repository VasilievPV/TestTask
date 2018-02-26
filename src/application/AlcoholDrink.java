package application;

public class AlcoholDrink extends Drink
{
	private double alcoAmount;
	
	public AlcoholDrink()
	{
		super();
		this.alcoAmount = 0d;
	}
	
	public AlcoholDrink(String name, double purPrice, String kind, double volume, int amount, double alcoAmount)
	{
		super(name, purPrice, kind, volume, amount);
		this.alcoAmount = alcoAmount;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder(super.toString());
		
		sb.append(", " + this.alcoAmount + "%" + System.lineSeparator());
		
		return sb.toString();
	}
	
	public String getName()
	{
		return super.getName();
	}
}