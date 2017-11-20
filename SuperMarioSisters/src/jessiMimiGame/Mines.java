package jessiMimiGame;

import java.util.Random;

public class Mines extends JessiBackEnd {

	public Mines(JessiSupporter frontend) {
		super(frontend);
	}

	public static JessiMimiPlot[][] createMines() {
		
		int numMines = 10;
		Random rand = new Random();

		for (int i = 0; i < numMines; i++) { 
			int columnMine = rand.nextInt(10);
			int rowMine = rand.nextInt(10);
			
		}
		return plots;
		
	}
	
	public void neighboringMines() {
		
	}

}
