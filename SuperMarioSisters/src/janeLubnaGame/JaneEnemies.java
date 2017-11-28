package janeLubnaGame;

import caveExplore.CaveExplorer;

public class JaneEnemies  {
	private int currentRow;
	private int currentCol;
	private JaneGameMap currentRoom;
	private JaneSupport frontend;
	private String result;
	private JaneEnemies[] enemies;
	private int currentIndex;
	private int[][] moveChoice;


	public JaneEnemies(JaneSupport frontend, int i) {
		this.frontend= frontend;
		moveChoice = new int[4][2];
		populate();
		this.currentCol=-1;
		this.currentRow=-1;
		this.currentRoom=null;
		result="";
		currentIndex=i;
	}
	public void populate() {
		for(int k=0; k<moveChoice.length;k++) {
			for(int j=0; j<moveChoice[k].length; j++) {
				moveChoice[k][j]=-5;
			}
		}
		
	}
	public String getSymbol() {
		return "E";
	}
	public void setPosition(int row, int col) {
		JaneGameMap[][] plot=frontend.getPlots();
		if(row>= 0&& row <plot.length && col>=0 && col <plot[row].length) {
			if(currentRoom!=null) {
				currentRoom.leaveNPC();
			}
				currentRow =row;
				currentCol = col;
				currentRoom=(JaneGameMap)plot[row][col];
				currentRoom.enterNPC(this);
		}
		frontend.setPlots(plot);
	}
	public boolean interaction() {
		enemies= frontend.getEnemies();
		if(CaveExplorer.inventory.getFlashLight()>0) {
				enemies[currentIndex]=null;
				frontend.getCurrentRoom().leaveNPC();
				CaveExplorer.inventory.decreaseFlashLight();
				CaveExplorer.print("Yay! You defeated one Enemy by using a flashlight!. Now you have "+CaveExplorer.inventory.getFlashLight()+" flashlights left. Be careful!");
				frontend.setEnemies(enemies);
				return true;
			}
		else {
			return false;
		}
	}
	public void act() {
		int[] move = calculateMovement();
		int newRow=  move[0];
		int newCol = move[1];
		setPosition(newRow, newCol);

	}
	public int[] calculateMovement() {
		populate();
		int [][] possibleMoves = {{-1,0},{0,1},{1,0},{0, -1}};
		int index=getAllMoves(possibleMoves);
		int[] moves=new int[2];
		//two enemies will only choose the best movement that move them closer to the player to make the game harder
		if(currentIndex%2==0) {
		moves=getBestMoves(index);
		return moves;
		}
		//the other two will move randomly, so the player will have a chance of wining
		else {
			moves=randomMove(possibleMoves);
			return moves;
		}
	}
	
	
	public int[] randomMove(int[][] possibleMoves) {
		int[] moves=new int[2];
		int rand=(int)(Math.random()*possibleMoves.length);
		moves[0]=possibleMoves[rand][0]+currentRow;
		moves[1]=possibleMoves[rand][1]+currentCol;
		while(currentRoom.getConnection(rand)==null||!frontend.getPlots()[moves[0]][moves[1]].canEnter()) {
			rand=(int)(Math.random()*possibleMoves.length);
			moves[0]=possibleMoves[rand][0]+currentRow;
			moves[1]=possibleMoves[rand][1]+currentCol;
		}
		return moves;
	}
	public int[] getBestMoves(int length) {
		int distance=0;
		int temp=0;
		int index=0;
		int[] moves = new int[2];
		for(int i=0; i<length; i++) {
			if(i==0)
				distance=getDistance(moveChoice[i]);
			else {
				temp=getDistance(moveChoice[i]);
				if(temp<distance) {
					distance=temp;
					index=i;
				}
			}		
		}
		if(temp<distance) {
			distance=temp;
			index=moveChoice.length-1;
		}
		moves[0]=moveChoice[index][0];
		moves[1]=moveChoice[index][1];
		return moves;
		
	}
	public int getDistance(int[] move) {
		return Math.abs(move[0]-frontend.getCurrentPlot()[0])+Math.abs(move[1]-frontend.getCurrentPlot()[1]);
	}
	public int getAllMoves(int[][] possibleMoves) {
		int[] moves=new int[2];
		int currentIndex=0;
		for(int i =0; i<possibleMoves.length; i++) {
			moves[0]=possibleMoves[i][0]+currentRow;
			moves[1]=possibleMoves[i][1]+currentCol;
			if(goodChoiceMove(i, moves)) {
				moveChoice[currentIndex][0]=moves[0];
				moveChoice[currentIndex][1]=moves[1];
				currentIndex++;
				}
			}
		return currentIndex;
	}

	public boolean goodChoiceMove(int rand, int[] moves) {
		if(currentRoom.getConnection(rand)==null||!frontend.getPlots()[moves[0]][moves[1]].canEnter()) {
			return false;
		}
		else
			return true;
	}
	
	public int getCurrentRow() {
		return currentRow;
	}
	public int getCurrentCol() {
		return currentCol;
	}
	public String getResult() {
		return result;//
	}
}