package jessiMimiGame;

import caveExplore.CaveExplorer;
import caveExplore.NPCRoom;

public class MimiRoom extends NPCRoom {
	
	//This room makes the NPC say different things to the player

	public MimiRoom(String description) {
		super(description);
	}
	
	public void speak() {
		CaveExplorer.print("You'll have to go through me if you want Princess Peach!");
		while(isActive) {
			taunt();
		}
	}

	public String taunt() {
		return null;
	}
}
