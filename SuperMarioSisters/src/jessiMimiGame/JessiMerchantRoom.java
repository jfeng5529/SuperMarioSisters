package jessiMimiGame;

import java.util.Random;

import caveExplore.CaveExplorer;
import caveExplore.NPCRoom;

public class JessiMerchantRoom extends NPCRoom {
	
	public JessiMerchantRoom(String description) {
		super(description);
	}

	public String getContents() {
		return "I";
	}
	
	public String getDescription() {
		 return super.getDescription()+"\n Welcome to the Item Shop. I'm Toad the Merchant."
		 		+ " Here's a little gift/advise I want to give you. Type 'o' open the big box or 'p' to open the small box. ";
		}
	
	public String validKeys() {
		return "wdsaop";
	}
	
	public void printAllowedEntry() {
		CaveExplorer.print("You can only enter 'w', 'a', 's' or 'd'.");
	}

	public void performAction(int direction) {
		if(direction == 4) {
			o();
			CaveExplorer.print("Type 'w' or 'd' to exit.");
		}
		if(direction == 5) {
			p();
			CaveExplorer.print("Type 'w' or 'd' to exit.");
		}
		else {
			super.performAction(direction);
		}
	}
	
	public void o() {
		Random rand = new Random(); 
		int value = rand.nextInt(2);
		
		String bigBox = null;
		if(value == 0)
			bigBox = "Advise : Do not skip right into the Bowser game. You must first defeat Boo to unlock it.";
		if(value == 1)
			bigBox = "Cheatcode to Boo minigame is 'cheatcode'.";
		
		CaveExplorer.print(bigBox);
	}
	
	public void p() {
		Random rand = new Random(); 
		int value = rand.nextInt(2);
		
		String smallBox = null;
		if(value == 0)
			smallBox = "Cheatcode to Bowser minigame is 'skip'.";
		if(value == 1)
			smallBox = "Advise : Watch out for the trap!!!";
		
		CaveExplorer.print(smallBox);
	}
	
}
