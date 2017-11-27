package jessiMimiGame;

import java.util.Scanner;

import caveExplore.CaveExplorer;
import caveExplore.CaveRoom;
import caveExplore.NPCRoom;

public class MimiFrontEnd implements JessiSupporter{
	private static MimiSupporter backend;
	private boolean safeSpot = true;
    public boolean isWin;
    private boolean cheat;

	public MimiFrontEnd() {
		backend = new JessiBackEnd(this);
		CaveExplorer.in = new Scanner(System.in);
		isWin = false;
		cheat = false;
	}
	
	public static final void main(String[] args) {
		MimiFrontEnd demo = new MimiFrontEnd();
		demo.play();
	}

	public void play() {
		introduction();
		//startGame();
	}
	
	private void startGame() {
		JessiMineField plots = backend.getPlots();
		while(safeSpot) {
			JessiBackEnd.displayField(plots);
			System.out.println("Type in the row and column!");
			int[] coords = backend.getCoordInput();
			if(coords[2] == 1) {
				cheat = true;
				break;
			}
			if (backend.reveal(coords[0], coords[1])) {
				safeSpot = false;
				JessiBackEnd.displayField(plots);
			}
			if(backend.isWin()) {
				System.out.println("Ahhh YOU WIN!! FINE! Take your prince!!");
				//JessiBackEnd.displayField(plots);
			}
		}
		if (cheat) {
			System.out.println("Too Hard?  Here's the answer!");
			plots.setRevealAll();
			JessiBackEnd.displayField(plots);
		}
		else {
			System.out.println("                   YOU HAVE HIT A BOB-OMB!!!");
			System.out.println("                 __________Game Over__________\n");
		}
	}
		
	public String validKeys() {
		return "wasdrp";
	}
	
	private void rules() {
		MimiUtility.print("MWAHAHAHAAA! This is Bob-omb Sweeper! Try not to choose a space with Bob-ombs hidden in them."
				+ "\n Enter in the coordinates of a space on my map, and the space will either be empty or a Bob-omb!."
				+ "\n Each time an empty space is revealed, it will show the number of spaces in its perimeter that have Bob-ombs hidden in them!"
				+ "\n If you can reveal all of the empty spaces without revealing a Bob-omb, you can take your prince!"
				+ "\n Sounds easy? I'm not an easy guy to beat! Try me!"); 
	}
	
	private void introduction() {
		System.out.println("BOSS LEVEL:YOU'VE ENCOUNTERED BOWSER, IN ORDER TO RESCUE YOUR PRINCE AND PROCEED TO THE NEXT ROOM WIN THIS GAME.");
		System.out.println("Press the letter 'r' to get the instructions or 'p' to play.");
		String command = MimiUtility.waitForLetterInput("rp");
		if(command.equals("r")) {
			rules();
			startGame();
		}else {
			startGame();
		}
	
	}
	
}
