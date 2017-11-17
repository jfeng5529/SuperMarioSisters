package janeLubnaGame;

import caveExplore.NPC;

public class JaneEnemies extends NPC {
	private JaneGameMap[][] floor;
	private int currentRow;
	private int currentCol;
	private JaneCandyRoom currentRoom;

	private boolean active;
	private String activeDescription;
	private String inactiveDescription;
	
	public JaneEnemies() {
		super();
		this.floor=JaneBackEnd.getFrontend().plot;
	}
	public String getSymbol() {
		return "E";
	}
	public void setPosition(int row, int col) {
		if(row>= 0&& row<floor.length&& col>=0 &&
				col <floor[row].length && floor[row][col] instanceof JaneCandyRoom) {
			//remove the npc from the current room
			if(currentRoom!=null) {
				currentRoom.leaveNPC();
			}
			currentRow =row;
			currentCol = col;
			currentRoom=(JaneCandyRoom)floor[row][col];
			currentRoom.enterNPC(this);
		}
	}
}
