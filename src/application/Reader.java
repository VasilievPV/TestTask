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
		try(Scanner in = new Scanner(new File(filePath)))
		{
			//getFromFile(in, arr);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
}
