
public class Destroyer extends Ship {

	private static final int DESTROYER_SIZE = 2;
	private static final String SHIP_NAME = "Destroyer";
	
	public Destroyer(int o) {
		super(DESTROYER_SIZE, o);
	}
	
	@Override
	public String getShipName() {
		return SHIP_NAME;
	}

}
