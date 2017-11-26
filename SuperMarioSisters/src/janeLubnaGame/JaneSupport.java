package janeLubnaGame;

import caveExplore.CaveRoom;

public interface JaneSupport {

	JaneGameMap[][] getPlots();

	void printAllowedEntry();

	void updatePlot();

	void setEnemies(JaneEnemies[] enemies);

	void setCurrentRoom(JaneGameMap janeGameMap);

	JaneGameMap getCurrentRoom();

	JaneEnemies[] getEnemies();

	void setPlots(JaneGameMap[][] janeGameMaps);
}