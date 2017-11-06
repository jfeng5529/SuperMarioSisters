package jessiMimiGame;

import java.util.Random;
import caveExplore.CaveExplorer;
import caveExplore.NPC;
import caveExplore.NPCRoom;

public class MimiRoom extends NPCRoom {
	
	//This room makes the NPC say different things to the player
	private boolean active;
	private NPC presentNPC;

	public MimiRoom(String description) {
		super(description);
	}
	
	public boolean isActive() {
		return active;
	}
	
	public String validKeys() {
		return "wdsak";
	}
	
	public String getContents() {
		return "j";
	}
	public void performAction(int direction) {
		if(direction == 4) {
		 if(containsNPC() && presentNPC.isActive) {
			 presentNPC.interact();
		 }
		 else {
			 CaveExplorer.print("There is nothing to interact with");
		 }
		}
		else {
		System.out.println("That key does nothing");
		}
	}
	
	
	public String getDescription() {
		if(containsNPC()&& !presentNPC.isActive) {
		return super.getDescription()+"\n"+presentNPC.getInactiveDescription();
		}
		else {
			String npcDescription="";
			if(presentNPC!=null) {
				npcDescription = presentNPC.getActiveDescription();
			}
			return super.getDescription()+"\n"+npcDescription;
		}
	}
	
	public void interact() {
		CaveExplorer.print("You'll have to go through me if you want Princess Peach!");
		if(isActive() == true) {
			tauntPlayer();
		}
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
