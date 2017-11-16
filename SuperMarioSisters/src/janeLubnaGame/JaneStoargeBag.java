package janeLubnaGame;

import janeLubnaGame.JaneBackEnd;
import caveExplore.CaveRoom;
import caveExplore.Inventory;

public class JaneStoargeBag extends Inventory {
	private Object[][] bag;
	private String map;
	
	public JaneStoargeBag() {
		super();
		bag = new Object[2][50];
		updateMap();
	}

	public void addPoints() {
		// TODO Auto-generated method stub
		
	}
	
	public void updateMap() {
		map=" ";
		//create line across the top
		for(int i=0; i<janeLubnaGame.JaneGameMap.gameMap[0].length-1; i++) {
			map+="____";//4 underscores
		}
		map+="___\n"; // 3 underscores
		for(JaneGameMap[]row: janeLubnaGame.JaneGameMap.gameMap) {
			//3 row of text
			for(int i=0; i<3; i++) {
				String text ="";
				for(CaveRoom cr: row) {
					//if the door is open, leave open
					if(cr.getDoor(JaneGameMap.WEST)!=null&&
						 cr.getDoor(CaveRoom.WEST).isOpen()) {
						text+=" ";
					}
					else {
						text+="|";
					}
					//content of room depend on what row this is
					if(i==0) {
						text+="   "; //3 spaces
					}
					else if(i==1) {
						text+=" "+cr.getContents()+" ";
					}
					else if(i==2) {
						if(cr.getDoor(CaveRoom.SOUTH)!=null&&cr.getDoor(CaveRoom.SOUTH).isOpen()) {
							text+="   ";// 3 spaces
						}
						else {
							text+="___";// 3 underscores
						}
					}
				}
				text+="|";
				map+=text+"\n";
				
			}
		}
	}
	

}
