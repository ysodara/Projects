package game;

import java.util.Scanner;

import fixtures.Room;

public class Main {

	public static void main(String[] args) {
		RoomManager rm = new RoomManager();
		rm.init();
		
		Player one = new Player();
		
		one.setCurrentRoom(rm.startingRoom);
		
		printRoom(one);
		String[] command = new String[2];
		parse(command,one);
		printRoom(one);
//		
//		one.currentRoom.printRoomDetails();
//		
//		do {
//			
//		} while(true);
	}
	
	private static void printRoom(Player player) {
		player.getCurrentRoom().printRoomDetails();;
	}
	
	private static String[] collectInput() {
		String[] input;
		Scanner scan = new Scanner(System.in);
		System.out.println("Where to go? ");
		input = scan.nextLine().split(" ");
		return input;
	}
	
	private static void parse (String[] command, Player player) {
		Room currentRoomTemp = player.getCurrentRoom();
		command[1] = "east";
		if (currentRoomTemp.getExit(command[1]) == null) {
			System.out.println("Direction lead to null room");
		} else {
			player.setCurrentRoom(currentRoomTemp.getExit(command[1]));
		}
		//currentRoomTemp = player.getCurrentRoom().getExit("west");
		//System.out.println(currentRoomTemp.getName());
		
	}
}
