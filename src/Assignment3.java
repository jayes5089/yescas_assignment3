/* Jason Yescas
   Object-Oriented Programming : CPSC-24500-001
   2/23/2024
   Assignment 3
   Purpose: To Rock Scissors, Scissor Paper, and Paper Rocks. */

// These are to import the scanner and random variables that are required for the game to run.
import java.util.Random;
import java.util.Scanner;

public class Assignment3 {
	// This method collects both the user and computer input
	private static void startGame() {
		// This makes the variables to scan and make random integers
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		do {
			// Takes user and computer input. Computer input is randomized from 1 to 3.
			int computerPick = rand.nextInt(3) + 1;
			int playerPick = scanPlayerPick(scan);
			
			// This displays both player and computer inputs, and sends it to pickName() method
			System.out.println("\nSHOOT!");
			System.out.println("\nPlayer Picked: "+ pickName(playerPick));
			System.out.println("Computer Picked: "+ pickName(computerPick));
			
			// This takes both inputs and sends to winningPick() method.
			winningPick(computerPick, playerPick);
			
			// When the game is over, ask the player if they want to try again.
			System.out.print("\nWant to try again?? (Y/N): ");
		}
		
		// If the player chose N, terminate the program
		while (scan.next().equalsIgnoreCase("Y"));
		System.out.println("\nSee you next time!");
	}
	// This method asks the player for their input, and sends it back to startGame() method
	private static int scanPlayerPick(Scanner scan) {
		int playerPick;
		do {
			// The choices are 1, 2, or 3. If the player chose anything that wasn't 1-3, the prompt repeats.
			System.out.print("\nPlease enter your pick (1 = Rock , 2 = Paper , 3 = Scissors): ");
			while (!scan.hasNextInt()) {
				// This is for any choice that wasn't an integer
				System.out.println("Invalid input, please pick either 1, 2, or 3.");
				scan.next();
			}
			playerPick = scan.nextInt();
		}
		// If the conditions are met, playerPick becomes the players input.
		while (playerPick < 1 || playerPick > 3);
		return playerPick;
		}
	// This method turns the player and computer input into their respective string, depending on the integer.
	private static String pickName(int pick) {
		switch (pick) {
		// 1 = Rock
		case 1:
			return "Rock";
		// 2 = Paper
		case 2:
			return "Paper";
		// 3 = Scissors
		case 3:
			return "Scissors";
		default:
			return "Invalid";
		}
	}
	// This method calculates if either the player or computer won the game.
	private static void winningPick(int computerPick, int playerPick) {
		// If both inputs are the same, the game results in a tie.
		if (computerPick == playerPick) {
			System.out.println("\nRESULT: Tie!");	
		}
		// If the computer's pick is anything that goes against the player's pick, the computer wins.
		else if ((computerPick == 1 && playerPick == 3) ||
				(computerPick == 2 && playerPick == 1) ||
				(computerPick == 3 && playerPick == 2)) {
			System.out.println("\nRESULT: Computer wins!");
		}
		// If the result isn't a tie or a computer wins, the player wins.
		else {
			System.out.println("\nRESULT: Player wins!");
		}
	}
	// This is the opening message and the beginning of the game.
	public static void main(String[] args) {
		System.out.println("Rock, Paper, Scissors...");
		// This calls to start the game.
		startGame();
	}
}
