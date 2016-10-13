import java.util.Scanner;

public class PlayTest {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Player 1! Choose your name! ");
		String firstName = input.next();
		Board player1 = new Board(firstName);
		System.out.print("Player 2! Choose your name! ");
		String secondName = input.next();
		Board player2 = new Board(secondName);
		player1.setBoard();
		player2.setBoard();
		play(player1, player2);
		input.close();
		
	}

	public static void play(Board player1, Board player2) {

		while (!player1.isVictory() && !player2.isVictory()) {
			
			attack(player1, player2);
			attack(player2, player1);
			
		}
	}
	
	public static void attack(Board attacker, Board attacked) {
		
		Scanner input = new Scanner(System.in);
		System.out.printf("%s! Select your coordinates of attack!\n"
				+ "NOTE: Enter your coordinates in the form of a letter "
				+ "and a number directly following!\nNote that  Example: A4\n"
				, attacker.getPlayerName());
		String coordinates = input.nextLine().trim();
		String letterColumn = coordinates.substring(0, 1);
		int row = Integer.parseInt(coordinates.substring(1));
		int column = Board.parseColumn(letterColumn);
		attacked.HandleAttack(row, column);
		attacker.setVictory(attacked);
		System.out.printf("%s's board:\n%s"
				, attacked.getPlayerName(), attacked);
	}


}
