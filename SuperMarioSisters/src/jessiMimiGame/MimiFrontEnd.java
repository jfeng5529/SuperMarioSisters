package jessiMimiGame;

public class MimiFrontEnd implements JessiSupporter{

	private static MimiSupporter backend;
	private static int score;
	private static boolean safeSpot;
	private int moves;
	
	public static final void main(String[] args) {
		MimiFrontEnd demo = new MimiFrontEnd();
		demo.play();
	}
	
	public MimiFrontEnd() {
		backend = new JessiBackEnd(this);
		moves = 0;
	}
	
	public void play() {
		introduction();
		menu();
	}
	
	private String introduction() {
		return "AHAHAHAHA!!!! You've made it this far, but can you defeat me??? BOWSER????";
	}

	public void menu() {
		rules();
		startGame();
		System.out.println("Enter 'i' for instructions on how to play or 's' to start playing!");
	}
	
	private void rules() {
		
	}
	
	public static void startGame() {
		JessiMimiPlot[][] plots = backend.getPlots();
		JessiMimiPlot p = null;
		while(safeSpot == true) {
			score += 5;
			displayScoreStatus();
			if(backend.checkWin()) {
				safeSpot = false;
			}
			else {
				JessiBackEnd.getValidUserInput();
				if(backend.checkForMine()) {
					safeSpot = false;
				}
			}
		}
		System.out.println("___________Game Over___________\n");
	}

	public void displayField() {
		
	}
	
	public static void displayScoreStatus() {
		String scoreStatus = "";
		System.out.println("Your have a current score of " + score + " points!");
	}
	
}
