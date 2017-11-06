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
		return "Oh no, you have enter the pipe room. you have fell in the pipe that leads to the starting position of the maze";
	}

}
