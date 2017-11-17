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
		System.out.println("Press 'r' for the rules of my game or press 's' to start, but it won't be easy!");
		rules();
		startGame();
	}
	
	private String rules() {
		return "MWAHAHAHAAA! This is Bob-omb Sweeper! Try not to choose a space with Bob-ombs hidden in them."
				+ "\n Enter in the coordinates of a space on my map, and some empty spaces will open up."
				+ "\n Each time an empty space is revealed, it will show the number of spaces in its perimeter that have Bob-ombs hidden in them!"
				+ "\n Each time you successfully choose an empty space, you earn five points!"
				+ "\n If you can get 50 points, you have defeated me, but I'm not an easy guy to beat! Try me!";
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
				//JessiBackEnd.getValidUserInput();
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
		System.out.println("You have a current score of " + score + " points!");
	}
	
}
