package application;

import java.util.List;
import java.util.Random;

public class Buyer
{
	private Random rnd;
	private int purchasesAmount;
	
	public Buyer()
	{
		this.rnd = new Random();
		this.purchasesAmount = 0;
	}
	
	public String[] buy(List<String> drinkNames)
	{
		this.purchasesAmount = rnd.nextInt(Constants.MAX_PURCHASES_AMOUNT);
		if (this.purchasesAmount == 0)
		{
			return null;
		}
		String[] selectedDrinks = new String[this.purchasesAmount];
		
		for(int i = 0; i < selectedDrinks.length; i ++)
		{
			selectedDrinks[i] = drinkNames.get(this.rnd.nextInt(drinkNames.size()));
		}
		
		return selectedDrinks;
	}
}
