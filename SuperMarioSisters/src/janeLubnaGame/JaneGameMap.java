package janeLubnaGame;

public class JaneGameMap{
	public static final int NORTH=0;
	public static final int EAST=1;
	public static final int SOUTH=2;
	public static final int WEST=3;
	
	private boolean presentCandy;
	private String direction;//tells what you can do
	private String contents;//a symbol representing what's in the room
	private String defaultContents;
	//the rooms are organize by direction, "null" signifies no room/door in that direction
	private JaneGameMap[] borderingRooms;
	private Object[] door;
	private JaneEnemies presentEnemies;
	private String description;
	private String defaultDescription;
	
	
	public JaneGameMap() {
		borderingRooms = new JaneGameMap[4];
		presentCandy=false;
		door= new Object[4];
		setDefaultContents(" ");
		contents=defaultContents;
		presentEnemies=null;
		defaultDescription = "The Enemies are coming, hurry!";
		
	}
	
	public void setContent() {
		if(presentCandy) {
			contents = "*";
		}
		else 
		{
			contents=defaultContents;
		}
	}
	
	public String getContents() {
		return contents;
	}


	public void enter(String contents) {
		this.contents = contents;
	}
	
	public void leave() {
		this.contents=" ";
	}
	
	public boolean containEnemies() {
		return presentEnemies != null;
	}

	public boolean isPresentCandy() {
		return presentCandy;
	}
	
	public void setPresentCandy(boolean presentCandy) {
		this.presentCandy = presentCandy;
	}
	
	public void addRoom(int direction, Object door2, JaneGameMap map) {
		borderingRooms[direction]=map;
		door[direction]=door2;
	}
	public void setConnection(int direction, JaneGameMap map, Object door){
		addRoom(direction, door, map);
		map.addRoom(oppsiteDirection(direction), door, this);
		
}

	private int oppsiteDirection(int direction) {
		return (direction+2)%4;
	}

	public Object getConnection(int direction) {
		return door[direction];
	}

	public JaneGameMap getBorderingRooms(int direction) {
		return borderingRooms[direction];
	}

	public void enterNPC(JaneEnemies e) {
		presentEnemies=e;
		contents="E";
		
	}

	public void leaveNPC() {
		presentEnemies=null;
		if(!contents.equals("x")) {
		if(!presentCandy) {
			contents=defaultContents;
		}
		else {
		contents="*";
		}
	}
	}		
	public String getDescription() {
		if(containEnemies()) 
			description="Oh no! You got caught by Boo! Press 'e' to interact";
		else
			description=defaultDescription;
		return description;
	}

	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}
	
	public boolean canEnter() {
		return !containEnemies();
	}

	public JaneEnemies getPresentEnemies() {
		return presentEnemies;
	}

	public void setPresentEnemies(JaneEnemies presentEnemies) {
		this.presentEnemies = presentEnemies;
	}

	
}
