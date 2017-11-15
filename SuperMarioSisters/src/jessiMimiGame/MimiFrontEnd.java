package jessiMimiGame;

public class MimiFrontEnd implements JessiSupporter{

	private MimiSupporter backend;
	private int score;
	private boolean safeSpot;
	private int moves;
	
	public static final void main(String[] args) {
		MimiFrontEnd demo = new MimiFrontEnd();
		demo.play();
	}
	
	public void play() {
		menu();
		startGame();
	}

	public MimiFrontEnd() {
		backend = new JessiBackEnd(this);
		moves = 0;
	}
	
	public void startGame() {
		JessiMimiPlot[][] plots = backend.getPlots();
		JessiMimiPlot p = null;
		while(safeSpot == true) {
			score += 5;
			displayScoreStatus();
			if(backend.checkWin()) {
				safeSpot = false;
			}
			else {
				String input = getValidUserInput();
				if(backend.checkForMine()) {
					safeSpot = false;
				}
			}
		}
		System.out.println("___________Game Over___________\n");
	}
	
	private String getValidUserInput() {
		return null;
	}

	public void displayField() {
		
	}
	
	public void displayScoreStatus() {
		String scoreStatus = "";
		System.out.println("Your have a current score of " + score + " points!");
	}
	
	public void menu() {
		System.out.println("Enter 'i' for instructions on how to play or 's' to start playing!");
	}
	
}
