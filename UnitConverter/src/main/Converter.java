package main;

import java.util.Scanner;

public class Converter {
	
	/***
	 * Volume Conversions: this third layer that ask user for quantity to convert, 
	 * print out the result after conversion 
	 * @param options as integer
	 * @return NONE
	 */
	public void volumeConversions(int options) {
		//Initialize object for invoking non static method.
		Converter md2 = new Converter();
		//Scanner object
		Scanner scanner= new Scanner(System.in);
		
		//Quantity of Teaspoons
		double teaspoons = 0d;
		
		//result variable for return value from conversion
		double result = 0d;
		
		//Switch check if options 1 or 2
		//if 1, invoke teaspoonsToTablespoons()
		//if 2, invoke teaspoonsToCups()
		switch (options) {
		case 1:{
			System.out.println("Enter Teaspoons: ");
			//Get user input
			teaspoons = scanner.nextDouble();
			result = md2.teaspoonsToTablespoons(teaspoons);
			System.out.println("\n"+(int)teaspoons+" Teaspoons is equal to "+ result + " Tablespoons\n");
			break;
		}
		case 2:{
			System.out.println("Enter Teaspoons: ");
			//Get user input
			teaspoons = scanner.nextDouble();
			result= md2.teaspoonsToCups(teaspoons);
			System.out.println("\n"+(int)teaspoons+" Teaspoons is equal to "+ result + " Cups\n");
			break;
		}
		
		}
	}
	
	/***
	 * Distance Conversions: this third layer that ask user for quantity to convert, 
	 * print out the result after conversion
	 * @param options  as integer
	 */
	public void distanceConversions(int options) {
		Converter md2 = new Converter();
		Scanner scanner= new Scanner(System.in);
		
		double userInput = 0d;
		double result;
		
		//Switch check if options 1 or 2
		//if 1, invoke feetToMeters()
		//if 2, invoke milesToKilometers()
		switch (options) {
		case 1:{
			System.out.println("Enter Feet: ");
			userInput = scanner.nextDouble();
			result = md2.feetToMeters(userInput);
			System.out.println("\n"+(int)userInput+" Feet is equal to "+ result + " Meters\n");
			break;
		}
		case 2:{
			System.out.println("Enter Miles: ");
			userInput = scanner.nextDouble();
			result = md2.milesToKilometers(userInput);
			System.out.println("\n"+(int)userInput+" Miles is equal to "+ result + " Kilometers\n");
			break;
		}
		}
		
	}
	
	/***
	 * Teaspoons To Tablespoons: this function convert teaspoons to tablespoons based on user input
	 * @param teaspoons as double
	 * @return result of Teaspoons To Tablespoons
	 */
	public double teaspoonsToTablespoons(double teaspoons) {
		double teaspoonPerTablespoon = 0.333333d;
		
		return teaspoons * teaspoonPerTablespoon;
	}
	
	/***
	 * Teaspoons To Cups : this function convert teaspoons to cups based on user input
	 * @param teaspoons as double
	 * @return result of Teaspoons To Cups
	 */
	public double teaspoonsToCups(double teaspoons) {
		double teaspoonPerCups = 0.0208333;
		
		return teaspoons * teaspoonPerCups;
	}
	
	/***
	 * Feet To Meters : this function convert feet to meters based on user input
	 * @param feet as double
	 * @return result of Feet To Meters
	 */
	public double feetToMeters(double feet) {
		double feetPerMeter = 0.3048d;
		return feet * feetPerMeter;
	}
	
	/***
	 * Miles To Kilometers : this function convert miles to kilometers based on user input
	 * @param miles as double
	 * @return result of miles To kilometers
	 */
	public double milesToKilometers(double miles) {
		double milesPerKilometers = 1.60934d;
		return miles * milesPerKilometers;
	}
	
	public static void main(String[] args) {
		
		Converter md = new Converter();
		
		int menuSelection = 0;
		double result = 0d;
		Scanner scanner= new Scanner(System.in);
		/***
		 * While loop checks for menu selection from user input
		 * if 1, invoke volumeConversions
		 * if 2, invoke distanceConversions
		 * if 3, exit the program
		 * if everything else, re-run the program
		 */
		while (menuSelection != 3) {
			
			System.out.println("Please select an option:");
			System.out.println("1. Volume Conversions");
			System.out.println("2. Distance Conversions");
			System.out.println("3. Quit");
			
			menuSelection = scanner.nextInt();
			
			switch(menuSelection) {
			
			case 1:	{
				
				System.out.println("Please select an option:");
				System.out.println("1. Teaspoons to Tablespoons");
				System.out.println("2. Teaspoons to Cups");
				int volumeSeletions = scanner.nextInt();
				md.volumeConversions(volumeSeletions);	
				break;
			}
			
			case 2: {
				System.out.println("Please select an option:");
				System.out.println("1. Feet to Meters");
				System.out.println("2. Miles to Kilmeters");
				int distanceSeletions = scanner.nextInt();
				md.distanceConversions(distanceSeletions);
				break;
			}
			
			case 3: {
				System.out.println("You have exited the program.");
				break;
			}
			
			default: {
				System.out.println("Please select option 1 to 4");
				break;
			}
			}
			
	
		}
		scanner.close();
	}

}
