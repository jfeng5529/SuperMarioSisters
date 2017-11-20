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

	private void play() {
		updatePlot();
		introduction();
		menu();
		
	}

	private void menu() {
		rules();
		startPlaying();
		
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
			update();
		}
		printGameResult();
	}
	
	private void update() {
		// TODO Auto-generated method stub
		
	}

	private int convertToDirection(String input) {
		return "wasde".indexOf(input);
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
		if(input.equals("cheatCode")) {
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
				for(JaneGameMap plot: row) {
					if(plot.getConnection(JaneGameMap.WEST) != null )
						text += " ";
					else
						text += "|";
					if(i == 0)
						text += "   ";
					else if(i == 1)
						text += " " + plot.getContents() + " ";
					else if(i == 2)
						if(plot.getConnection(JaneGameMap.SOUTH) != null)
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
		System.out.println("You must avoid Boo and eat all the candy to win and get the key to enter last challenge");
		
	}

	private void introduction() {
		System.out.println("Welcome to our game.");
	}

	public JaneGameMap[][] getPlots() {
		return plot;
	}

	public int getCandy() {
		return candyNum;
	}

}
