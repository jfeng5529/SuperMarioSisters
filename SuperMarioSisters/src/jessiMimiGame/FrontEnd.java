package jessiMimiGame;

import java.util.Scanner;

import caveExplore.CaveExplorer;
import caveExplore.CaveRoom;
import caveExplore.NPCRoom;

public class FrontEnd implements JessiSupporter{
	private static MimiSupporter backend;
	private boolean safeSpot = true;
    private boolean isWin;
    private boolean cheat;

	public FrontEnd() {
		backend = new JessiBackEnd(this);
		CaveExplorer.in = new Scanner(System.in);
		isWin = false;
		cheat = false;
	}
	
	public static final void main(String[] args) {
		FrontEnd demo = new FrontEnd();
		demo.play();
	}

	private void play() {
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
				System.out.println("Ah noooo you have defeated me!!! YOU WIN!");
				JessiBackEnd.displayField(plots);
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
				+ "\n Enter in the coordinates of a space on my map, and some empty spaces will open up."
				+ "\n Each time an empty space is revealed, it will show the number of spaces in its perimeter that have Bob-ombs hidden in them!"
				+ "\n Each time you successfully choose an empty space, you earn five points!"
				+ "\n If you can get 50 points, you have defeated me, but I'm not an easy guy to beat! Try me!"); 
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
