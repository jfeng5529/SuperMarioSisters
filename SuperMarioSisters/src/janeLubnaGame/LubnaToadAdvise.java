package janeLubnaGame;

import caveExplore.CaveExplorer;
import caveExplore.NPCRoom;

public class LubnaToadAdvise extends NPCRoom {
	
	boolean visited = false;
	public LubnaToadAdvise(String description) {
		super(description);
		
	}
	
	public String getContents() {
		return "T";
	}
	public String getDescription() {
		return "Hello Princess! Your toad is here for you! I heard you're trying to rescue your Prince! I have some information for you to help you in this conquest! Press 't' to get this in. ";
	}
	public String validKeys() {
		return "wdsaet";
	}

	public void printAllowedEntry() {
		System.out.println("Enter 't' to get a tip from yours truly.");
	}
	public void performAction(int direction) {
		while(visited == false) {
		if(direction == 5) {
		System.out.println("It has come to my attention, that during your conquest you'll find these flashlights. They will give you the light to your path. Whenever you find a flashligh be sure to collect it. These flashlights will give you the strength you need to fight for your prince to rescue you. Bowser has hid these flashlights in rooms, and the more flashlights you have to more chances you have to beat Bowser. Go beat him Princess, go get your Prince, you can thank me later with my favorite flies.");
		visited = true;
		}
		else if(direction >= 6) {
			System.out.println("Press 't' for tips.");
		}
}
		if(visited == true ) {
			System.out.println("I've already said everything I know, go Princess your Prince needs you. ");
		}
}
}
