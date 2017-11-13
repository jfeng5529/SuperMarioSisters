package janeLubnaGame;

public class JaneBackEnd implements LubnaSupport {

		private JaneEnemies[] enemies;
		private int candy;
		private JaneGameMap gameMap;
		
	public JaneBackEnd(JaneSupport frontend) {
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

}
