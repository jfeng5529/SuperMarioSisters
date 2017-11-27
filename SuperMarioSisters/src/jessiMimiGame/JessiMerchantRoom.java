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
		 return super.getDescription()+"\n Welcome to the Item Shop. I'm Toad the Merchant.";
		}
	
	public String validKeys() {
		return "wdsaop";
	}
	
	public void printAllowedEntry() {
		CaveExplorer.print("You can only enter 'w', 'a', 's' or 'd'.");
	}

	public void performAction(int direction) {
		if(direction == 4) {
			mega();
		}
		if(direction == 5) {
			mini();
		}
		else {
			super.performAction(direction);
		}
	}
	
	public void mega() {
		Random rand = new Random(); 
		int value = rand.nextInt(3);
		
		String MegaMushroom = null;
		if(value == 0)
			MegaMushroom = "";
		if(value == 1)
			MegaMushroom = "";
		if(value == 2)
			MegaMushroom = "";
		
		CaveExplorer.print(MegaMushroom);
	}
	
	public void mini() {
		Random rand = new Random(); 
		int value = rand.nextInt(3);
		
		String taunt = null;
		if(value == 0)
			taunt = "";
		if(value == 1)
			taunt = "";
		if(value == 2)
			taunt = "";
		
		CaveExplorer.print(taunt);
	}
	
}
