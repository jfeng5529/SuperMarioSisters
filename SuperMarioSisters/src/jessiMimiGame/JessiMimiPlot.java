package jessiMimiGame;

public class JessiMimiPlot {
	
	private boolean revealed;
	private int row;
	private int column;
	
	public JessiMimiPlot(int row2, int col) {
		this.row = row;
		this.column = column;
		revealed = false;
	}
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	
	public void revealed() {
		revealed = true;
	}
	
	public boolean isRevealed() {
		return revealed;
	}
	
	public boolean getIsMine() {
		return false;
	}
	
	public void createPlot() {
		createMines();
		countNeighboringMines();
	}
	
}
