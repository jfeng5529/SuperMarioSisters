package janeLubnaGame;

import caveExplore.CaveExplorer;
import caveExplore.Inventory;
import caveExplore.NPCRoom;

public class JaneBackEnd implements LubnaSupport {
	

	private int candy;
	private JaneSupport frontend;
	private int enemiesCount;
	private JaneEnemies[] enemies;
	private int totalCandy;
	private boolean win;

	public JaneBackEnd(JaneSupport frontend) {
		enemiesCount=4;
		this.frontend=frontend;
		this.candy=0;
		this.totalCandy=40;
	}
	public void setUpPlot() {
		setUpMap();
		setUpDoors();
		frontend.setCurrentRoom(frontend.getPlots()[0][2]);
		frontend.getCurrentRoom().enter("x");
		setUpEnemies();
	}
	public void setUpEnemies() {
		enemies= new JaneEnemies[4];
		for (int i =0; i <4; i++) {
			enemies[i]=new JaneEnemies(frontend);
			//frontend.setCurrentRoom(frontend.getPlots()[i+1][i+1]);
			enemies[i].setPosition(i+1,i+1);
		}
		frontend.setEnemies(enemies);

	}

	public boolean enemiesPresent() {
		return frontend.getCurrentRoom().getPresentEnemies();

	}

	public void setUpDoors() {
		int height=4; int width=7;
		for(int row=0; row<5; row++) {
			for(int col=0; col<width; col++) {
				frontend.getPlots()[row][col].setConnection(JaneGameMap.EAST, frontend.getPlots()[row][col+1], new Object());
			}
		}
		for(int col=0; col<8; col++) {
			for(int row=0; row<height; row++) {
				frontend.getPlots()[row][col].setConnection(JaneGameMap.SOUTH, frontend.getPlots()[row+1][col], new Object());
			}
		}
	}

	public void setUpMap() {
		JaneGameMap[][] plots= new JaneGameMap[5][8]; 

		for(int row =0; row<plots.length; row++) {
			for(int col=0; col<plots[row].length; col++) {
//					if((int)(Math.random()*1)>) {
						plots[row][col]=new JaneGameMap();
						plots[row][col].setPresentCandy(true);
						plots[row][col].setContent();
//					}
//					else
//					{
//						plots[row][col]=new JaneGameMap();
//					}
						}
		}
		frontend.setPlots(plots);
	}

	public boolean stillPlaying() {
		if(!enemies[enemiesCount-1].getResult().equals("lost")&&candy!=totalCandy) {
			return true;
		}
		if(enemies[enemiesCount-1].getResult().equals("lost")) {
			setGameResult(false);
		}
		if(candy==totalCandy) {
			setGameResult(true);
		}
		return false;
	}

	public int getTotalCandy() {
		JaneGameMap[][] plots= frontend.getPlots(); 
		int candyCount=0; 
		for(int row=0; row<plots.length; row++) {
			for( int col=0; col<plots[row].length; col++) {
				if(plots[row][col].isPresentCandy()) {
					candyCount++;
				}
			}
		}
		return candyCount; 
	}

	public boolean isValid(String input) {
		return "wasde".indexOf(input)>-1&&input.length()==1;
	}

	public void respondToKey(int direction) {
		if(direction==-1) {
			frontend.printAllowedEntry();
		}
		if(direction <4) {
			JaneGameMap currentRoom = frontend.getCurrentRoom();
			if(currentRoom.getConnection(direction)!=null) {
				currentRoom.leave();
				frontend.setCurrentRoom(currentRoom.getBorderingRooms(direction));
				 currentRoom = frontend.getCurrentRoom();
				currentRoom.enter("x");
				frontend.updatePlot();
				if(currentRoom.isPresentCandy()) {
					currentRoom.setPresentCandy(false);
					candy++;
				}
				if(currentRoom.getPresentEnemies()) {
					enemies[enemiesCount-1].interaction(enemiesCount);
					enemiesCount--;
				}
				frontend.setCurrentRoom(currentRoom);//
			}
		}
		else {
			performAction(direction);
		}
	}

	private void performAction(int direction) {
//		if(frontend.getCurrentRoom().containsEnemies()) {
//			enemies[enemiesCount-1].interaction(enemiesCount);
//			enemiesCount--;
//		}
//		else {
//			CaveExplorer.print("There is nothing to interact with");
//		}

	}

	public int enemiesCount() {
		return enemiesCount;
	}

	public void enemiesAction() {
		for (int i =0; i <4; i++) {
			if(enemies[i] != null) {
			enemies[i].act();
			}
		}
	}

	public JaneSupport getFrontend() {
		return frontend;
	}
	public int getCandy() {
		return candy;
	} 
	public void setGameResult(boolean result) {
		win=result;
	}
	public boolean gameResult() {
		return win;
	}

}