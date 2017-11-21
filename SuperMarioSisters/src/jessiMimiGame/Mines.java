package jessiMimiGame;

import java.util.Random;

public class Mines extends JessiBackEnd {

	int [][] array = new int[10][10];
	private boolean isMine;
	
	public Mines(JessiSupporter frontend) {
		super(frontend);
	}

	public void createMines() {
		
		int numMines = 10;
		Random rand = new Random();

		for (int i = 0; i < numMines; i++) { 
			int randRow = (int)(Math.random()*10);
			int randCol = (int)(Math.random()*10);
		}
		isMine = true;
	}

	public void countNeighboringMines() {
		for (int row = 0; row < plots.length; row++) {
			 for (int col = 0; col < plots.length; col++) {
				 if (!(plots[row][col].getIsMine())) {
					 int count = 0;
					 for (int i = row - 1; i <= row + 1; i++) {
	                    for (int j = col - 1; j <= col + 1; j++) {
	                    	 if (0 <= i && i < plots.length && 0 <= j && j < plots.length) {
	                                 if (plots[row][col].getIsMine()) {
	                                     count++;
	                                 }
	                    	 }
	                    }
					 }
					  plots[row][col].setAdjacentMines(count);
				 }
			 }
		}
	}
	
	public void 

}
