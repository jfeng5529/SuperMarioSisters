package jessiMimiGame;

import caveExplore.CaveExplorer;

public class JessiBackEnd implements MimiSupporter{
	private JessiSupporter frontend;
	public static JessiMineField plots;
	private int numberOfMines;
	private boolean safeSpot;

	public JessiBackEnd(JessiSupporter frontend) {
		this.frontend = frontend;
		plots = new JessiMineField();
		numberOfMines = 10;
		createPlots();
	}

	public void createPlots() {
		plots = new JessiMineField();
	}
	
	public JessiMineField getPlots() {
		return plots;
	}
	
	public static void displayField(JessiMineField plots) {
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
		if(input.equals("skip")) {
			int[] coords = {0,0,1};
			return coords;
		}
		int[] coords = toCoords(input);
		while(coords == null){
			System.out.println("Please type in the correct integers in the form <row>,<col>.");
			input = CaveExplorer.in.nextLine();
			if(input.equals("skip")) {
				int[] coords2 = {0,0,1};
				return coords2;
			}
			coords = toCoords(input);
		}
		int[] coords2 = {coords[0], coords[1], 0};
		return coords2;
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
	public boolean reveal(int row, int col) {
		if (plots.checkIsMine(row, col)) {
			plots.setRevealAll();
			return true;
		}
		else {
			plots.setRevealed(row,col);
			return false;
		}
	}

	@Override
	public boolean isWin() {
		int count = 0;
        for(int row = 0 ; row < 10 ; row++)
            for(int col = 0 ; col < 10 ; col++)
                if(plots.isRevealed(row, col) == false)
                    count++;
        if(count == 10)
            return true;
        else
            return false;                
	}

}
