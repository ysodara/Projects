package game;

import java.util.Scanner;

import fixtures.Room;
import java.lang.*;
public class Main {
	static String[] direction = {"west","east","south","north"};
	public static void main(String[] args) {
		RoomManager roomManager = new RoomManager();
		roomManager.init();
		
		Player one = new Player();
		
		one.setCurrentRoom(roomManager.getStartingRoom());
		
		String[] command;
		boolean userCommand = true;
		
		do {
			printRoom(one);	
			
			command = collectInput();
			
			if (command.length > 1) {
				if (command[0].equals("go")) {
				command[1] = command[1].toLowerCase();
				boolean directionCheck = false;
				for (int i = 0; i < direction.length ; i++) {
					if (command[1].equals(direction[i])) {
						directionCheck = true;
					}
				}
					if(directionCheck == true) {
						parse(command, one);
					}
					else {
						System.out.println("Direction is not recognized.");
						System.out.println("Available direction: West, East, South, North.\n");
						System.out.print("You're still at your current location: ");
					}
				}
				else {
					System.out.println("Action is not recognized.");
					System.out.println("Available action: Go\n");
					System.out.print("You're still at your current location: ");
				}
			}
			else {
				command[0] = command[0].toLowerCase();
				if (command[0].equals("quit")) {
					System.out.println("You have quitted the program.\n");
					userCommand = false;
				}
				else {
					System.out.println("Command is not valid.\n");
					System.out.print("You're still at your current location: ");
				}
			}			
		} while(userCommand);
		Scanner scan = new Scanner(System.in);
		scan.close();
	}
	
	private static void printRoom(Player player) {
		System.out.println(player.getCurrentRoom().getName() + "\n");
		System.out.println(player.getCurrentRoom().getLongDescription());
		System.out.println("Exits:");
		Room [] tempExits = player.getCurrentRoom().getExits();
		for (int i = 0; i < tempExits.length; i++) {
			if(tempExits[i] != null) {
				System.out.print(direction[i] + ": ");
				System.out.println(tempExits[i].getShortDescription());
			} 
			
		}System.out.println("");
		
		System.out.println("What direction do you want to go? ");
		System.out.println("Type Quit for exitting the program.");
	}
	
	private static String[] collectInput() {
		String[] input;
		Scanner scan = new Scanner(System.in);
		input = scan.nextLine().split(" ");
		System.out.println("");
		return input;
	}
	
	private static void parse (String[] command, Player player) {
		Room currentRoomTemp = player.getCurrentRoom();
		if ( currentRoomTemp.getExit(command[1]) == null ) {
			System.out.println("Sorry exit is not valid.\n");
			System.out.print("You're still at your current location: ");
		} 
		else {
			player.setCurrentRoom(currentRoomTemp.getExit(command[1]));
		}		
	}
}
