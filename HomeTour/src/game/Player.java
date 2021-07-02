package game;

import fixtures.Room;

public class Player {
	private Room currentRoom;
	
	Player (){
		this.currentRoom = new Room();
	}
	Player (Room currentRoom){
		this.currentRoom = currentRoom;
	}
	
	public Room getCurrentRoom () {
		return this.currentRoom;
	}
	
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
}
