package jessiMimiGame;

public interface MimiSupporter {

	JessiMineField getPlots();

	int[] getCoordInput();

	boolean reveal(int row, int col);

	boolean isWin();

}
