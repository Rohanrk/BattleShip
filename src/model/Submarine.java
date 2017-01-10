package model;

public class Submarine extends Ship {

	private static final int SUBMARINE_SIZE = 3;
	private static final String SHIP_NAME = "model.Submarine";
	
	public Submarine() {
		super(SUBMARINE_SIZE);
	}
	
	@Override
	public String getShipName() {
		return SHIP_NAME;
	}

}

