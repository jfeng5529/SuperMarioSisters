package janeLubnaGame;

import caveExplore.CaveExplorer;
import caveExplore.NPC;

public class BooNPC extends NPC {
	private boolean move;
	public BooNPC() {
		super("You finally encounter the ghost Boo that has been haunting you down. Press e to interact.");
		
	}
	

	public String getSymbol() {
		return "b";
	}
	
	public void interact() {
		this.move=true;
		CaveExplorer.print("Ah ha I found you Mario! To get past me, you must advance in to this level! Win this game, or lose your life. \n"
				+ "I'm spooooky~~~ ");
		CaveExplorer.print("Press Enter to continue.");
		String input = CaveExplorer.in.nextLine();
		while(input.length()>1) {
		System.out.println("Press Enter and get ready to lose.");
		input = CaveExplorer.in.nextLine();
		}
		LubnaFrontEnd game = new LubnaFrontEnd();
		game.play();
	}
	
}
