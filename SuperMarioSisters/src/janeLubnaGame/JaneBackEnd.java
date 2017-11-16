package janeLubnaGame;

public class JaneBackEnd implements LubnaSupport {

		public JaneEnemies[] enemies;
		private int candy;
		public static JaneGameMap gameMap;
		private JaneSupport frontend; 
		
	public JaneBackEnd(JaneSupport frontend) {
		this.frontend=frontend;
		this.enemies = new JaneEnemies[4];
		for (int i =0; i <4; i++) {
			enemies[i]=new JaneEnemies();
		}
		candy =0;
		gameMap= new JaneGameMap("Maze");
	}

	public JaneGameMap getPlot() {
		return gameMap;
	}

	public boolean stillPlaying() {
		
		return false;
	}

}
