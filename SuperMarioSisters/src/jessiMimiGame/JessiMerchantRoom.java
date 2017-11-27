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
		CaveExplorer.print("Welcome to the Item Shop. Enter w, a, s, d to move or type h to interact.");
	}
	
	public String validKeys() {
		return "wdsah";
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
			merchantToad.chat();
			
		}else {
			 super.performAction(direction);
		}
	}
	
	
}

