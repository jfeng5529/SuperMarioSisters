package janeLubnaGame;

import caveExplore.CaveRoom;
import caveExplore.NPCRoom;

public class LubnaFrontEnd implements JaneSupport {
	
	private LubnaSupport backend;
	public static JaneStoargeBag bag; 
	public static JaneGameMap[][] caves; //every room in the cave
	public static NPCRoom currentRoom; // changes based on how the user navigate

	public LubnaFrontEnd() {
		backend= new JaneBackEnd(this);
		bag=new JaneStoargeBag();
	}
	
	public static final void main(String[] args) {
		LubnaFrontEnd demo = new LubnaFrontEnd();
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
		// TODO Auto-generated method stub
		return null;
	}

	private void displayScore() {
		// TODO Auto-generated method stub
		
	}

	private void displayBoard() {
		backend.getPlot();
		JaneGameMap.setUpCaves();
		
	}

	private void rules() {
		System.out.println("You must aviod Boo and eat all the candy to win and get the key to enter last challenge");
		
	}

	private void introduction() {
		System.out.println("Welcome to our game");
	}
}
