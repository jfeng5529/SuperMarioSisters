package janeLubnaGame;

import caveExplore.CaveExplorer;
import caveExplore.NPCRoom;

public class JanePipeRoom extends NPCRoom {

	public JanePipeRoom(String description) {
		super(description);
		
	}
	
	public String getContents() {
		return "O";
	}
	
	public String getDescription() {
	 return super.getDescription()+"\n Oh no, you have enter the pipe room. you have fell in the pipe that leads to the starting position of the maze. Press 'e' to start";
	}
	public String validKeys() {
		return "e";
	}
	
	public void printAllowedEntry() {
		System.out.println("You can only enter 'e' to interact.");
	}
	public void respondToKey(int direction) {
		while(direction!=0) {
			printAllowedEntry();
		}
		CaveExplorer.currentRoom=CaveExplorer.caves[0][1];
		CaveExplorer.currentRoom.enter();//
	}
	
	
}
