package jessiMimiGame;

public interface MimiSupporter {

	MineField getPlots();

	int[] getCoordInput();

	boolean reveal(int row, int col);

}
