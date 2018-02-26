package application;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public final class Writer
{
	public static void write(String filePath, Map<String, Drink> productRange)
	{
		StringBuilder sbAlco = new StringBuilder();
		StringBuilder sbNonAlco = new StringBuilder();
		sbAlco.append(Constants.DATABASE_NAME + System.lineSeparator());
		
		for(Drink d : productRange.values())
		{
			try
			{
				AlcoholDrink ad = (AlcoholDrink)d;
				System.out.println("this is alco drink;");
				sbAlco.append(ad.toString());
			}
			catch(ClassCastException e)
			{				
				System.out.println("this is non-alco drink;");
				NonAlcohollDrink uad = (NonAlcohollDrink)d;
				sbNonAlco.append(uad.toString());
			}
			
		}
		
		try 
		{
			FileWriter fw = new FileWriter(filePath);
			fw.write(sbAlco.toString());
			fw.write(System.lineSeparator());
			fw.write(sbNonAlco.toString());
			fw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Write failed!");
		}
		
	}
}
