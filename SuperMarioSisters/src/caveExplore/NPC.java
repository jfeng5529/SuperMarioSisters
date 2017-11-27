package caveExplore;

public class NPC {
	public boolean isActive;

	/**
	 * NPC means Non player	
	 */
	private CaveRoom[][] floor;
	private int currentRow;
	private int currentCol;
	private NPCRoom currentRoom;

	private boolean active;
	private String activeDescription;
	private String inactiveDescription;

	public NPC(String inactiveDescription) {
		this.floor=CaveExplorer.caves;
		this.inactiveDescription=inactiveDescription;
		this.activeDescription="There is a person waiting to talk to you.";
		//to indicate that the NPC doesn't have a position yet, use coordinates -1, -1
		this.currentCol=-1;
		this.currentRow=-1;
		this.currentRoom=null;
		this.active=true;

	}
	/**
	 * NOTE: you can make custom constructors later that use different parameters
	 * for ex
	 * public NPC(String description, String inactiveDescriptions)
	 */
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean b) {
		active=b;
	}
	public void setPosition(int row, int col) {
		if(row>= 0&& row<floor.length&& col>=0 &&
				col <floor[row].length && floor[row][col] instanceof NPCRoom) {
			//remove the npc from the current room
			if(currentRoom!=null) {
				currentRoom.leaveNPC();
			}
			currentRow =row;
			currentCol = col;
			currentRoom=(NPCRoom)floor[row][col];
			currentRoom.enterNPC(this);
		}
	}
	public void interact() {
		CaveExplorer.print("Hi! I'm an NPC. I say nothing until you say bye.");
		String s = CaveExplorer.in.nextLine();
		while(!s.equalsIgnoreCase("bye")) {
			CaveExplorer.print("...");
			s=CaveExplorer.in.nextLine();
		}
		CaveExplorer.print("Well, that was fun. Later!");
		active =false;

	}

	public String getInactiveDescription() {
		return inactiveDescription;
	}
	public String getActiveDescription() {
		return activeDescription;
	}
	public void act() {
		if(active) {
			int[] move = calculateMovement();
			int newRow=  move[0];
			int newCol = move[1];
			setPosition(newRow, newCol);
		}

	}
	public int[] calculateMovement() {
		int[] moves=new int[2];
		int [][] possibleMoves = {{-1,0},{0,1},{1,0},{0, -1}};
		int rand=(int)(Math.random()*possibleMoves.length);
		moves[0]=possibleMoves[rand][0]+currentRow;
		moves[1]=possibleMoves[rand][1]+currentCol;
		while(currentRoom.getDoor(rand)==null||!(CaveExplorer.caves[moves[0]][moves[1]] instanceof NPCRoom)||(moves[0]==5&&moves[1]==9)) {
			rand=(int)(Math.random()*possibleMoves.length);
			moves[0]=possibleMoves[rand][0]+currentRow;
			moves[1]=possibleMoves[rand][1]+currentCol;
		}
		return moves;
	}
	public String getSymbol() {
		return "M";
	}
	public NPCRoom currentNPCRoom() {
		return currentRoom;
	}
	public String getInteractDescription() {
		return "HI TALK TO ME";
	}

}