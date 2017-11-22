package jessiMimiGame;

	import java.util.Random;
	import java.util.Scanner;

	public class MimiBFrontEnd {
	    private int[][] mines;
	    private char[][] plots;
	    private int row, column;
	    Random random = new Random();
	    Scanner input = new Scanner(System.in);
	    
	    public MimiBFrontEnd (){
	        mines = new int[10][10];
	        plot = new char[10][10];
	        startMines();
	        randomMines();
	        fillTips();
	        startBoard();
	        
	    }
	    
	    public boolean win(){
	        int count=0;
	        for(int row = 1 ; row < 9 ; row++)
	            for(int column = 1 ; column < 9 ; column++)
	                if(plots[row][column]=='_')
	                    count++;
	        if(count == 10)
	            return true;
	        else
	            return false;                
	    }
	    
	    public int getPosition(int row, int column){
	        return mines[row][column];
	    }
	    
	    public boolean setPosition(){
	            
	            do{
	                System.out.print("\nLine: "); 
	                Line = input.nextInt();
	                System.out.print("Column: "); 
	                Column = input.nextInt();
	                
	                if( (boardgame[Line][Column] != '_') && ((Line < 9 && Line > 0) && (Column < 9 && Column > 0)))
	                    System.out.println("Field already shown");
	                
	                if( Line < 1 || Line > 8 || Column < 1 || Column > 8)
	                    System.out.println("Choose a number between 1 and 8");
	                
	            }while((Line < 1 || Line > 8 || Column < 1 || Column > 8) || (boardgame[Line][Column] != '_') );
	            
	            if(getPosition(Line, Column)== -1)
	                return true;
	            else
	                return false;
	            
	    }
	    
	    public void show(){
	        System.out.println("\n     Lines");
	        for(int Line = 8 ; Line > 0 ; Line--){
	            System.out.print("       "+Line + " ");
	            
	            for(int Column = 1 ; Column < 9 ; Column++){
	                    System.out.print("   "+ boardgame[Line][Column]);
	            }
	                
	            System.out.println();
	        }
	            
	        System.out.println("\n            1   2   3   4   5   6   7   8");
	        System.out.println("                      Columns");
	        
	    }
	    
	    public void fillTips(){
	        for(int line=1 ; line < 9 ; line++)
	            for(int column=1 ; column < 9 ; column++){
	                
	                    for(int i=-1 ; i<=1 ; i++)
	                        for(int j=-1 ; j<=1 ; j++)
	                            if(mines[line][column] != -1)
	                                if(mines[line+i][column+j] == -1)
	                                    mines[line][column]++;
	                
	            }
	            
	    }
	    
	    public void showMines(){
	        for(int i=1 ; i < 9; i++)
	            for(int j=1 ; j < 9 ; j++)
	                if(mines[i][j] == -1)
	                    boardgame[i][j]='*';
	        
	        show();
	    }
	    
	    public void startBoard(){
	        for(int i=1 ; i<mines.length ; i++)
	            for(int j=1 ; j<mines.length ; j++)
	                boardgame[i][j]= '_';
	    }
	    
	    public void startMines(){
	        for(int i=0 ; i<mines.length ; i++)
	            for(int j=0 ; j<mines.length ; j++)
	                mines[i][j]=0;
	    }
	    
	    public void randomMines(){
	        boolean raffled;
	        int Line, Column;
	        for(int i=0 ; i<10 ; i++){
	            
	            do{
	                Line = random.nextInt(8) + 1;
	                Column = random.nextInt(8) + 1;
	                
	                if(mines[Line][Column] == -1)
	                    raffled=true;
	                else
	                    raffled = false;
	            }while(raffled);
	            
	            mines[Line][Column] = -1;
	        }
	    }
	}
}
