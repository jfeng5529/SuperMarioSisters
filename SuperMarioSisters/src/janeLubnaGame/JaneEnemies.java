package janeLubnaGame;

import caveExplore.Inventory;

public class JaneEnemies  {
	private int currentRow;
	private int currentCol;
	private JaneSupport frontend;
	private Inventory inventory;
	private String result;
	private JaneEnemies[] enemies;


	public JaneEnemies(JaneSupport frontend) {
		this.frontend= frontend;
		this.currentCol=-1;
		this.currentRow=-1;
		result="";
	}
	public String getSymbol() {
		return "E";
	}
	public void setPosition(int row, int col) {
		JaneGameMap[][] plot=frontend.getPlots();
		JaneGameMap currentRoom = frontend.getCurrentRoom();
		if(row>= 0&& row <plot.length && col>=0 && col <plot[row].length) {
			if(currentRoom!=null) {
				currentRoom.leaveNPC();
			}else {
				currentRow =row;
				currentCol = col;
				currentRoom.enterNPC(this);
			}
		}
	}
	public void interaction(int enemiesCount) {
		enemies= new JaneEnemies[4];
		if(inventory.getFlashLight()>0) {
			if(enemiesCount-1>=0) {
				enemies[enemiesCount-1]=null;
			}
			inventory.decreaseFlashLight();
		}
		else {
			result="lost";
		}

	}
	public void act() {
		int[] move = calculateMovement();
		int newRow=  move[0];
		int newCol = move[1];
		setPosition(newRow, newCol);

	}
	public int[] calculateMovement() {
		JaneGameMap currentRoom = frontend.getCurrentRoom();
		int[] moves=new int[2];
		int [][] possibleMoves = {{-1,0},{0,1},{1,0},{0, -1}};
		int rand=(int)(Math.random()*possibleMoves.length);
		moves[0]=possibleMoves[rand][0]+currentRow;
		moves[1]=possibleMoves[rand][1]+currentCol;
		while(currentRoom.getConnection(rand)==null) {
			rand=(int)(Math.random()*possibleMoves.length);
			moves[0]=possibleMoves[rand][0]+currentRow;
			moves[1]=possibleMoves[rand][1]+currentCol;
		}
		return moves;
	}
	public String getResult() {
		return result;
	}
}