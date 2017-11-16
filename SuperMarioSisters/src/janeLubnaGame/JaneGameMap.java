package janeLubnaGame;

import caveExplore.CaveExplorer;
import caveExplore.CaveRoom;
import caveExplore.Door;
import caveExplore.NPC;
import caveExplore.NPCRoom;
import caveExplore.Princess;
import jessiMimiGame.JessiMerchantRoom;
import jessiMimiGame.MimiRoom;

public class JaneGameMap extends CaveRoom {
	public static final int NORTH=0;
	public static final int EAST=1;
	public static final int SOUTH=2;
	public static final int WEST=3;
	private Candy candy;
	public static CaveRoom[][] gameMap;
	private String description; // tells what the room looks like
	private String direction;//tells what you can do
	private String contents;//a symbol representing what's in the room
	private String defaultContents;
	//the rooms are organize by direction, "null" signifies no room/door in that direction
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	
	public JaneGameMap(String description) {
		super(description);
		candy= new Candy();
		gameMap =new NPCRoom[6][10];
	}
	
	public static void setUpCaves() {
		for(int row =0; row<gameMap.length; row++) {
			for(int col=0; col<gameMap[row].length; col++) {
				gameMap[row][col]=new NPCRoom("Room");
			}
		}
		
		JaneBackEnd.enemies[0].setPosition(5, 9);
		JaneBackEnd.enemies[1].setPosition(1, 3);
		JaneBackEnd.enemies[2].setPosition(2, 4);
		LubnaFrontEnd.currentRoom=gameMap[0][1];
		LubnaFrontEnd.currentRoom.enter();
		setUpDoors();
		
		
	}
	
	private void setDirections() {
		direction="";
		boolean doorFound=false;
		for(int i=0; i<doors.length; i++) {
			if(doors[i]!=null) {
				doorFound=true;
				direction+="\n  There is a "+doors[i].getDescription()+" to "+
				toDirection(i)+ "." +doors[i].getDetails();
			}
		}
		if(!doorFound) {
			direction+="There are no doors, you are trapped in here";
		}
		
	}
	
	
	public static void setUpDoors() {
		CaveRoom[][] g =gameMap;
	}
	
	public void enter() {
		super.enter();
		LubnaFrontEnd.bag.addPoints();
	}
}
