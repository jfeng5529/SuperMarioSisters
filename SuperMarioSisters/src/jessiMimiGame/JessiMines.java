package jessiMimiGame;

public class JessiMines {
	private boolean isRevealed;
	private boolean isMine;

	
	public JessiMines() {
		isRevealed = false;
		isMine = false;
	}
	
	public void setisMine(boolean aMine)
	{
		isMine = aMine;
	}
	
	public boolean getIsMine()
	{
		return isMine;
	}
	
	public void setIsRevealed(boolean revealed) {
		isRevealed = revealed;
	}
	
	public boolean getIsRevealed()
	{
		return isRevealed;
	}
}