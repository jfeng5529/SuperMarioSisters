package jessiMimiGame;

public class MimiFrontEnd implements JessiSupporter{

	private MimiSupporter backend;
	private int moves;
	
	
	public static final void main(String[] args) {
		MimiFrontEnd demo = new MimiFrontEnd();
		demo.play();
	}
	
	private void play() {
		// TODO Auto-generated method stub
		
	}

	public MimiFrontEnd() {
		backend = new JessiBackEnd(this);
		moves = 0;
	}
	
	private void startGame() {
		JessiMimiPlot[][] plots = backend.getPlots();
		JessiMimiPlot p = null;
	
		System.out.println("___________Game Over___________\n");
	}
}
