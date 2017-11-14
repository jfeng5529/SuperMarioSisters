package jessiMimiGame;

public class JessiBackEnd implements MimiSupporter{
	private JessiSupporter frontend;
	private JessiMimiPlot[][] plots;
	private int score;

public JessiBackEnd(JessiSupporter frontend) {
	this.frontend = frontend;
	plots = new JessiMimiPlot[8][8];
	numberOfMines = 6;
	createPlots();
}

private void createPlots() {
	// TODO Auto-generated method stub
	
}

private boolean checkWin() {
	return false;
}

}
