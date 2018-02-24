package application;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public final class Writer
{
	public static void write(String filePath, List<Drink> drinkRange)
	{
		StringBuilder sbAlco = new StringBuilder();
		StringBuilder sbUnAlco = new StringBuilder();
		sbAlco.append(Constants.DATABASE_NAME + System.lineSeparator());
		
		for(Drink d : drinkRange)
		{
			try
			{
				AlcoholDrink ad = (AlcoholDrink)d;
				System.out.println("this is alco drink;");
				sbAlco.append(ad.toString());
			}
			catch(ClassCastException e)
			{				
				System.out.println("this is unalco drink;");
				UnAlñoholDrink uad = (UnAlñoholDrink)d;
				sbUnAlco.append(uad.toString());
			}
			
		}
		
		try 
		{
			FileWriter fw = new FileWriter(filePath);
			fw.write(sbAlco.toString());
			fw.write(System.lineSeparator());
			fw.write(sbUnAlco.toString());
			fw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Write failed!");
		}
		
	}
}
