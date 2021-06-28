package main;

import java.util.Scanner;

public class Converter {
		
	public double volumeConversions(int options) {
		Converter md2 = new Converter();
		Scanner scanner= new Scanner(System.in);
		double teaspoons = 0d;
		double result = 0d;
		
		switch (options) {
		case 1:{
			System.out.println("Enter Teaspoons: ");
			teaspoons = scanner.nextDouble();
			result = md2.teaspoonsToTablespoons(teaspoons);
			System.out.println("\n"+(int)teaspoons+" Teaspoons is equl to "+ result + " Tablespoons\n");
			break;
		}
		case 2:{
			System.out.println("Enter Teaspoons: ");
			teaspoons = scanner.nextDouble();
			result= md2.teasponsToCups(teaspoons);
			System.out.println("\n"+(int)teaspoons+" Teaspoons is equl to "+ result + " Cups\n");
			break;
		}
		
		}
		return result;
	}
		
	public void distanceConversions(int options) {
		Converter md2 = new Converter();
		Scanner scanner= new Scanner(System.in);
		
		double userInput = 0d;
		double result;
		switch (options) {
		case 1:{
			System.out.println("Enter Feet: ");
			userInput = scanner.nextDouble();
			result = md2.feetToMeters(userInput);
			System.out.println("\n"+(int)userInput+" Feet is equl to "+ result + " Meters\n");
			break;
		}
		case 2:{
			System.out.println("Enter Miles: ");
			userInput = scanner.nextDouble();
			result = md2.milesToKilometers(userInput);
			System.out.println("\n"+(int)userInput+" Miles is equl to "+ result + " Kilometers\n");
			break;
		}
		}
		
	}
	
	public double teaspoonsToTablespoons(double teaspoons) {
		double teaspoonPerTablespoon = 0.333333d;
		
		return teaspoons * teaspoonPerTablespoon;
	}
	
	public double teasponsToCups(double teaspoons) {
		double teaspoonPerCups = 0.0208333;
		
		return teaspoons * teaspoonPerCups;
	}
	
	public double feetToMeters(double feet) {
		double feetPerMeter = 0.3048d;
		return feet * feetPerMeter;
	}
	
	public double milesToKilometers(double miles) {
		double milesPerKilometers = 1.60934d;
		return miles * milesPerKilometers;
	}
	
	public static void main(String[] args) {
		Converter md = new Converter();
		
		int menuSelection = 0;
		double result = 0d;
		Scanner scanner= new Scanner(System.in);
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
