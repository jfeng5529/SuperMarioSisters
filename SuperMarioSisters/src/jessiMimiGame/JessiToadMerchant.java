package jessiMimiGame;

import caveExplore.CaveExplorer;

public class JessiToadMerchant {

	public JessiToadMerchant() {
		// TODO Auto-generated constructor stub
	}
	public void response() {
		System.out.println("You have successfully purchased your item!");
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
			CaveExplorer.print("Would you like to purchase a mega mushroom? Type c to confirm your purchase.");
			if(direction == 7) {
			// CaveExplorer.inventory.hpCost();
			 //CaveExplorer.inventory.increaseHP();
				response();
		 }else {
			 CaveExplorer.print("...Are you sure you're strong enough to complete your mission?");
		 	}
		}
		if(direction == 5) {
			CaveExplorer.print("Come and buy your mini mushroom!!! You will need it to save up ur hp pts.");
			if(direction == 7) {
				// CaveExplorer.inventory.flashlightCost();
				// CaveExplorer.inventory.increaseFlash();
				 response();
		}else {
				 CaveExplorer.print("There is nothing to purchase.");
			}
		 }
		 if(direction == 6) {
			CaveExplorer.print("Would you like to purchase a storage bag? This will increase the items you can hold by 3!"); 
			if(direction == 7) {
				CaveExplorer.inventory.storageCost(); 
				CaveExplorer.inventory.increaseStorage();
				response();
		 }else {
					 CaveExplorer.print("Wrong key!! Type the right key to purchase these handy items.");
		 	}
		}
	}
	
}
