package application;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public final class Writer
{
	public static void write(String filePath, List<Drink> drinkRange)
	{
		StringBuilder sb = new StringBuilder();
		for(Drink d : drinkRange)
		{
			
		}
		
		try 
		{
			FileWriter fw = new FileWriter(filePath);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
}
