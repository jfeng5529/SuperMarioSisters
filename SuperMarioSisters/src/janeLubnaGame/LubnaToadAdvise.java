package janeLubnaGame;

import caveExplore.CaveExplorer;
import caveExplore.NPCRoom;

public class LubnaToadAdvise extends NPCRoom {

	boolean visited = false;
	public LubnaToadAdvise(String description) {
		super(description);
		String[] ToadsSpeech = {"It has come to my attention, that during your conquest you'll find these flashlights...",
				"They will light your path. Whenever you find it a flashlight be sure to collect it! It will give you the strength you need.",
				"Bowser has hid these flashlights in rooms, the more flashlight you collect the more chances you have to defeat... ",
				} 
	}

	public String getContents() {
		return "T";
	}
	public String getDescription() {
		return "Hello Princess! Your toad is here for you! I heard you're trying to rescue your Prince! \n I have some information for you to help you in this conquest! Press 't' to get this in. ";
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
				System.out.println("It has come to my attention, that during your conquest you'll find these flashlights..");
				System.out.println("Press Enter to continue.");
				CaveExplorer.in.nextLine();
				System.out.println("They will light your path. Whenever you find it a flashlight be sure to collect it! "
						+ "It will give you the strength you need.");
				System.out.println("Press Enter to continue.");
				CaveExplorer.in.nextLine();
				System.out.println("Bowser has hid these flashlights in rooms, the more flashlight you collect "
						+ "the more chances you have to defeat..");
				System.out.println("Press Enter to continue.");
				CaveExplorer.in.nextLine();
				System.out.println("BOOO!!! Yes my princess, its Bawser's minions. Boo is going to be roaming around looking for "
						+ "you, so BE ON GUARD ALL THE TIME! \n That's it for now princess, be safe and get your Prince. ");
				//+ "\nWhenever you find a flashligh be sure to collect it. These flashlights will give you the strength you need to fight for your prince to rescue you. "
				//+ "\nBowser has hid these flashlights in rooms, and the more flashlights you have to more chances you have to beat Bowser."
				//+ "\nGo beat him Princess, go get your Prince, you can thank me later with my favorite flies.");
				System.out.println("Press Enter to continue.");
				CaveExplorer.in.nextLine();
				visited = true;
			}
			else if(direction >= 6) {
				System.out.println("Press 't' for tips.");
			}
		}
		if(visited == true ) {
			System.out.println("I've already said everything I know, go Princess your Prince needs you. ");
			System.out.println("Press Enter to continue.");
			CaveExplorer.in.nextLine();
		}
	}
}
