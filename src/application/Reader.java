package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public final class Reader
{
	public static Map<String, Drink> read(String filePath)
	{
		Map<String, Drink> temp = new Hashtable<String, Drink>();
		List<String> alcoDrinks = new ArrayList<String>();
		List<String> unAlcoDrinks = new ArrayList<String>();
		
		try(Scanner scan = new Scanner(new File(filePath)))
		{
			if (scan.nextLine().compareTo(Constants.DATABASE_HEADER)==0)
			{
				while(scan.hasNextLine())
				{
					String tmp = scan.nextLine();
					if (!tmp.equals(""))
					{
						alcoDrinks.add(tmp);
					}
					else
						break;
				}
				while(scan.hasNextLine())
				{
					unAlcoDrinks.add(scan.nextLine());
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
		
		for(String line : alcoDrinks)
		{
			AlcoholDrink ad = getAlcoDrinkFromString(line);
			temp.put(ad.getName(), ad);
		}
		for(String line : unAlcoDrinks)
		{
			NonAlcoholDrink uad = getUnAlcoDrinkFromString(line);
			temp.put(uad.getName(), uad);
		}
		
		return temp;
	}
	
	private static AlcoholDrink getAlcoDrinkFromString(String line)
	{
		String[] fields = new String[Constants.DRINK_FIELDS_COUNT];
		
		fields = line.split(", ");
		
		return new AlcoholDrink(fields[0].substring(1, fields[0].length() - 1), Double.parseDouble(fields[1]), fields[2].substring(1, fields[2].length() - 1), Double.parseDouble(fields[3]), Integer.parseInt(fields[4]), Double.parseDouble(fields[5].substring(0, fields[5].length()-1)));
	}
	
	private static NonAlcoholDrink getUnAlcoDrinkFromString(String line)
	{
		String[] fields = new String[Constants.DRINK_FIELDS_COUNT];
		
		fields = line.split(", ");
		
		return new NonAlcoholDrink(fields[0].substring(1, fields[0].length() - 1), Double.parseDouble(fields[1]), fields[2].substring(1, fields[2].length() - 1), Double.parseDouble(fields[3]), Integer.parseInt(fields[4]), fields[5]);
	}
	
	public static Statistics readStatistics(String filePath)
	{
		List<String> lines = new ArrayList<String>();
		List<DrinkStatistic> ds = new ArrayList<DrinkStatistic>();
		
		try(Scanner scan = new Scanner(new File(filePath)))
		{
			if (scan.nextLine().compareTo(Constants.STATISTICS_HEADER)==0)
			{
				while(scan.hasNext())
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
		
		double profit = Double.parseDouble(lines.get(0));
		double loss = Double.parseDouble(lines.get(1));
		lines.remove(0);
		lines.remove(0);
		
		String[] values = null;
		for(String line : lines)
		{
			values = line.split(",");
			ds.add(new DrinkStatistic(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2])));
		}
		
		return new Statistics(profit, loss, ds);
	}
	
	
}
