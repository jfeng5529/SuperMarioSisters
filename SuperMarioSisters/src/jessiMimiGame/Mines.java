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
					 
				 }
					 
			 }
		}
	}
}
