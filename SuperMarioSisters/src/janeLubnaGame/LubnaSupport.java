package janeLubnaGame;

public interface LubnaSupport {

	/**
	 * return the map for the game
	 */
	JaneGameMap[][] getPlot();
	
	/**
	 * @ check if the game is still in session
	 */
	boolean stillPlaying();

	void action();

	
}
