package jessiMimiGame;

import caveExplore.CaveExplorer;
import caveExplore.CaveRoom;

public class JessiMerchantRoom extends CaveRoom {

	public JessiMerchantRoom(String description) {
		super(description);
	}

	public String getDescription() {
		return"Welcome to the Item Shop.";
	}
	
	
	public void purchaseItem() {
		System.out.println("What would you like to buy?");
	}
	
	public void performAction(int direction) {
		if(direction == 0) {
			CaveExplorer.currentRoom=CaveExplorer.caves[2][4];
			CaveExplorer.currentRoom.enter();
		}
		if(direction == 1) {
			CaveExplorer.currentRoom=CaveExplorer.caves[1][5];
			CaveExplorer.currentRoom.enter();
		}
		if(direction == 2) {
			CaveExplorer.currentRoom=CaveExplorer.caves[2][6];
			CaveExplorer.currentRoom.enter();
		}
		if(direction == 3) {
			CaveExplorer.currentRoom=CaveExplorer.caves[3][5];
			CaveExplorer.currentRoom.enter();
		}
	}
}
