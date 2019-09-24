import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author MikeBednarski
 * This is the elimination round where players guess on 5 passwords with the ability to come back to them
 * if unsure.
 */
public class EliminationRound {
	ArrayList<String> passwords;
	ArrayList<String> fiveWords;
	Scanner input;
	int counter;

	public EliminationRound() {
		input = new Scanner(System.in);
		counter = 0;

	}

	void setWordsUp() throws FileNotFoundException {
		passwords = new ArrayList<String>();
		Scanner words = new Scanner(new File("ElimTerms.txt"));
		while (words.hasNextLine()) {
			passwords.add(words.nextLine());
		}
		words.close();
	}

	private void setFiveWords() {
		fiveWords = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			int randomWord = RandomSpot();
			fiveWords.add(passwords.get(randomWord));
			passwords.remove(randomWord);
		}
	}

	private int RandomSpot() {
		Random rand = new Random();
		return rand.nextInt(passwords.size());
	}

	private void printCurrentScores(int p1, int p2, ArrayList<Player> playersList) {
		System.out
				.println("Current Score for " + playersList.get(p1).getname() + ": " + playersList.get(p1).getScore());
		System.out
				.println("Current Score for " + playersList.get(p2).getname() + ": " + playersList.get(p2).getScore());
	}

	void roundSetUp() {
		System.out.println("Set clock for 30 seconds");
		System.out.println("Press Enter to start");
		input.nextLine();
		System.out.println("-------------");
		setFiveWords();
	}

	private int roundPlay(ArrayList<Player> playersList, int turn) {
		String response;
		int roundScore = 0;
		counter = 0;
		while (!fiveWords.isEmpty()) {
			if (counter == fiveWords.size())
				counter = 0;
			System.out.println("Current Correct: " + roundScore);
			System.out.println("Words Left: " + fiveWords.size());
			System.out.println(fiveWords.get(counter).toUpperCase());
			System.out.println("(1) Correct; (2) Pass; (3) Illegal Clue; (4) Time's Up");
			response = input.nextLine();
			if (response.equals("1")) { // Correct Word
				fiveWords.remove(counter);
				playersList.get(turn).addToScore(1);
				roundScore++;
			} else if (response.equals("2")) { // Pass
				counter++;
			} else if (response.equals("3")) { // Illegal Clue
				fiveWords.remove(counter);
			} else if (response.equals("4")) { // Time's Up
				break;
			} else {
				System.out.println("Invalid Response");
			}
			System.out.println("----------");
		}
		return roundScore;
	}

	int playClassicPassword(ArrayList<Player> players, int player) {
		String word = passwords.get(RandomSpot());
		passwords.remove(word);
		ClassicPassword tb = new ClassicPassword();
		return tb.tieBreaker(word, players, player);

	}

	int playEliminationRound2(ArrayList<Player> playersList) throws FileNotFoundException {
		String response = "";
		int giving = 0;
		int receiving = 1;
		setWordsUp();
		for (int i = 0; i < 4; i++) {
			System.out.println("Giving the Clues: " + playersList.get(giving).getname());
			System.out.println("Receiving the Clues: " + playersList.get(receiving).getname());
			roundSetUp();

			int roundScore = roundPlay(playersList, receiving);

			System.out.println("Score this round: " + roundScore);
			printCurrentScores(0, 1, playersList);
			if (giving == 0) {
				giving = 1;
				receiving = 0;
			} else {
				giving = 0;
				receiving = 1;
			}
			System.out.println("Press Enter to continue");
			input.nextLine();
			System.out.println("-------------");
		}

		if (playersList.get(0).getScore() == playersList.get(1).getScore()) {
			System.out.println("We have a tie!");
			System.out.println("Do Rock-Paper-Scissors or something to determine a winner");

			do {
				System.out.println("Who won?");
				System.out.println("(1) " + playersList.get(0).getname() + " (2) " + playersList.get(1).getname());
				response = input.nextLine();
				if (response.equals("1")) {
					playersList.get(0).addToScore(1);
				} else if (response.equals("2")) {
					playersList.get(1).addToScore(2);
				} else {
					System.out.println("Invalid response");
				}
			}
			while (!(response.equals("1") || response.equals("2")));

		}

		if (playersList.get(0).getScore() > playersList.get(1).getScore()) {
			System.out.println(playersList.get(0).getname() + " wins!");
			return 0;
		} else {
			System.out.println(playersList.get(1).getname() + " wins!");
			return 1;
		}

	}

	int playEliminationRound4(ArrayList<Player> playersList) throws FileNotFoundException {
		String response = "";
		int giving1 = 0;
		int receiving1 = 1;
		int giving2 = 2;
		int receiving2 = 3;
		int roundScore;
		setWordsUp();

		for (int i = 0; i < 4; i++) {
			System.out.println("Round " + (i + 1));

			for (int j = 0; j < 2; j++) {
				if (j == 0) {
					System.out.println("Giving the Clues: " + playersList.get(giving1).getname());
					System.out.println("Receiving the Clues: " + playersList.get(receiving1).getname());
					roundSetUp();
					roundScore = roundPlay(playersList, 1);
				} else {
					System.out.println("Giving the Clues: " + playersList.get(giving2).getname());
					System.out.println("Receiving the Clues: " + playersList.get(receiving2).getname());
					roundSetUp();
					roundScore = roundPlay(playersList, 3);

				}

				System.out.println("Score this round: " + roundScore);
				printCurrentScores(1, 3, playersList);
				System.out.println("Press Enter to continue");
				input.nextLine();
				System.out.println("-------------");
			}

			if (i == 0) {
				giving1 = 1;
				receiving1 = 0;
				giving2 = 3;
				receiving2 = 2;
			} else if (i == 1) {
				giving1 = 2;
				receiving1 = 1;
				giving2 = 0;
				receiving2 = 3;
				System.out.println(playersList.get(0).getname() + " and " + playersList.get(2).getname() + ". Please switch sites");
			} else if (i == 2) {
				if (playersList.get(1).getScore() <= playersList.get(3).getScore()) {
					giving1 = 1;
					receiving1 = 2;
					giving2 = 3;
					receiving2 = 0;
				} else {
					giving1 = 3;
					receiving1 = 0;
					giving2 = 1;
					receiving2 = 2;
				}

			}

		}
		if (playersList.get(1).getScore() == playersList.get(3).getScore()) {
			int winner = -1;
			System.out.println("We have a tie!");
			System.out.println("To break the tie, we will do classic password");
			
			do {
				System.out.println("Who would like to give the first clue?");
				System.out.println("(1) " + playersList.get(1).getname() + " (2) " + playersList.get(3).getname());
				response = input.nextLine();
				if (response.equals("1")) {
					winner = playClassicPassword(playersList, 1);
				} else if (response.equals("2")) {
					winner = playClassicPassword(playersList, 3);
				} else {
					System.out.println("Invalid Response");
				}
			}
			while (!(response.equals("1") || response.equals("2")));
			
			
			playersList.get(winner).addToScore(1);

		}

		if (playersList.get(1).getScore() > playersList.get(3).getScore()) {
			System.out.println(playersList.get(1).getname() + " wins!");
			return 1;
		} else {
			System.out.println(playersList.get(3).getname() + " wins!");
			return 3;

		}

	}

}
