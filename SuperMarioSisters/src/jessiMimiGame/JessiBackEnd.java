package jessiMimiGame;

//import caveExplorer.JessiMimiPlot;

public class JessiBackEnd implements MimiSupporter{
	private JessiSupporter frontend;
	public static JessiMimiPlot[][] plots;
	private int score;
	private int numberOfMines;
	private boolean safeSpot;
	private int space;
	
	public String unknown = " ";
	public String mine = "*";

	public JessiBackEnd(JessiSupporter frontend) {
		this.frontend = frontend;
		plots = new JessiMimiPlot[12][12];
		numberOfMines = 10;
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
		
			System.out.println("Enter Column");

			
			if (space != 10 ) {
				numberOfMines = 0;
			}
			else if (space == 10) {
				System.out.println("You hit a mine!");
				safeSpot = false;
				break;
			}
		}
	}
	
	public JessiMimiPlot[][] getPlots() {
		return plots;
	}	

	
	public void generateMines() {
		Mines.createMines();
	}
	
	public void clear(int row, int col) {
		 for(int i = (row - 1); i <= (row + 1); i++){
		      for(int j = (col - 1); j <= (col + 1); j++){
		        if(int[row][col].equals(unknown) == true) {
		        	display();
		        }
		      }
		 }
	}
	
	private void display() {
		
		
	}

	public JessiMimiPlot getTile(int row, int col){
		return plots[row][col];
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

	public  boolean isRevealed() {
		if(!safeSpot) {
			gameRevealed();
			gameOver();
		}
		return false;
	}
	
	private void gameRevealed() {
		
		
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
