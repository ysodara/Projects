package game;

import fixtures.Room;

public class RoomManager {
	Room startingRoom;
	Room[] rooms;
	
	public void init() {
		this.rooms = new Room[4];
		Room livingRoom = new Room(
				"The Foyer- living room",
				"a small foyer",
				"The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen." + "\n"
				+ "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor." + "\n"
				+ "To the north is a small room, where you can see a piano.");
		this.rooms[0] = livingRoom;
		this.startingRoom = livingRoom;
		Room kit = new Room(
				"The Kitchen",
				"a small foyer",
				"The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen." + "\n"
				+ "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor." + "\n"
				+ "To the north is a small room, where you can see a piano.");
		this.rooms[1] = kit;
		
		Room garage = new Room(
				"The Foyer",
				"a small foyer",
				"The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen." + "\n"
				+ "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor." + "\n"
				+ "To the north is a small room, where you can see a piano.");
		this.rooms[2] = garage;
		
		Room office = new Room(
				"The Foyer",
				"a small foyer",
				"The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen." + "\n"
				+ "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor." + "\n"
				+ "To the north is a small room, where you can see a piano.");
		this.rooms[3] = office;
		
		livingRoom.setExits(0,null);
		livingRoom.setExits(1,kit);
		livingRoom.setExits(2,garage);
		livingRoom.setExits(3,null);
		
		livingRoom.printRoomDetails();
		
		
		
		
		
		
		
		
	}
	
}
