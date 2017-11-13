package janeLubnaGame;

public class LubnaFrontEnd implements JaneSupport {
	
	private LubnaSupport backend;

	public LubnaFrontEnd() {
		backend= new JaneBackEnd(this);
	}
	
	public static final void main(String[] args) {
		LubnaFrontEnd demo = new LubnaFrontEnd();
		demo.play();
	}

	private void play() {
		
		
	}
}
