package caveExplore;

public class TwoDArrayPractice {

	
	public static void main(String[] args) {
		String[][] pic=new String[6][10];
		for(int row=0; row< pic.length; row++) {
			for(int col=0; col<pic[row].length; col++) {
				pic[row][col]=" ";
				
			}
		}
		drawHorizontalLine(pic, 1);
		drawHorizontalLine(pic, 3);
		drawHorizontalLine(pic, 5);
		drawBox(pic, 4, 5);
		print(pic);
	}
	
	/**
	 * __
	 * |*|
	 * |_|
	 * @param pic
	 * @param i
	 * @param j
	 */
	private static void drawBox(String[][] pic, int i, int j) {
			drawSlot(pic, i, j);
			drawSlot(pic, i+1, j);
			drawIfInBound("_", pic, i+1, j);
			for(int col=j-1; col<=j+1; col++) {
				drawIfInBound("_", pic, i-1, col);
			}
		
	}

	private static void drawIfInBound(String string, String[][] pic, int i, int j) {
		//SPECIAL NOTES: always check row before col
		if(i>=0&&i<pic.length&&j>=0&&j<pic[i].length) {
			pic[i][j]=string;
		}
		
	}

	/**
	 * A slot looks like this :
	 * it is two vertical lines with a space between them
	 * The coordinates, i, j. are the coordinate of space
	 * In other words, a slot is a vertical line in front of i, j and after i, j
	 * CATCH: No ArrayIndexOutOfBoundException
	 * @param pic
	 * @param i
	 * @param j
	 */
	private static void drawSlot(String[][] pic, int i, int j) {
		if(i>=0&&i<pic.length) {
		if(j>0) {
			pic[i][j-1]="|";
		}
		if(j<pic[i].length-1) {
			pic[i][j+1]="|";
		}
		
	}
	}


	private static void drawVerticalLine(String[][] pic, int col) {
		for(int row=0; row<pic.length; row++) {
			pic[row][col]="|";
		}
		
	}


	private static void drawHorizontalLine(String[][] pic, int row) {
		for(int col=0; col<pic[row].length; col++) {
			pic[row][col]="-";
		}
		
	}

	/**
	 * prints contents of pic, row by row
	 * NO BRACKETS OR COMMAS
	 * @param pic
	 */
	private static void print(String[][] pic) {
		String result="";
		for(int row=0; row< pic.length; row++) {
			for(int col=0; col<pic[row].length; col++) {
				result+=pic[row][col];
			}
			result+="\n";
		}
		System.out.println(result);
	}

}
