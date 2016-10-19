
public class Carrier extends Ship {
	
	private static final int CARRIER_SIZE = 5;
	private static final String SHIP_NAME = "Carrier";
	
	public Carrier() {
		super(CARRIER_SIZE);
	}
	
	@Override
	public String getShipName() {
		return SHIP_NAME;
	}

}
