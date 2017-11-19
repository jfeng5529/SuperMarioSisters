package janeLubnaGame;

import caveExplore.Inventory;

public class JaneEnemies  {
	private int currentRow;
	private int currentCol;
	private JaneGameMap currentRoom;
	private Inventory inventory;
	private static String result;
	
	public JaneEnemies() {
		currentRoom=null;
		this.currentCol=-1;
		this.currentRow=-1;
		result="";
	}
	public String getSymbol() {
		return "E";
	}
	public void setPosition(int row, int col) {
		JaneGameMap[][] map=LubnaFrontEnd.plot;
		
		if(row>= 0&& row <map.length && col>=0 && col <map[row].length) {
		if(currentRoom!=null) {
		currentRoom.leaveNPC();
		}else {
			currentRow =row;
			currentCol = col;
			currentRoom=(JaneGameMap)map[row][col];
			currentRoom.enterNPC(this);
	}
		}
	}
	public void interaction() {
		if(inventory.getFlashLight()>0) {
			if(JaneBackEnd.enemiesCount()-1>=0) {
				LubnaFrontEnd.enemies[JaneBackEnd.enemiesCount()-1]=null;
			}
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
	public static String getResult() {
		return result;
	}
}
