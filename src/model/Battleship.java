package model;

public class Battleship extends Ship {
	
	private static final int BATTLESHIP_SIZE = 4;
	private static final String SHIP_NAME = "model.Battleship";
	
	public Battleship() {
		super(BATTLESHIP_SIZE);
	}
	
	@Override
	public String getShipName() {
		return SHIP_NAME;
	}
	
	

}
