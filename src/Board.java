import java.util.InputMismatchException;
import java.util.Scanner;

public class Board {

	private Status[][] board;
	private String playerName;
	private boolean victory;
	private Carrier carrier;
	private Battleship battleShip;
	private Cruiser cruiser;
	private Submarine submarine;
	private Destroyer destroyer;
	private static final int BOARD_SIZE = 10;
	
	public enum Status {
		HIT, MISS, SHIP, EMPTY
	}
	
	public Board(String name) {
		board =  new Status[BOARD_SIZE][BOARD_SIZE];
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = Status.EMPTY;
			}
		}
		playerName = name;
		carrier = new Carrier(0);
		battleShip = new Battleship(0);
		cruiser = new Cruiser(0);
		submarine = new Submarine(0);
		destroyer = new Destroyer(0);
		
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public boolean isVictory() {
		return victory;
	}
	
	public void setVictory(Board other) {
		if (other.isShipSunk(other.getCarrier()) 
				&& other.isShipSunk(other.getBattleShip()) 
				&& other.isShipSunk(other.getSubmarine()) 
				&& other.isShipSunk(other.getCruiser())
				&& other.isShipSunk(other.getDestroyer())) {
			this.victory = true;
		}
	}
	
	public Carrier getCarrier() {
		return carrier;
	}

	public Battleship getBattleShip() {
		return battleShip;
	}

	public Cruiser getCruiser() {
		return cruiser;
	}

	public Submarine getSubmarine() {
		return submarine;
	}

	public Destroyer getDestroyer() {
		return destroyer;
	}
	
	public boolean isShipSunk(Ship s) {
		if (board[s.getRootRow()][s.getRootColumn()] != Status.HIT) {
			return false;
		}
		for (int i = 0; i < s.getSize(); i++) {
			if (s.getOrientation() == 0) {
				if (board[s.getRootRow()][s.getRootColumn() + i] 
						!= Status.HIT) {
					return false;
				}

			} else if (s.getOrientation() == 1) {
				if (board[s.getRootRow() + i][s.getRootColumn()] 
						!= Status.HIT) {
					return false;
				}
				
			} else if (s.getOrientation() == 2) {
				if (board[s.getRootRow()][s.getRootColumn() - i] 
						!= Status.HIT) {
					return false;
				}
				
			} else if (s.getOrientation() == 3) {
				if (board[s.getRootRow() - i][s.getRootColumn()] 
						!= Status.HIT) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void setBoard() {
		
		//Place ships based on UI given a root position and
		//orientation
		this.setShip(carrier);
		this.setShip(battleShip);
		this.setShip(cruiser);
		this.setShip(submarine);
		this.setShip(destroyer);
	}
	
	public void setShip(Ship s) {
		
		Scanner input = new Scanner(System.in);
		System.out.printf("%s! Select the root coordinate "
				+ "you want your %s to be placed\n"
				+ "NOTE: Enter your coordinates in the form of a letter "
				+ "and a number directly following!\nNote that  Example: A4\n"
				, this.getPlayerName(), s.getShipName());
		String coordinates = input.nextLine().trim();
		String letterColumn = coordinates.substring(0, 1);
		int row = Integer.parseInt(coordinates.substring(1)) - 1;
		int column = parseColumn(letterColumn);
		System.out.println("Enter an orientation for your "
				+ s.getShipName()
				+ "\nKEY\n0 represents north to south\n"
				+ "1 represents west to east\n"
				+ "2 represents south to north\n"
				+ "3 represents east to west\n\n");
		int orientation = input.nextInt();
		s.setOrientation(orientation);
		while (!canSet(s, row, column)) {
			System.out.println("With your ships current orientation "
					+ "you cannot set your ship.\nPress 1 for new coordinates "
					+ "or press 2 to change your ships orientation\n");
			int given = input.nextInt();
			if (given == 1) {
				
				Scanner coordinate = new Scanner(System.in);
				System.out.printf("%s! Select the root coordinate "
						+ "you want your %s to be placed\n"
						+ "NOTE: Enter your coordinates in the form of a letter "
						+ "and a number directly following!\nNote that  Example: A4\n"
						, this.getPlayerName(), s.getShipName());
				coordinates = coordinate.nextLine().trim();
				letterColumn = coordinates.substring(0, 1);
				row = Integer.parseInt(coordinates.substring(1)) - 1;
				column = parseColumn(letterColumn);
				coordinate.close();
				
			} else if (given == 2) {
				
				System.out.println("Enter your desired orientation\n\n"
						+ "KEY\n0 represents north to south\n"
						+ "1 represents west to east\n"
						+ "2 represents south to north\n"
						+ "3 represents east to west\n");
				orientation = input.nextInt();
				s.setOrientation(orientation);
				
			} else {
				throw new InputMismatchException("Improper input. Input must be 1 or 2");
			}
		}
	}

	public boolean canSet(Ship s, int row, int column) {
		
		if (board[row][column] != Status.EMPTY) {
			return false;
		}
		
		if (s.getOrientation() == 0) {
			if (column + s.getSize() <= 9) {
				for (int i = 0; i < s.getSize(); i++) {
					board[row][column + i] = Status.SHIP;
				}
				return true;
			}
		} else if (s.getOrientation() == 1) {
			if (row + s.getSize() <= 9) {
				for (int i = 0; i < s.getSize(); i++) {
					board[row + i][column] = Status.SHIP;
				}
				return true;
			}
			
		} else if (s.getOrientation() == 2) {
			if (column - s.getSize() >= 0) {
				for (int i = 0; i < s.getSize(); i++) {
					board[row][column - i] = Status.SHIP;
				}
				return true;
			}
		} else if (s.getOrientation() == 3) {
			if (row - s.getSize() >= 0) {
				for (int i = 0; i < s.getSize(); i++) {
					board[row - i][column] = Status.SHIP;
				}
				return true;
			}
		}
		
		return false;
	}
	
	public void HandleAttack(int row, int column) {
		
		if (row >= BOARD_SIZE || column >= BOARD_SIZE ) {
			throw new IllegalArgumentException("row and column must be "
					+ "less than 10");
		}
		
		if (board[row][column] == Status.MISS || 
				board[row][column] == Status.HIT) {
			
			System.out.println("You've already attacked this target");
			
		}
			
		if (board[row][column] == Status.SHIP) {
			
			board[row][column] = Status.HIT;
			System.out.println("You've hit a ship!");
			
		} else if (board[row][column] == Status.EMPTY) {
			
			board[row][column] = Status.MISS;
			System.out.println("You have missed!");
		}
	
	}
	
	@Override
	public String toString() {
		
		String desired = "";
		desired += "KEY\n* = empty or ship\n# = hit\n% = miss\n\n";
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (board[i][j] == Status.EMPTY || 
						board[i][j] == Status.SHIP) {
					desired += "*";
				} else if (board[i][j] == Status.HIT) {
					desired += "#";
				} else if (board[i][j] == Status.MISS) {
					desired += "%";
				}
			}
			desired += "\n";
		}
		desired += "\n";
		return desired;
	}
	
	public static int parseColumn(String column) {

		if (column.equals("A")) {
			return 0;
		} else if (column.equals("B")) {
			return 1;
		} else if (column.equals("C")) {
			return 2;
		} else if (column.equals("D")) {
			return 3;
		} else if (column.equals("E")) {
			return 4;
		} else if (column.equals("F")) {
			return 5;
		} else if (column.equals("G")) {
			return 6;
		} else if (column.equals("H")) {
			return 7;
		} else if (column.equals("I")) {
			return 8;
		} else if (column.equals("J")) {
			return 9;
		} else {
			throw new IllegalArgumentException("This letter cannot "
					+ "define a space on the board");
		}
	}

}
