package model;

import java.util.Random;

public class AIBoard extends Board {

	private int prevRow;
	private int prevCol;
	
	public AIBoard(String name) {
		super(name);
	}
	
	public int getPrevRow() {
		return prevRow;
	}

	public void setPrevRow(int prevRow) {
		this.prevRow = prevRow;
	}
	
	public int getPrevCol() {
		return prevCol;
	}

	public void setPrevCol(int prevCol) {
		this.prevCol = prevCol;
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
