package jessiMimiGame;

public class JessiMineField {
    JessiMines [][] MineField;
	
	public JessiMineField() {
		MineField = new JessiMines[10][10];
		for (int row=0;row<10;row++) {
			for (int col=0;col<10;col++) {
				MineField[row][col] = new JessiMines();
			}
		}
		createMines();
	}
			
	public void createMines() {
		
		int numMines = 10;
		for (int i = 0; i < numMines; i++) { 
			int randRow = (int)(Math.random()*10);
			int randCol = (int)(Math.random()*10);
			MineField[randRow][randCol].setisMine(true);
		}
	}
	
	public int countNeighboringMines(int row,int col) {
		int count = 0;
		if(checkIsMine(row-1,col-1)) count++;
		if(checkIsMine(row-1,col)) count++;
		if(checkIsMine(row-1,col+1)) count++;
		if(checkIsMine(row,col-1)) count++;
		if(checkIsMine(row,col+1)) count++;
		if(checkIsMine(row+1,col-1)) count++;
		if(checkIsMine(row+1,col)) count++;
		if(checkIsMine(row+1,col+1)) count++;
		return count;
	}
	
	public boolean checkIsMine(int row, int col) {
		if(row < 0 || row >= 10) return false;
		if(col < 0 || col >= 10) return false;
		return MineField[row][col].getIsMine();
	}
	
	public void setRevealed(int row, int col) {
		if (row < 0 || row >=10) return;
		if (col < 0 || col >=10) return;
		MineField[row][col].setIsRevealed(true);
		int num = countNeighboringMines(row, col);
		if (num == 0) {
			if (!isRevealed(row-1, col-1)) setRevealed(row-1, col-1);
			if (!isRevealed(row-1, col)) setRevealed(row-1, col);
			if (!isRevealed(row-1, col+1)) setRevealed(row-1, col+1);
			if (!isRevealed(row, col-1)) setRevealed(row, col-1);
			if (!isRevealed(row, col+1)) setRevealed(row, col+1);
			if (!isRevealed(row+1, col-1)) setRevealed(row+1, col-1);
			if (!isRevealed(row+1, col)) setRevealed(row+1, col);
			if (!isRevealed(row+1, col+1)) setRevealed(row+1, col+1);
		}
	}

	public boolean isRevealed(int row, int col) {
		if (row < 0 || row >=10) return false;
		if (col < 0 || col >=10) return false;
		return MineField[row][col].getIsRevealed();
	}
	
	public void setRevealAll() {
		for (int row=0;row<10;row++) {
			for (int col=0;col<10;col++) {
				MineField[row][col].setIsRevealed(true);
			}
		}
	}

	public String display() {
		// TODO Auto-generated method stub
		return null;
	}

}
