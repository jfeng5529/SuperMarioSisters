package janeLubnaGame;

import caveExplore.CaveExplorer;
import caveExplore.NPC;

public class BooNPC extends NPC {
	private String symbol;
	private String interactDescription;
	public BooNPC() {
		super("You finally encounter the ghost Boo that has been haunting you down. Press e to interact.");
		symbol="b";
		interactDescription="You can't get escape from Boo. Let's just face the reality and press e";
	}
	
	public String getInteractDescription(){
		return interactDescription;
	}
	public String getSymbol() {
		return symbol;
	}
	
	public void interact() {
		CaveExplorer.print("Ah ha I found you Mario! To get past me, you must advance in to this level! Win this game, or lose your life. \n"
				+ "I'm spooooky~~~ ");
		CaveExplorer.print("Press Enter to continue.");
		String input = CaveExplorer.in.nextLine();
		while(input.length()>0) {
		System.out.println("Press Enter and get ready to lose.");
		input = CaveExplorer.in.nextLine();
		}
		LubnaFrontEnd game = new LubnaFrontEnd();
		game.play();
	if(game.result()||game.getCheat()) {
		CaveExplorer.npcs[1].currentNPCRoom().leaveNPC();
			CaveExplorer.npcs[1] = null;
			symbol=" ";
			CaveExplorer.inventory.setKey(true);
		}
	CaveExplorer.currentRoom.leave();
	CaveExplorer.currentRoom=CaveExplorer.caves[0][1];
	CaveExplorer.currentRoom.enter();
	}
	
	
}
