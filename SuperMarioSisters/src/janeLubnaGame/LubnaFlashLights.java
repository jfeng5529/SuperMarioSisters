package janeLubnaGame;

import caveExplore.CaveExplorer;
import caveExplore.NPCRoom;

public class LubnaFlashLights extends NPCRoom {

	public LubnaFlashLights(String description) {
		super(description);
		
	}
	public String getContents() {
		return "F";
	}
	
	public String getDescription(){
		return "Congratulations, you've found a flashlight! The more flashlight you have the longer you can play!"
				+ "You can only get three flashlights! Use them wisely. Press 'c' to collect or die fast.";
	}
	public String validKeys() {
		return "wdsaec";
	}
	public void response() {
		System.out.println(CaveExplorer.inventory.getFlashLight());
	}
	public void printAllowedEntry() {
		System.out.println("Enter 'c' to collect a flashlight.");
	}
	
	public void performAction(int direction) {
		
		if(direction<4) {
			super.performAction(direction);
		}
	    if(CaveExplorer.inventory.getFlashLight() > 3){
				System.out.print("You've already received the maximum amount of flashlights. "
						+ "Don't be greedy, go fight Boo.");
			
		}
		
		if(direction == 5 && CaveExplorer.inventory.getFlashLight() <= 3) {
		CaveExplorer.inventory.increaseFlash();//
		response();
		}
		

		
		
		}
}
	
		

		
