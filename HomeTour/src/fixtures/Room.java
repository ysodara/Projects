package fixtures;

public class Room extends Fixture {
	Room[] exits;
	static String[] direction = {"West","East","South","North"};
	
	public Room() {
		super();
		this.exits = new Room[4];
	}
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		
		this.exits = new Room[4]; // size is your choice
	}
		
	public Room[] getExits() {
		return this.exits;
		
	}	
	
	public Room getExit(String direction) {
		Room room = new Room();
		
		switch (direction) {
		case "west": {
			int directionToIndex = 0;
			room = this.exits[directionToIndex];
			break;			
		}
		case "east": {
			int directionToIndex = 1;
			room = this.exits[directionToIndex];
			break;			
		}
		case "south": {
			int directionToIndex = 2;
			room = this.exits[directionToIndex];
			break;			
		}
		case "north": {
			int directionToIndex = 3;
			room = this.exits[directionToIndex];
			break;			
		}
	}
		return room;	
	}
	
	public void setExits(String direction, Room room){
		Room empty = new Room();
		switch (direction) {
			case "west": {
				int directionToIndex = 0;
				this.exits[directionToIndex] = room;
				break;
			}
			case "east": {
				int directionToIndex = 1;
				this.exits[directionToIndex] = room;
				break;
			}
			case "south": {
				int directionToIndex = 2;
				this.exits[directionToIndex] = room;
				break;
			}
			case "north": {
				int directionToIndex = 3;
				this.exits[directionToIndex] = room;
				break;
			}
			
		}
		
		
	}
		
	public void printRoomDetails() {
		System.out.println(this.name + "\n");
		System.out.println(this.longDescription + "\n");
		System.out.println("Exits:");
		
		for (int i = 0; i < this.exits.length; i++) {
			if(this.exits[i] != null) {
				System.out.print(direction[i] + ": ");
				System.out.println(this.exits[i].getShortDescription());
			} 
			
		}System.out.println("");		
	}
}
