package janeLubnaGame;

import caveExplore.CaveExplorer;
import caveExplore.NPC;

public class BooNPC extends NPC {
	
	private boolean active;

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
		String s = CaveExplorer.in.nextLine();
		while(!s.equalsIgnoreCase(" ")) {
			CaveExplorer.print("Press Enter and get ready to lose!");
			s=CaveExplorer.in.nextLine();
		}
		LubnaFrontEnd game = new LubnaFrontEnd();
		this.active =false;

	}
}