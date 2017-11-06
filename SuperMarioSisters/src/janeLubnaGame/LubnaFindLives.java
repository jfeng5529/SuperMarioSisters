package janeLubnaGame;

import caveExplore.CaveExplorer;
import caveExplore.NPCRoom;

public class LubnaFindLives extends NPCRoom {

	public LubnaFindLives(String description) {
		super(description);
		 
	}
	public String getContents() {
		return "C";
	}
	
	public String getDescription(){
		return "Congratulations, you've found a flashlight! The more flashlight you have the longer you can play!";
	}
	public String validKeys() {
		return "wdsaec";
	}
	
	public void printAllowedEntry() {
		System.out.println("Enter 'c' to collect a flashlight.");
	}
	public void performAction(int direction) {
		if(direction == 5) {
		CaveExplorer.inventory.addLife();
		}
		else {
			 CaveExplorer.print("Press 'c' to collect or die fast.");
		 }
		
		}
		
		
		}
	
		

		
