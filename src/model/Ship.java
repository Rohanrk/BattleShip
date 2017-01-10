package model;

import java.util.InputMismatchException;

public abstract class Ship {

	/* Size is self explanatory. Represents number of units
	 * Orientation is taken as an int between 0-3. 
	 * 0 represents north to south
	 * 1 represents west to east 
	 * 2 represents south to north
	 * 3 represents east to west
	 */
	private int size;
	private int orientation;
	private int rootRow;
	private int rootColumn;
	
	public Ship(int s) {
		size = s;
	}
	
	public int getSize() {
		return size;
	}

	public int getOrientation() {
		return orientation;
	}
	
	public void setOrientation(int given) {
		if (given >= 0 && given <= 3) {
			orientation = given;
		} else {
			throw new InputMismatchException("Orientation "
					+ "must be between 0 and 3");
		}
	}
	
	public int getRootRow() {
		return rootRow;
	}
	
	public void setRootRow(int row) {
		rootRow = row;
	}
	
	public int getRootColumn() {
		return rootColumn;
	}
	
	public void setRootColumn(int column) {
		rootColumn = column;
	}
	
	public abstract String getShipName();
	
}
