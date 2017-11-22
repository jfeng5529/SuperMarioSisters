package janeLubnaGame;

import caveExplore.CaveExplorer;
import caveExplore.NPC;

public class BooNPC extends NPC {

	public BooNPC() {
		super();
	}
	
	public String getSymbol() {
		return "b";
	}
	
	public void interact() {
		CaveExplorer.print("Ah ha I found you Mario! To get past me, you must advance in to this level! Win this game, or lose your life. \n"
				+ "I'm spooooky~~~ ");
		CaveExplorer.print("Press Enter to continue.");
		CaveExplorer.in.nextLine();
		String input = CaveExplorer.in.nextLine();
		while(input.length()>1) {
		System.out.println("Press Enter and get ready to lose.");
		input = CaveExplorer.in.nextLine();
		}
		LubnaFrontEnd game = new LubnaFrontEnd();
		game.play();
	}
	
}