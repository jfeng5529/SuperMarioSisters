package jessiMimiGame;

import caveExplore.CaveExplorer;
//import caveExplorer.Inventory;

public class JessiToadMerchant {
	private boolean active;

	public JessiToadMerchant() {
		active = true;
	}
	
	public void response() {
		System.out.println("You have successfully purchased your item!");
	}
	
	public void chat() {
		CaveExplorer.print("Hello there I'm Toad the Merchant. What would you like to buy today?");
		if (active) {
			CaveExplorer.print("");
			
		}
	}
	
}
