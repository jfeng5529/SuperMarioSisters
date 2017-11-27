package caveExplore;

import jessiMimiGame.MimiFrontEnd;

public class BowserRoom extends NPCRoom {

	public BowserRoom(String description) {
		super(description);
	}
	
	public String validKeys() {
		return "wdsae";
	}
	
	public String getContents() {
		return "B";
	}
	public void respondToKey(int direction) {
		if(CaveExplorer.inventory.getKey()) {
			if(direction==4) {
				CaveExplorer.print("BOWWWW You think you can beat me Maria?! How funny! Let me show you how this is going down! Press 'e' to continue.");
				MimiFrontEnd game = new MimiFrontEnd();
				game.play();
			}
			else	{
				super.respondToKey(direction);
			}
			
		}
		else {
			if(direction==4) {
				CaveExplorer.print("HAHAHA! You want to fight me before you even went through the level of my fellow Boo? Oh no not a chance. Don't waste"
						+ " my time. Go back and level up at Boo's challenge.");
			}
			if(direction!=1) {
			super.respondToKey(direction);}
			if(direction==1){
				int count=0;
				String input="";
				while(direction==1||input.equals("d")) {
					if(count>1) {
						CaveExplorer.print("That is it! My temper is not a toy! Go back to where you belong, let your Prince Peach die in despair!");
						CaveExplorer.currentRoom.leave();
						CaveExplorer.currentRoom=CaveExplorer.caves[0][1];
						CaveExplorer.currentRoom.enter();
						return;
					}
					else 
					CaveExplorer.print("Oh no don't you dare surpass me without even beating me!");
					count++;
					input=CaveExplorer.in.nextLine();
				}
				direction=super.convertInput(input);
				super.respondToKey(direction);
			}
		}
		CaveExplorer.currentRoom.leave();
		CaveExplorer.currentRoom=CaveExplorer.caves[0][1];
		CaveExplorer.currentRoom.enter();
	}
	
	
	public String getDescription() {
		return super.getDescription()+"\n Wahahahaha I am Bowser. This is the final level you need to past to get to your precious Prince Peach.";
	}
//
}
