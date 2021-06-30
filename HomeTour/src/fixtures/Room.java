package fixtures;

public class Room extends Fixture {
	Room[] exits;
	
	public Room() {}
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		this.exits = new Room[4]; // size is your choice
	}
		
	public Room[] getExits() {
		return this.exits;
		
	}
	
	public void setExits(int index, Room room){
		this.exits[index] = room;
		
	}
	public Room getExit(String direction) {
		Room r = new Room();
		return r;	
	}
	
	public void printRoomDetails() {
		System.out.println(this.name);
		System.out.println(this.exits[1].name);
		
	}
}
