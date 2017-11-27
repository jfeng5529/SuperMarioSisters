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


	public JaneEnemies(JaneSupport frontend, int i) {
		this.frontend= frontend;
		this.currentCol=-1;
		this.currentRow=-1;
		this.currentRoom=null;
		result="";
		currentIndex=i;
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
		int[] moves=new int[2];
		int [][] possibleMoves = {{-1,0},{0,1},{1,0},{0, -1}};
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