package janeLubnaGame;

import caveExplore.CaveExplorer;
import caveExplore.CaveRoom;
import caveExplore.NPC;
import caveExplore.NPCRoom;
import caveExplore.Princess;
import jessiMimiGame.JessiMerchantRoom;
import jessiMimiGame.MimiRoom;

public class JaneGameMap extends CaveRoom {
	
	private Candy candy;
	private static NPCRoom[][] gameMap;
	
	
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
	
	public static void setUpDoors() {
		CaveRoom[][] g =gameMap;
	}
	
	public void enter() {
		super.enter();
		LubnaFrontEnd.bag.addPoints();
	}
}
