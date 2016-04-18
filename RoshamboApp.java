/**
 * Main app for Lab. 12
 */
package com;

import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Priti
 *
 */
public class RoshamboApp implements Comparator{
 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int winCount=0,loseCount =0;
		Player newPlayer = null;
		Scanner scan = new Scanner(System.in);
		RoshamboApp myApp = new RoshamboApp();
		//Prompt for user input
		System.out.println("Welcome to Rock Paper Scissors!");
		System.out.println("Enter your name: ");
		String userName = scan.nextLine();
		
		System.out.println("Choose an opponent (1. Player1 or 2. Player2): ");
		int opponent = getValidIntegerInRange(1, 2,scan);
		
		if(opponent == 1){//Create Player1
			newPlayer = new RockPlayer();		
		}else if(opponent == 2){//Create Player2
			newPlayer = new RandomPlayer();
		}
		//Continue playing loop
		String playAgain = null; 
		do {
			//Generate new players Roshambo
			Roshambo newPLayerChoice = newPlayer.generateRoshambo();
			Player humanPlayer = new HumanPlayer();
			//Prompt for user choice
			System.out.println("1. Rock, 2. Paper, or 3. Scissors?");
			int choice = getValidIntegerInRange(1, 3,scan)- 1;
			System.out.println(userName + ":" + Roshambo.values()[choice]);
			if (opponent == 1) {//Create Player1			
				System.out.println("Player1" + ":" + newPLayerChoice);
			} else if (opponent == 2) {//Create Player2
				System.out.println("Player2" + ":" + newPLayerChoice);
			}
			//Calculate winner
			if (myApp.compare(Roshambo.values()[choice], newPLayerChoice) == 0) {//rock
				System.out.println("Draw");
			} else if (myApp.compare(Roshambo.values()[choice], newPLayerChoice) > 0) {
				System.out.println("You Win!");
				winCount++;
			} else {
				System.out.println("You lose!");
				loseCount++;
			}
			System.out.println("Play again? (y/n):");
			scan.nextLine();//consume new line
			playAgain = scan.nextLine();
		} while (playAgain.matches("[yY]$"));
		{
			System.out.println("# of Wins:" + winCount + "\n# of Losses "+ loseCount);
		System.out.println("Goodbye");
		}
	}

	// This method checks that the user inputted a valid integer. 
		public static int getValidInteger(Scanner input) {
			while(!input.hasNextInt()) {
				System.out.println("That's not a number! Please enter a number: ");
				input.nextLine();
			}
			int number = input.nextInt();
			return number;
		}

		//This method checks that the user inputted a valid number in the range specified.
		public static int getValidIntegerInRange (int min, int max, Scanner input) {
			//min = 1;
			//max = 3;
			int number = getValidInteger(input);
			while(number > max || number < min) {
				System.out.println("Please enter a number between " + min + " and " + max);
			number = getValidInteger(input);
			}
			return number;
		}

	@Override
	public int compare(Object arg0, Object arg1) {
		if((Roshambo)arg0 == Roshambo.Scissors && (Roshambo)arg1 == Roshambo.Paper){
			return 1;
		}else if((Roshambo)arg1 == Roshambo.Paper && (Roshambo)arg0 == Roshambo.Scissors){
			return -1;
		}
		else if((Roshambo)arg0 == Roshambo.Rock && (Roshambo)arg1 == Roshambo.Scissors){
			return 1;
		}else if((Roshambo)arg0 == Roshambo.Scissors && (Roshambo)arg1 == Roshambo.Rock ){
			return -1;
		}
		return ((Roshambo)arg0).compareTo((Roshambo)arg1);		
	}
}
