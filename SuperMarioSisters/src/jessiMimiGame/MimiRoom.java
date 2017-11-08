package jessiMimiGame;

import java.util.Random;
import caveExplore.CaveExplorer;
import caveExplore.NPC;
import caveExplore.NPCRoom;

public class MimiRoom extends NPCRoom {
	
	//This room makes the NPC say different things to the player

	public MimiRoom(String description) {
		super(description);
	}
	
	public String validKeys() {
		return "wdsaek";
	}
	
	public String getContents() {
		return "j";
	}
	public void performAction(int direction) {
		if(direction == 5) {
			tauntPlayer();
		}
		else {
			super.performAction(direction);
		}
	}
	
	
	public String getDescription() {
		return super.getDescription()+"\n Press 'k' to talk to Bowser!";
	}

	public String tauntPlayer() {
		Random rand = new Random(); 
		int value = rand.nextInt(5);
		
		String taunt = null;
		if(value == 0)
			taunt = "RAAAAAWWWWRRRR!!!!!!";
		if(value == 1)
			taunt = "WHAA--?! IT'S YOU! That's it, Mario! I'm gonna stomp you into space bits!";
		if(value == 2)
			taunt = "Gah! Give it up already!";
		if(value == 3)
			taunt = "Why don't you run off and find some green pipe to hide in?";
		if(value == 4)
			taunt = "Go ahead--just try to grab me by the tail! You'll never be able to swing ME around!";
		
		return taunt;
	}
}
