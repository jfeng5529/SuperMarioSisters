package janeLubnaGame;

import caveExplore.Inventory;

public class JaneBackEnd implements LubnaSupport {

		public static JaneEnemies[] enemies;
		private int candy;
		public static JaneGameMap[][] gameMap;
		public static JaneSupport frontend; 
		public static JaneStorageBag bag;
		
	public JaneBackEnd(JaneSupport frontend) {
		this.frontend=frontend;
		this.enemies = new JaneEnemies[4];
		for (int i =0; i <4; i++) {
			enemies[i]=new JaneEnemies();
		}
		candy =0;
		gameMap= new JaneGameMap[6][10];
	}

	public JaneGameMap[][] getPlot() {
		return gameMap;
	}

	public boolean stillPlaying() {
		
		return false;
	}
	
	public void action() {
		bag.updateMap();
	}
	
	public static JaneSupport getFrontend() {
		return frontend;
	}

}
