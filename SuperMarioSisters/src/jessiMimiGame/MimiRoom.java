package jessiMimiGame;

import java.util.Random;
import caveExplore.CaveExplorer;
import caveExplore.NPC;
import caveExplore.NPCRoom;

public class MimiRoom extends NPCRoom {
	
	//This room makes the NPC say different things to the player
	// NOTE TO SELF: change toa d into bowser? make the npc give tips on how to play the game in general as well.

	public MimiRoom(String description) {
		super(description);
	}
	
	public String validKeys() {
		return "wdsaek";
	}
	
	public String getContents() {
		return "A";
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
		return super.getDescription()+"\n You've run into Toad! Press 'k' to get advice from him on how to defeat Bowser! (you may keep pressing 'k' for more tips)";
	}

	public void tauntPlayer() {
		Random rand = new Random(); 
		int value = rand.nextInt(5);
		
		String taunt = null;
		if(value == 0)
			taunt = "It doesn't matter if you can't win back Princess Peach in the end! You're my hero anyways!";
		if(value == 1)
			taunt = "I hope you bought items previously in the shop! They'll really help you take back the princess!";
		if(value == 2)
			taunt = "Did you find flashlights? They'll power you up in the fight!";
		if(value == 3)
			taunt = "GAH! If your HP is low, you can't win against Bowser!";
		if(value == 4)
			taunt = "You can win the fight if you just believe in yourself!!! ...and of course know how to play the game.";
		
		CaveExplorer.print(taunt);
	}
}

