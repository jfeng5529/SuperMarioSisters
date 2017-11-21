package jessiMimiGame;

//import caveExplorer.JessiMimiPlot;

public class JessiBackEnd implements MimiSupporter{
	private JessiSupporter frontend;
	public static JessiMimiPlot[][] plots;
	private int score;
	private int numberOfMines;
	private boolean safeSpot;

	public JessiBackEnd(JessiSupporter frontend) {
		this.frontend = frontend;
		plots = new JessiMimiPlot[10][10];
		numberOfMines = 6;
		createPlots();
	}

	public void createPlots() {
		for(int row = 0; row < plots.length; row++){
			for(int col = 0; col < plots[row].length; col++){
				plots[row][col] = new JessiMimiPlot(row, col);
			}
		}
		while (safeSpot) {
			System.out.println("Enter Row");
			//int row = input.nextInt();
			System.out.println("Enter Column");
			//int column = input.nextInt();
			
		//	if (plots != 10) {
				//bombs = 0;
			//}
			//else if (plots == 10) {
				//System.out.println("You hit a mine!");
				//safeSpot = false;
				//break;
			}
		}
	//}
	


	public JessiMimiPlot[][] getPlots() {
		return plots;
	}	

	public void clear(int row, int col) {
		for(i = (row-1); i < (row+1); i++) {
			for(j = (col-1); j< (col+1); j++) {
				display();
			}
		}
	}
	
	private void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkForMine() {
		if(!safeSpot) {
		return true;
		}
		return false;
	}
	
	public int[] getValidUserInput() {
		
		return null;
	}

	@Override
	public boolean checkWin() {
		if(score == 50) {
			return true;
		}
		return false;
	}	
	

	public void gameOver() {
		if(checkForMine() == true) {
			MimiFrontEnd.startGame();
		}
		if(checkWin() == true) {
			System.out.println("Wahh! Nooo! You have defeated me!");
			//Mini game over proceeds to the next room
		}
		//else {
		//	MimiFrontEnd.displayScoreStatus();
		//}
	}
	
}
