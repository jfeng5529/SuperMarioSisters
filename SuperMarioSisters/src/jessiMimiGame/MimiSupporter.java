package jessiMimiGame;

public interface MimiSupporter {

	MineField getPlots();

	void reveal(MineField p);

	int[] getCoordInput();

	void reveal(int row, int col);

}
