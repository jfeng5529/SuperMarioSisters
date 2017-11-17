package janeLubnaGame;

import caveExplore.CaveRoom;
import caveExplore.NPCRoom;

public class LubnaFrontEnd implements JaneSupport {
	
	private LubnaSupport backend;
	public static JaneStorageBag bag; 
	public static JaneGameMap[][] plot; //every room in the cave
	public static CaveRoom currentRoom; // changes based on how the user navigate

	public LubnaFrontEnd() {
		backend= new JaneBackEnd(this);
		plot=backend.getPlot();
	}
	
	public static JaneGameMap[][] getCurrentPlot() {
		return plot;
	}
	public static final void main(String[] args) {
		LubnaFrontEnd demo = new LubnaFrontEnd();
		JaneGameMap.setUpCaves();
		bag=new JaneStorageBag();
		demo.play();
	}

	private void play() {
		introduction();
		menu();
		
	}

	private void menu() {
		rules();
		startPlaying();
		
	}

	private void startPlaying() {
		while(backend.stillPlaying()) {
			backend.action();
			displayBoard();
			displayScore();
			String input = getValidUserInput();
			currentRoom.interpretInput(input);
		}
		printGameResult();
	}

	private void printGameResult() {
		// TODO Auto-generated method stub
		
	}

	private String getValidUserInput() {
		// use in.nextLine and checks if the user input is valid using valid keys.
		return null;
	}

	private void displayScore() {
		// displays scores from the backend.
		
	}

	private void displayBoard() {
		//displays the map.
	
		
	}

	private void rules() {
		System.out.println("You must avoid Boo and eat all the candy to win and get the key to enter last challenge");
		
	}

	private void introduction() {
		System.out.println("Welcome to our game.");
	}
}
