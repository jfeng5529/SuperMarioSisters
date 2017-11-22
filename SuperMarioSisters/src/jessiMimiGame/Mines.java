package jessiMimiGame;

import java.util.Random;

public class Mines extends JessiBackEnd {

	boolean [][] mineField = new boolean[10][10];
//	private boolean isMine;
	
	public Mines(JessiSupporter frontend) {
		super(frontend);
	}

	public void createMines() {
		
		int numMines = 10;
		Random rand = new Random();

		for (int i = 0; i < numMines; i++) { 
			int randRow = (int)(Math.random()*10);
			int randCol = (int)(Math.random()*10);
			mineField[randRow][randCol] = true;
		}
//		isMine = true;
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
		if(row < 0 || row > 10) return false;
		if(col < 0 || col > 10) return false;
		return mineField[row][col];
	}
	
	
}