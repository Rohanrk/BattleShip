import java.util.Random;

public class AIBoard extends Board {

	public AIBoard(String name) {
		super(name);
	}
	
	@Override	
	public void setShip(Ship s) {
		
		Random rand = new Random();
		int row = rand.nextInt(10);
		int column = rand.nextInt(10);
		s.setOrientation(rand.nextInt(4));
		while(!canSet(s, row, column)) {
			row = rand.nextInt(10);
			column = rand.nextInt(10);
			s.setOrientation(rand.nextInt(4));
		}
	}
}
