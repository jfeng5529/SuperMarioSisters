package janeLubnaGame;

import java.util.Scanner;

import caveExplore.CaveExplorer;
import caveExplore.CaveRoom;
import caveExplore.NPCRoom;

public class LubnaFrontEnd implements JaneSupport {

	private LubnaSupport backend;
	private JaneEnemies[] enemies;
	private int candyNum;
	private JaneGameMap[][] plot; //every room in the cave
	private JaneGameMap currentRoom; // changes based on how the user navigate
	private boolean winResult;
	private String map;


	public LubnaFrontEnd() {
		backend=new JaneBackEnd(this);
		winResult=false;
		candyNum=0;
		CaveExplorer.in = new Scanner(System.in);
		backend.setUpPlot();

	}


	public static final void main(String[] args) {
		LubnaFrontEnd demo = new LubnaFrontEnd();
		demo.play();
	}

	public void play() {
		updatePlot();
		introduction();
		menu();

	}

	private void menu() {
		CaveExplorer.print("Are you ready to beat Boo and move on to the next level to save Prince Peach? Press 'r' for ready!");
		String input = CaveExplorer.in.nextLine();
		while(!input.equals("r")) {
		System.out.println("Too bad if you are not ready. Heroes don't wait for time. Press 'r'!");
		input = CaveExplorer.in.nextLine();
		}
		startPlaying();
	}

	private void introduction() {
		System.out.println("LEVEL ONE:YOU'VE ENCOUNTERED BOO, IN ORDER TO RESCUE YOUR PRINCE WIN THIS GAME.");
		System.out.println("Press Enter to get the instructions.");
		String input = CaveExplorer.in.nextLine();
		while(input.length()>1) {
		System.out.println("Press Enter to get the instructions. It's not that hard.");
		input = CaveExplorer.in.nextLine();
		}
		rules();
	}
	
	private void startPlaying() {
		while(backend.stillPlaying()) {
			backend.enemiesAction();
			updatePlot();
			displayBoard();
			displayScore();
			String input = getValidUserInput();
			if(input.equals("cheatcode")) {
				printGameResult();
				break;
			}
			int direction =convertToDirection(input);
			backend.respondToKey(direction);
			updatePlot();
		}
		printGameResult();
	}


	private int convertToDirection(String input) {
		return "wdsae".indexOf(input);
	}

	public void printAllowedEntry() {
		System.out.println("You can only enter w, a, s, d to move and 'e' to interact with Boo the enemie");
	}

	private void printGameResult() {
		//need more work from backend
		CaveExplorer.print("Winner");

	}

	private String getValidUserInput() {
		String input= CaveExplorer.in.nextLine();
		if(input.equals("cheatcode")) {
			return input;
		}
		while(!backend.isValid(input)) {
			printAllowedEntry();
			input=CaveExplorer.in.nextLine();
		}
		return input;
	}

	private void displayScore() {
		// displays scores from the backend.

	}

	private void displayBoard() {
		CaveExplorer.print(mapDescription());


	}

	public  void updatePlot() {
		map = "\n ";
		for(int i = 0; i < plot[0].length - 1; i++)
			map += "____";
		map += "___\n";
		for(JaneGameMap[] row: plot)
			for(int i = 0; i < 3; i++) {
				String text = "";
				for(JaneGameMap plot1: row) {
					if(plot1.getConnection(JaneGameMap.WEST) != null )
						text += " ";
					else
						text += "|";
					if(i == 0)
						text += "   ";
					else if(i == 1)
						text += " " + plot1.getContents() + " ";
					else if(i == 2)
						if(plot1.getConnection(JaneGameMap.SOUTH) != null)
							text += "   ";
						else
							text += "___";
				}
				text += "|";
				map += text + "\n";
			}
	}

	public String mapDescription() {
		return map;
	}

	private void rules() {
		CaveExplorer.print("You must avoid Boo and eat all the candy to win and get the key to enter last challenge. \nHints: if you have collected flashlights in the cave, then you use it to scare off Boo"
				+ " if the time comes. GOOOOOOD LUCKKK~~");

	}


	public JaneGameMap[][] getPlots() {
		return plot;
	}

	public int getCandy() {
		return candyNum;
	}


	@Override
	public void setEnemies(JaneEnemies[] enemies) {
		this.enemies = enemies;

	}


	@Override
	public void setCurrentRoom( JaneGameMap currentRoom) {

		this.currentRoom = currentRoom;
	}


	@Override
	public JaneGameMap getCurrentRoom() {

		return currentRoom;
	}


	@Override
	public JaneEnemies[] getEnemies() {

		return enemies;
	}


	@Override
	public void setPlots(JaneGameMap[][] plot) {
		this.plot = plot;
	}
}
