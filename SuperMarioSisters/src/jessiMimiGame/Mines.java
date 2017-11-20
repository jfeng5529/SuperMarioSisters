package jessiMimiGame;

import java.util.Random;

public class Mines extends JessiBackEnd {

	public Mines(JessiSupporter frontend) {
		super(frontend);
		// TODO Auto-generated constructor stub
	}

	public static JessiMimiPlot[][] createMines() {
		
		int numMines = 5;
		Random rand = new Random();

		for (int i = 0; i < numMines; i++) { 
			int columnMine = rand.nextInt(5);
			int rowMine = rand.nextInt(5);
			//plots[rowMine][columnMine] = ;
		}
		return plots;
	}

}
