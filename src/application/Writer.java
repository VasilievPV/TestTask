package application;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public final class Writer
{
	public static void write(String filePath, Collection<Drink> productRange)
	{
		StringBuilder sbProductRange = new StringBuilder();
		sbProductRange.append(Constants.DATABASE_NAME + System.lineSeparator());
		
		for(Drink d : productRange)
		{
			if(d instanceof AlcoholDrink)
				sbProductRange.append(d.toString());
			
		}
		sbProductRange.append(System.lineSeparator());
		for(Drink d : productRange)
		{
			if(d instanceof NonAlcoholDrink)
				sbProductRange.append(d.toString());
		}
		
		try 
		{
			FileWriter fw = new FileWriter(filePath);
			fw.write(sbProductRange.toString());
			fw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Write failed!");
		}
		
	}
}
