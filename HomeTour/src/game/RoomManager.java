package game;

import fixtures.Room;

public class RoomManager {
	private Room startingRoom;
	private Room[] rooms;
	
	public Room[] getAllRooms() {
		return this.rooms;
	}
	public Room getStartingRoom() {
		return this.startingRoom;
	}
	public void setStartingRoom(Room room) {
		this.startingRoom = room;
	}
	
	public void setRooms(Room room, int location) {
		this.rooms[location] = room;
	}
	public void init() {
		this.rooms = new Room[6];
		Room livingRoom = new Room(
				"The living room",
				"main living room",
				"The main living room of a condo. A dining room is open to the east, where five people can seated.\n"
				+ "To the south is a car garage, where you can park one full car.\n");
		setRooms(livingRoom,0);
		
		Room kit = new Room(
				"The Kitchen",
				"big kitchen",
				"The big kitchen at northeast of the condo. A dining room is next to it, which is to west, and where five people can seated.\n"
				+ "To the south is a small office, where you can see a big computer desk.\n");
		
		setRooms(kit,1);
		
		Room garage = new Room(
				"The Garage",
				"car garage",
				"The full size car garage of the condo. To the East, there is a small hallway to get to the bedroom.\n"
				+ "To the north, you can access the living room.\n");
		setRooms(garage,2);
		
		Room office = new Room(
				"The Office",
				"front office",
				"The front office of the condo. To the north, you can head to the big kitchen.\n"
				+ "To the west, there is the small hallway to get to the bedroom.");
		setRooms(office,3);
		
		Room bedroom = new Room(
				"The Bedroom",
				"master bedroom",
				"The master bedroom of the condo. A dining room is open to the north, where where five people can enjoy their meal." + "\n"
				+ "The small hallway leads west into the car garage.\n"
				+ "To the east is a small room, where you can see a big computer desk.");
		setRooms(bedroom,4);
		
		Room dining = new Room(
				"The Dining",
				"Dining",
				"The dining of the condo. A kitchen room is next to it, which is to east.\n"
				+ "To the west is a big living room, where you can relax after a meal.\n"
				+ "To the south, you can go to the master bedroom.\n");
		setRooms(dining,5);
		
		
		
		livingRoom.setExits("west",null);
		livingRoom.setExits("east",dining);
		livingRoom.setExits("south",garage);
		livingRoom.setExits("north",null);
		
		kit.setExits("west",dining);
		kit.setExits("east",null);
		kit.setExits("south",office);
		kit.setExits("north",null);
		
		garage.setExits("west",null);
		garage.setExits("east",bedroom);
		garage.setExits("south",null);
		garage.setExits("north",livingRoom);
		
		office.setExits("west",bedroom);
		office.setExits("east",null);
		office.setExits("south",null);
		office.setExits("north",kit);
		
		dining.setExits("west",livingRoom);
		dining.setExits("east",kit);
		dining.setExits("south",bedroom);
		dining.setExits("north",null);
		
		bedroom.setExits("west",garage);
		bedroom.setExits("east",office);
		bedroom.setExits("south",null);
		bedroom.setExits("north",dining);
		
		setStartingRoom(livingRoom);
	}
	
}
