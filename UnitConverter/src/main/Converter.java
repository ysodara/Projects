package main;

import java.util.Scanner;

public class Converter {

	public static void main(String[] args) {

		Converter md = new Converter();
		int menuSelection = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		while (menuSelection != 4) {
			
			System.out.println("Please select an option:");
			System.out.println("1. Cups to Teaspoons");
			System.out.println("2. Miles to Kilometers");
			System.out.println("3. US Gallons to Imperial Gallons");
			System.out.println("4. Quit");
			
			menuSelection = scanner.nextInt();
			
	
		}
		scanner.close();
		

	}

}
