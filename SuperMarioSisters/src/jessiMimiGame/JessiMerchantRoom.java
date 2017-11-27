package jessiMimiGame;

import caveExplore.CaveExplorer;
import caveExplore.NPCRoom;

public class JessiMerchantRoom extends NPCRoom {

	public JessiMerchantRoom(String description) {
		super(description);
	}
	public String getContents() {
		return "I";
	}
	
	public void printAllowedEntry() {
		CaveExplorer.print("Welcome to the Item Shop. I'm Toad the Merchant. Enter w, a, s, d to move");
	}
	
	public String validKeys() {
		return "wdsasm";
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
			
			
		}else {
			 super.performAction(direction);
		}
	}
	
	public void response() {
		System.out.println("You have successfully purchased your item!");
	}
	
}

