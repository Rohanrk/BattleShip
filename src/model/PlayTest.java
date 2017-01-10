package model;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class PlayTest {

	public static void main(String[] args) {
		
		initialize();
		
	}
	
	public static void initialize() {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of players! ");
		int players = input.nextInt();
		if (players == 1) {
			playSinglePlayer();
		} else if (players == 2) {
			playTwoPlayer();
		} else {
			throw new InputMismatchException("You cannot have this many "
					+ "players");
		}
		
	}
	
	public static void playSinglePlayer() {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Player 1! Choose your name! ");
		String firstName = input.next();
		Board player = new Board(firstName);
		player.setBoard();
		player.printBoard();
		AIBoard computer = new AIBoard("AIBot");
		takeTurn(player, computer);
		//TODO
		
	}
	
	public static void playTwoPlayer() {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Player 1! Choose your name! ");
		String firstName = input.nextLine().trim();
		Board player1 = new Board(firstName);
		System.out.print("Player 2! Choose your name! ");
		String secondName = input.nextLine().trim();
		Board player2 = new Board(secondName);
		player1.setBoard();
		player2.setBoard();
		takeTurn(player1, player2);
		cleanup(player1, player2);
		input.close();
	}

	public static void takeTurn(Board player1, Board player2) {

		while (!player1.isVictory() && !player2.isVictory()) {

			if (player2 instanceof AIBoard) {
				attack(player2, (AIBoard) player2);
			} else {
				attack(player1, player2);
				attack(player2, player1);
			}
		}
	}

	public static void attack(Board player, AIBoard bot) {
		
		while(!player.isVictory() && bot.isVictory()) {
			
			attack(player, (Board) bot); /* Safe casting here */
			Random rand = new Random();
			//TODO Insert Rudimentary AI code here
			System.out.printf("%s's board:\n"
					, player.getPlayerName());
			player.printBoard();
		}
	}
	
	public static void attack(Board attacker, Board attacked) {
		
		Scanner input = new Scanner(System.in);
		System.out.printf("%s! Select your coordinates of attack!\n"
				+ "NOTE: Enter your coordinates in the form of a letter "
				+ "and a number directly following!\nNote that  Example: A4\n"
				, attacker.getPlayerName());
		String coordinates = input.nextLine().trim();
		String letterRow = coordinates.substring(0, 1);
		int row = Board.parseRow(letterRow);
		int column = Integer.parseInt(coordinates.substring(1));
		attacked.HandleAttack(row, column);
		attacker.setVictory(attacked);
		System.out.printf("%s's board:\n"
				, attacked.getPlayerName());
		attacked.printHiddenBoard();
	}

	public static void cleanup(Board player1, Board player2) {
		
		if (player1.isVictory()) {
			System.out.printf("Congratulations %s!\n",
					player1.getPlayerName());
		} else {
			System.out.printf("Congratulations %s!\n",
					player1.getPlayerName());
		}
		
		System.out.println("Thanks for playing!");
	}

}
