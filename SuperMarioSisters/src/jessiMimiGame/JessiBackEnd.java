package jessiMimiGame;

import caveExplorer.JessiMimiPlot;

public class JessiBackEnd implements MimiSupporter{
	private JessiSupporter frontend;
	private JessiMimiPlot[][] plots;
	private int score;
	private int numberOfMines;
	private boolean safeSpot;

	public JessiBackEnd(JessiSupporter frontend) {
		this.frontend = frontend;
		plots = new JessiMimiPlot[8][8];
		numberOfMines = 6;
		createPlots();
	}

	public void createPlots() {
		for(int row = 0; row < plots.length; row++){
			for(int col = 0; col < plots[row].length; col++){
				plots[row][col] = new JessiMimiPlot(row, col);
			}
		}
	}
	


	@Override
	public JessiMimiPlot[][] getPlots() {
		return plots;

	}	

	@Override
	public boolean checkForMine() {
		if(!safeSpot) {
		return true;
		}
		return false;
	}

	@Override
	public boolean checkWin() {
		// TODO Auto-generated method stub
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
