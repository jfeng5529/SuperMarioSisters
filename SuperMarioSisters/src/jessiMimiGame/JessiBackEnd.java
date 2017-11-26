package jessiMimiGame;

import caveExplore.CaveExplorer;

public class JessiBackEnd implements MimiSupporter{
	private JessiSupporter frontend;
	public static MineField plots;
	private int numberOfMines;
	private boolean safeSpot;

	public JessiBackEnd(JessiSupporter frontend) {
		this.frontend = frontend;
		plots = new MineField();
		numberOfMines = 10;
		createPlots();
	}

	public void createPlots() {
		plots = new MineField();
	}
	
	public MineField getPlots() {
		return plots;
	}
	
	public static void displayField(MineField plots) {
	    System.out.println("           0    1    2    3    4    5    6    7    8    9");
	    System.out.println("        -------------------------------------------------");
        for(int row = 0 ; row < 10 ; row++){
            System.out.print("       "+row + "|");
            
            for(int col = 0 ; col < 10 ; col++) {
            		String display = "-";
            		if (plots.isRevealed(row, col)) {
            			if (plots.checkIsMine(row, col)) {
            				display = "*";
            			}
            			else {
            				display = "" + plots.countNeighboringMines(row, col);
            			}
            		}
            		System.out.print("  " + display + "  ");
            }
                
            System.out.println();
        }
	}
		
	public int[] getCoordInput() {
		String input = CaveExplorer.in.nextLine();
		int[] coords = toCoords(input);
		while(coords == null){
			System.out.println("You must enter cordinates of the form:\n          <row>,<col>"
					+ "\n<row> and <col> should be integers.");
			input = CaveExplorer.in.nextLine();
			coords = toCoords(input);
		}
		return coords;
	}
	
	private int[] toCoords(String input) {
		try{
			int a = Integer.parseInt(input.substring(0,1));
			int b = Integer.parseInt(input.substring(2,3));
			if(input.substring(1,2).equals(",") && input.length() ==3){
				int[] coords = {a,b};
				return coords;
			}else{
				return null;
			}
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public void reveal(int row, int col) {
		if (plots.checkIsMine(row, col)) {
			plots.setRevealAll();
		}
		else {
			plots.setRevealed(row,col);
		}
	}
	
}
