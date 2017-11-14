package janeLubnaGame;

import caveExplore.CaveExplorer;
import caveExplore.CaveRoom;

public class JaneGameMap extends CaveRoom {
	
	private Candy candy;
	
	public JaneGameMap(String description) {
		super(description);
		candy= new Candy();
	}
	
	public static void setUpDoors() {
		CaveRoom[][] =CaveExplorer.caves;
	}
	
	public void enter() {
		super.enter();
		LubnaFrontEnd.bag.addPoints();
	}
}
