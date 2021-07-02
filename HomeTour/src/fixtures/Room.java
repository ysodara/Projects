package fixtures;

public class Room extends Fixture {
	private Room[] exits;
	
	public Room() {
		super();
		this.exits = new Room[6];
	}
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		
		this.exits = new Room[6]; // size of whole house
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
}
