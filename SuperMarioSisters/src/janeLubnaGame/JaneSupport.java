package janeLubnaGame;

import caveExplore.CaveRoom;

public interface JaneSupport {

	JaneGameMap[][] getPlots();

	void printAllowedEntry();

	int getCandy();

	void updatePlot();

	void setEnemies(JaneEnemies[] enemies);

}
