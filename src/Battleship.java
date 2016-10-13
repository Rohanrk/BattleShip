
public class Battleship extends Ship {
	
	private static final int BATTLESHIP_SIZE = 5;
	private static final String SHIP_NAME = "Battleship";
	
	public Battleship(int o) {
		super(BATTLESHIP_SIZE, o);
	}
	
	@Override
	public String getShipName() {
		return SHIP_NAME;
	}
	
	

}
