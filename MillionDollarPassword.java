import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author MikeBednarski
 * This is the main game of Million Dollar password. Unlike the elimination round,
 * you can only have 3 clues and have to get a certain amount right to move on.
 */

public class MillionDollarPassword {
	ArrayList<String> passwordsList;
	ArrayList<String> passwordsRound;
	int values[];
	int safetyValues[];
	int currentSafetyValue;
	NumberFormat formatter;
	Scanner input;
	int wordBank;

	MillionDollarPassword() {
		input = new Scanner(System.in);
		passwordsList = new ArrayList<String>();
		passwordsRound = new ArrayList<String>();
		currentSafetyValue = 0;
		wordBank = 10;

	}

	void playMillionDollarPassword(Player main, Player second) throws FileNotFoundException {
		String response = "";
		do {
			System.out.println(main.getname() + ", do you want to give or receieve the clues?");
			System.out.println("(1) Give clues (2) Receieve Clues");
			response = input.nextLine();
		} while (!(response.equals("1") || response.equals("2")));
		if (response.equals("2")) {
			System.out.println("Please give this to " + second.getname());
			System.out.println("Press Enter to continue");
			input.nextLine();
			System.out.println("-------------");
		}
		setDollarValues();
		setWordsUp(1);
		setRoundPasswords();

		for (int i = 1; i < 7; i++) {
			System.out.println("Playing for " + formatter.format(values[i - 1]));
			System.out.println("Set the timer for 90 seconds");
			System.out.println("Press Enter to start");
			input.nextLine();
			System.out.println("-------------");
			
			if (!roundPlay()) {
				System.out.println("You lose");
				System.out.println("Take home: " + formatter.format(currentSafetyValue));
				break;
			} else {
				System.out.println("You have won " + formatter.format(values[i - 1]));
				if (i == 6) break;
				wordBank--;
				if (isSafetyLevel(values[i - 1])) currentSafetyValue = values[i - 1];
				System.out.println("Next up is " + formatter.format(values[i]));
				System.out.println("Guarantee Sum: " + formatter.format(currentSafetyValue));
				System.out.println("You need to get 5 out of " + wordBank + " correct");
				setWordsUp(i + 1);
				setRoundPasswords();
				if (i == 4) {
					showFirstPasswords();
				}
				do {
					System.out.println("Do you want to keep going or leave?");
					System.out.println("(1) Keep playing; (2) Leave");
					response = input.nextLine();
				} while (!(response.equals("1") || response.equals("2")));
				if (response.equals("2")) {
					System.out.println("Final Winnings : " + formatter.format(values[i]));
					break;
				}
				
			}
		}
	}

	private boolean roundPlay() {
		String response;
		int score = 0;

		while (score != 5 && passwordsRound.size() + score >= 5) {
			System.out.println("Current Score: " + score);
			System.out.println("Words Remaining in Round: " + passwordsRound.size());
			System.out.println(passwordsRound.get(0).toUpperCase());
			System.out.println("(1) Correct; (2) Pass/Illegal Clue/Out of Clues; (3) Time's Up");
			response = input.nextLine();
			if (response.equals("1")) {
				score++;
				if (score == 5) return true;
				passwordsRound.remove(0);
			} else if (response.equals("2")) {
				passwordsRound.remove(0);
			} else if (response.equals("3")) {
				return false;
			} else {
				System.out.println("Illegal response");
			}
		}
		return false;
	}

	private void setDollarValues() {
		formatter = NumberFormat.getCurrencyInstance(Locale.US);
		formatter.setMaximumFractionDigits(0);
		values = new int[] { 10000, 25000, 50000, 100000, 250000, 1000000 };
		safetyValues = new int[] { 25000, 250000 };

	}

	private boolean isSafetyLevel(int number) {
		for (int i : safetyValues) {
			if (number == i) {
				return true;
			}
		}
		return false;
	}

	private void setWordsUp(int round) throws FileNotFoundException {
		if (round == 6) return;
		passwordsList.clear();
		Scanner words;
		switch (round) {
		case 1:
			words = new Scanner(new File("Round1.txt"));
			break;
		case 2:
			words = new Scanner(new File("Round2.txt"));
			break;
		case 3:
			words = new Scanner(new File("Round3.txt"));
			break;
		case 4:
			words = new Scanner(new File("Round4.txt"));
			break;
		case 5:
			words = new Scanner(new File("Round5.txt"));
			break;
		default:
			return; // Should NEVER reach here
		}
		while (words.hasNextLine()) {
			passwordsList.add(words.nextLine());
		}
		words.close();
	}
	
	private void setRoundPasswords() {
		passwordsRound.clear();
		for (int i = 0; i < wordBank; i++) {
			int randomWord = RandomSpot();
			passwordsRound.add(passwordsList.get(randomWord));
			passwordsList.remove(randomWord);
		}
		
	}
	
	private int RandomSpot() {
		Random rand = new Random();
		return rand.nextInt(passwordsList.size());
	}

	
	/*
	 * In the original game show, before playing for $250,000, the giver can see the first words that
	 * will be used in the round before they can make a decision. 
	 */
	private void showFirstPasswords() {
		String response;
		do {
			System.out.println("Do you want to see the " + passwordsRound.size() + " words before making a decision?");
			System.out.println("Y or N?");
			response = input.nextLine();
		} while (!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N"));
		if (response.equals("Y")) {
			System.out.println("Please DO NOT say anything!!!");
			for (int i = 0; i < passwordsRound.size(); i++) {
				System.out.println(passwordsRound.get(i).toUpperCase());
			}
		}
		System.out.println("---------");
	}

}
