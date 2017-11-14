package jessiMimiGame;

public class MimiFrontEnd implements JessiSupporter{

	private MimiSupporter backend;
	private int score;
	private boolean safeSpot;
	
	public static final void main(String[] args) {
		MimiFrontEnd demo = new MimiFrontEnd();
		demo.play();
	}
	
	private void play() {
		
	}

	public MimiFrontEnd() {
		backend = new JessiBackEnd(this);
		moves = 0;
	}
	
	private void startGame() {
		JessiMimiPlot[][] plots = backend.getPlots();
		JessiMimiPlot p = null;
		while(safeSpot = true) {
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
		// TODO Auto-generated method stub
		return null;
	}


	private void displayField() {
		
	}
	
	public void displayScoreStatus() {
		
	}
	
	private void menu() {
		System.out.println("Enter 'i' for instructions on how to play or 's' to start playing!");
	}
	
}
