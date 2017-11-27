package caveExplore;

import jessiMimiGame.MimiFrontEnd;

public class BowserRoom extends NPCRoom {
	private String content;
	private String win;
	public BowserRoom(String description) {
		super(description);
		content = "B";
		win=" ";
	}
	
	public String validKeys() {
		return "wdsae";
	}
	
	public String getContents() {
		return content;
	}
	public void respondToKey(int direction) {
		if(CaveExplorer.inventory.getKey()) {
			keyInteract(direction);
		}
		else if(!CaveExplorer.inventory.getKey()){
			noKeyInteract(direction);
		}
}
	
	public void noKeyInteract(int direction) {
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
		else if(win.equals("win")) {
			super.respondToKey(direction);
		}
	}
	
	public void keyInteract(int direction) {
		if(direction==4) {
			CaveExplorer.print("BOWWWW You think you can beat me Maria?! How funny! Let me show you how this is going down!");
			MimiFrontEnd game = new MimiFrontEnd();
			game.play();
			CaveExplorer.currentRoom.leave();
			if(game.getIsWin()) {
				content=" ";
				win="win";
				CaveExplorer.currentRoom=CaveExplorer.caves[5][9];
			}
			else {
				content="B";
				win="lost";
				CaveExplorer.currentRoom=CaveExplorer.caves[5][7];
			}
			CaveExplorer.currentRoom.enter();
		}
		else	{
			super.respondToKey(direction);
		}
		
	}

	public String getDescription() {
		return super.getDescription()+"\nWahahahaha I am Bowser. This is the final level you need to past to get to your precious Prince Peach. Press 'e'.";
	}
//
}
