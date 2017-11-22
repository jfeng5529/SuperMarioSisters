package jessiMimiGame;

public class MimiFrontEnd implements JessiSupporter{
	
	private static MimiSupporter backend;
	private static int score;
	private static boolean safeSpot;
	private int moves;
	
	private int[][] mines;

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
		System.out.println("BOSS BATTLE! Press 'r' for the rules of my game or press 'p' to play, but it won't be easy!");
		rules();
		startGame();
	}

	public String validKeys() {
		return "wasdrp";
	}

	private String rules() {
		validKeys();
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
					System.out.println("___________Game Over___________\n");
				}
			}
		}
	}

	public boolean allOpenSpacesChecked(){
		int count=0;
		for(int row = 1 ; row < 9 ; row++)
			for(int column = 1 ; column < 9 ; column++)
				if(JessiMimiPlot[row][column]=='-')
					count++;
		if(count == 10)
			return true;
		else
			return false;                
	}

	public void displayField(JessiMimiPlot[][] plots) {
		String rows = "0123456789";
		String columns = "  0123456789";
		for(int row = 0; row < plots.length; row++){
			System.out.print(rows.substring(row, row+1)+"-");
			for(int col = 0; col < plots[row].length; col++){
				if(plots[row][col].isRevealed()){
					if(plots[row][col].JessiBackEnd.isMine()){
						System.out.print("*");
					}else{
						System.out.print(" ");	
					}
				}
				System.out.println(" " + rows.substring(row, row+1));
			}
			System.out.println(columns.substring(0, plots[0].length+2));
		}
		
		public void startBoard(){
	        for(int row = 1 ; row < mines.length ; row++)
	            for(int col = 1 ; col < mines.length ; col++)
	                JessiMimiPlot[row][col]= '-';
	    }


		public static void displayScoreStatus() {
			//String scoreStatus = "";
			System.out.println("You have a current score of " + score + " points!");
		}

	}
