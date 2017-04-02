package model;

public enum Ship {

	CARRIER5("Carrier", 5), BATTLESHIP("Battleship", 4),
	CRUISER("Cruiser", 3), SUBMARINE("Submarine", 3),
	DESTROYER("Destroyer", 2);

	private String name;
	private int size;
	private Direction orientation;
	private int rootRow;
	private int rootCol;

	public Ship(String name, int size) {
		this.name = name;
		this.size = size;
	}
	
	public Ship(String name, int size, Direction direction) {
		this(name, size);
		orientation = direction;
	}

	public Ship(String name, int size, Direction direction, int rootRow, int rootCol) {
		this(name, size, direction);
		this.rootRow = rootRow;
		this.rootCol = rootCol;
	}
	
	public int getSize() {
		return size;
	}

	public Direction getOrientation() {
		return orientation;
	}
	
	public void setOrientation(Direction orientation) {
		this.orientation = orientation;
	}

	public int getRootRow() {
		return rootRow;
	}
	
	public void setRootRow(int row) {
		rootRow = row;
	}
	
	public int getRootColumn() {
		return rootCol;
	}
	
	public void setRootColumn(int column) {
		rootCol = column;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
