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
	
	public String getDescription() {
		return"Welcome to the Item Shop.";
	}
	
	public String validKeys() {
		return "wdsae";
	}
	
	public void printAllowedEntry() {
		CaveExplorer.print("What would you like to buy?");
		CaveExplorer.print("You can only enter w, a, s, d to move or you can type e, r, f to purchase items.");
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
		 CaveExplorer.print("Would you like to purchase hp points?");
		 }else {
			 CaveExplorer.print("...Are you sure you're typing in the right key?");
		 }
		 if(direction == 5) {
			CaveExplorer.print("Would you like to purchase a storage bag? This will increase the items you can hold by 3!"); 
		 }else {
				 CaveExplorer.print("Wrong key!! Type the right key to purchase these handy items.");
			 }
		 if(direction == 6) {
			CaveExplorer.print("Come and buy your flashlights!!! You will need them to scare off boo and save ur hp pts.");
		 }else {
				 CaveExplorer.print("There is nothing to purchase.");
			 }
		}
	
}
