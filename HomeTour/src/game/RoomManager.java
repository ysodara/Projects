package game;

import fixtures.Room;

public class RoomManager {
	Room startingRoom;
	Room[] rooms;
	
	public Room[] getAllRooms() {
		return this.rooms;
	}
	public void init() {
		this.rooms = new Room[4];
		Room livingRoom = new Room(
				"The Foyer- living room",
				"main living room",
				"The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen." + "\n"
				+ "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor." + "\n"
				+ "To the north is a small room, where you can see a piano.");
		this.rooms[0] = livingRoom;
		this.startingRoom = livingRoom;
		Room kit = new Room(
				"The Kitchen",
				"Big kitchen",
				"The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen." + "\n"
				+ "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor." + "\n"
				+ "To the north is a small room, where you can see a piano.");
		this.rooms[1] = kit;
		
		Room garage = new Room(
				"The Garage",
				"car garage",
				"The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen." + "\n"
				+ "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor." + "\n"
				+ "To the north is a small room, where you can see a piano.");
		this.rooms[2] = garage;
		
		Room office = new Room(
				"The Office",
				"front office",
				"The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen." + "\n"
				+ "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor." + "\n"
				+ "To the north is a small room, where you can see a piano.");
		this.rooms[3] = office;
		
		livingRoom.setExits("west",null);
		livingRoom.setExits("east",kit);
		livingRoom.setExits("south",garage);
		livingRoom.setExits("north",null);
		
		kit.setExits("west",livingRoom);
		kit.setExits("east",null);
		kit.setExits("south",office);
		kit.setExits("north",null);
		
		garage.setExits("west",null);
		garage.setExits("east",office);
		garage.setExits("south",null);
		garage.setExits("north",livingRoom);
		
		office.setExits("west",garage);
		office.setExits("east",null);
		office.setExits("south",null);
		office.setExits("north",kit);
		
//		startingRoom.printRoomDetails();
//		
//		livingRoom.printRoomDetails();
//		kit.printRoomDetails();
//		garage.printRoomDetails();
//		office.printRoomDetails();	
		
	}
	
}
