package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Reader
{
	public static List<Drink> read(String filePath)
	{
		List<Drink> tempList = new ArrayList<Drink>();
		List<String> lines = new ArrayList<String>();
		
		try(Scanner scan = new Scanner(new File(filePath)))
		{
			if (scan.nextLine() == Constants.DATABASE_NAME)
			{
				while(scan.hasNextLine())
				{
					lines.add(scan.nextLine());
				}
			}
			else
			{
				System.out.println(Constants.WRONG_FILE);
				return null;
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		
		
		return null;
	}
}
