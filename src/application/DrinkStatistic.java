package application;

public class DrinkStatistic
{
	private String name;
	private int puchased;
	private int sold;
	
	public DrinkStatistic(String name)
	{
		this.setName(name);
		this.setPuchased(0);
		this.setSold(0);
	}
	
	public DrinkStatistic(String name, int purchased, int sold)
	{
		this.setName(name);
		this.setPuchased(purchased);
		this.setSold(sold);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPuchased() {
		return puchased;
	}

	public void setPuchased(int puchased) {
		this.puchased = puchased;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}
	
	public void incrimentSold()
	{
		this.sold ++;
	}
}
