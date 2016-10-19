
public class Submarine extends Ship {

	private static final int SUBMARINE_SIZE = 3;
	private static final String SHIP_NAME = "Submarine";
	
	public Submarine(int o) {
		super(SUBMARINE_SIZE, o);
	}
	
	@Override
	public String getShipName() {
		return SHIP_NAME;
	}

}

