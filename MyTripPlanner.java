import java.util.Scanner;
public class MyTripPlanner
{
	public static void main(String [] args)
	{
			intro();
			moneyConverter();
			timeDifference();
			landConverter();
			//a bit of jazz to finish off!
			System.out.println("Have a great trip ahead!");
	}
	
	public static void intro()
	{
	//This takes the user's details
	Scanner input = new Scanner (System.in);
	System.out.print("What is your name?");
	String name = input.nextLine();
	System.out.println("Welcome, "+name+"!");
	System.out.print("Where are you off to?");
	String city = input.nextLine();
	System.out.println("Great! "+city+" sounds like a nice place!");	
	}
	
	public static void timeDifference()
	{
		//This is for the time difference converter
		Scanner input = new Scanner (System.in);

		boolean isValidDiff = false;
		do
		{
		System.out.print("What is the time difference in hours between your home and destination?");
		String diff = input.next();
		isValidDiff = numberOrNot(diff);
			if(isValidDiff)
			{
				int intDiff = Integer.parseInt(diff.trim());
				//To find −b mod N, just keep adding N to −b until the number is between 0 and N.
				
				//To find the time difference in 24 Hour format, take the modulus of the entered number and 24, repeat if the entered number is very large (for corner cases)
				int differed = (intDiff % 24);
				int differedPlus = 12+differed;
				System.out.println("The diff is "+differedPlus);
				if(differedPlus < 23 && differedPlus !=12)
				{
					System.out.println("That means when it is midnight at home, it will be "+differed+":00 at your destination. And when it is noon at your home, it will be "+differedPlus+":00 at your destination");	
				}
				else
				{
					differedPlus = (differedPlus % 24);
					System.out.println("That means when it is midnight at home, it will be "+differed+":00 the next day at your destination. And when it is noon at your home, it will be "+differedPlus+":00 the next day at your destination");
					//Deliberate spell mistake here to check with condition was used
				}
			}
		}
		while(isValidDiff == false);
		
		
	}
	public static void landConverter()
	{
		//This converts land area from sq.km to sq.mi
		Scanner input = new Scanner (System.in);
		boolean isValidLand = false;
		do
		{
			System.out.print("What is the sq area of your destination country in sq km?");
			String landVal = input.next();
			isValidLand = doubleOrNot(landVal);
				if(isValidLand == true)
				{
					double intLandVal = Double.parseDouble(landVal.trim());
					double mileLanVal = intLandVal * 0.386102159;
					System.out.println("In sq miles that is "+mileLanVal);
				}
		}
		while(isValidLand == false);
	}
	public static void moneyConverter()
	{	boolean isValiddays = false;
		boolean isValidCash = false;
		boolean isValidConvertor = false;
		//This converts currency to USD
		Scanner input = new Scanner (System.in);
		do{
			System.out.print("How many days are you planning to spend?");
			String days = input.next();
			isValiddays = numberOrNot(days);
			if(isValiddays == true)
			{	
				int intValDays = Integer.parseInt(days.trim());
				do{
				System.out.print("How much money are you planning to spend?");
				String cash = input.next();
				isValidCash = numberOrNot(cash);
					if(isValidCash == true)
					{
					int intValCash = Integer.parseInt(cash.trim());
					double dubValCash = (double)intValCash;
						do{
						System.out.print("Enter the 3 lettered currency notifier for the country whose city you're visiting.");
						String currCode = input.next();
						System.out.print("How many "+currCode+" are there for every USD?");
						String convertor = input.next();
						isValidConvertor = doubleOrNot(convertor);
							if(isValidConvertor == true)
							{
								double intValConvertor = Double.parseDouble(convertor.trim());
								int hours = intValDays * 24;
								int mins = hours * 60;
								double usdBud = dubValCash / intValDays;
								double budget = dubValCash * intValConvertor;
								double perDayBud = budget / intValDays;
								System.out.println("If you are traveling for "+intValDays+" that is the same as "+hours+" hours or "+mins+" minutes");
								System.out.println("If you plan to spend $"+dubValCash+" that means per day you spend $"+usdBud);
								System.out.println("Your total budget in "+currCode+" is "+currCode+",which per day is "+perDayBud+" "+currCode);
							}
						}
						while(isValidConvertor == false);
					}			
				}
				while(isValidCash == false);
			}
		}while(isValiddays == false);
	}
	
	public static boolean numberOrNot(String input)
	{
		//sub routine used by all methods to check validity of input. DO NOT CHANGE
		try
		{
			Integer.parseInt(input);
		}
		catch(NumberFormatException ex)
		{	
			System.out.println("Enter a number!");
			return false;
		}
		return true;
	}
		public static boolean doubleOrNot(String input)
	{	
		//sub routine used by all methods to check validity of input. DO NOT CHANGE
		try
		{
			Double.parseDouble(input);
		}
		catch(NumberFormatException ex)
		{
			return false;
		}
		return true;
	}
}