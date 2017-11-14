package janeLubnaGame;

import caveExplore.CaveRoom;

public class LubnaFrontEnd implements JaneSupport {
	
	private LubnaSupport backend;
	public static JaneStoargeBag bag; 
	public static JaneGameMap[][] caves; //every room in the cave
	public static JaneGameMap currentRoom; // changes based on how the user navigate

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
		// TODO Auto-generated method stub
		
	}

	private void rules() {
		// TODO Auto-generated method stub
		
	}

	private void introduction() {
		
		
	}
}
