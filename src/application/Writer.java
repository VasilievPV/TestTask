package application;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public final class Writer
{
	public static void write(String filePath, List<Drink> drinkRange)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("drinkRange Data Base" + System.lineSeparator());
		
		for(Drink d : drinkRange)
		{
			try
			{
				AlcoholDrink ad = (AlcoholDrink)d;
				System.out.println("this is alco drink;");
				sb.append(ad.toString());
			}
			catch(ClassCastException e)
			{				
				System.out.println("this is unalco drink;");
				UnAlñoholDrink uad = (UnAlñoholDrink)d;
				sb.append(uad.toString());
			}
			
		}
		
		try 
		{
			FileWriter fw = new FileWriter(filePath);
			fw.write(sb.toString());
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Write failed!");
		}
		
	}
}
