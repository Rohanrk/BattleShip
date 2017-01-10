package model;

public class Cruiser extends Ship {
	
	private static final int CRUISER_SIZE = 3;
	private static final String SHIP_NAME = "model.Cruiser";
	
	public Cruiser() {
		super(CRUISER_SIZE);
	}
	
	@Override
	public String getShipName() {
		return SHIP_NAME;
	}

}
