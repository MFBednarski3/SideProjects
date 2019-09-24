import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author MikeBednarski
 * This is the Classic Password game class. This plays the regular password game where players
 * guess "passwords" based on 1 word clues. This also contains the Elimination Round tiebraker.
 */

public class ClassicPassword {
	private ArrayList<String> passwordsList;
	private Scanner input;

	public ClassicPassword() {
		input = new Scanner(System.in);
	}

	void setWordsUp() throws FileNotFoundException {
		passwordsList = new ArrayList<String>();
		Scanner words = new Scanner(new File("CPShortList.txt"));
		while (words.hasNextLine()) {
			passwordsList.add(words.nextLine());
		}
		words.close();
	}
	
	private String getWord() {
		String word = passwordsList.get(RandomSpot());
		passwordsList.remove(word);
		return word;
	}
	
	private int RandomSpot() {
		Random rand = new Random();
		return rand.nextInt(passwordsList.size());
	}
	
	void playClassicPassword(ArrayList<Player> players) throws FileNotFoundException {
		int team1Start = 0;
		int team2Start = 2;
		int turn = 0;
		int rresponse = Integer.MAX_VALUE;
		
		setWordsUp();
		do {
			System.out.println("How many rounds do you want to play for? ");
			System.out.println("Up to " + passwordsList.size());
			rresponse = input.nextInt();
			if (rresponse < 0) continue;
		} while(rresponse > passwordsList.size());
		
		System.out.println("Team 1: " + players.get(0).getname() +  " and " + players.get(1).getname());
		System.out.println("Team 2: " + players.get(2).getname() +  " and " + players.get(3).getname());
		
		for (int i = 0; i < rresponse; i++) {
			System.out.println("Round " + (i + 1));
			System.out.println("Givers for this round: " + players.get(team1Start).getname() +  " and " + players.get(team2Start).getname());
			if (i % 2 == 0) {
				System.out.println("Starting this round: Team 1");
				turn = team1Start;
			}
			else {
				System.out.println("Starting this round: Team 2");
				turn = team2Start;
			}
			

			String word = getWord();
			String response = "";
			System.out.println("10 seconds to answer");
			System.out.println("Press Enter to start");
			input.nextLine();
			System.out.println("-------------");
			
			
			for (int j = 0; j < 10; j++) {
				System.out.println("Points up for grab: " + (10 - j));
				System.out.println("Current Giver: " + players.get(turn).getname());
				System.out.println(word.toUpperCase());
				System.out.println("(1) Correct; (2) Pass/Time's Up/Wrong/Non-Crit Illegal Clue; (3) Critical Illegal Clue");
				response = input.nextLine();
				if (response.equals("1")) {
					addToScore(players, turn, j);
					break;
				} else if (response.equals("2")) {
					turn = switchTeam(turn);
					System.out.println("Pass to " + players.get(turn).getname());
					System.out.println("Press Enter to continue");
					input.nextLine();
				} else if (response.equals("3")) {
					turn = switchTeam(turn);
					addToScore(players, turn, j);
					break;
				} else {
					System.out.println("Invalid Response");
				}
				System.out.println("------------");
			}
			
			
			System.out.println("Scores so far");
			System.out.println("Team 1: " + players.get(0).getScore());
			System.out.println("Team 2: " + players.get(2).getScore());
			System.out.println("Press Enter to continue");
			input.nextLine();
			System.out.println("-------------");
			if (team1Start == 0) {
				team1Start = 1;
				team2Start = 3;
			} else {
				team1Start = 0;
				team2Start = 2;
			}
			
		}
		if (players.get(0).getScore() == players.get(2).getScore()) {
			System.out.println("We finish with a tie!");
		} else if (players.get(0).getScore() > players.get(2).getScore()) {
			System.out.println("Team 1 wins!");
		} else {
			System.out.println("Team 2 wins!");
		}
		
	}
	
	private void addToScore(ArrayList<Player> players, int turn, int j) {
		if (turn == 0 || turn == 1) {
			players.get(0).addToScore(10 - j);
			players.get(1).addToScore(10 - j);
		} else {
			players.get(2).addToScore(10 - j);
			players.get(3).addToScore(10 - j);
		}
	}
	
	

	int tieBreaker(String word, ArrayList<Player> players, int player) {
		String response = "";
		System.out.println("10 seconds to answer");
		System.out.println("Press Enter to start");
		input.nextLine();
		System.out.println("-------------");
		int turn = player;
		while (true) {
			System.out.println("Current Giver: " + players.get(turn).getname());
			System.out.println(word.toUpperCase());
			System.out.println("(1) Correct; (2) Pass/Time's Up/Wrong/Non-Crit Illegal Clue; (3) Critical Illegal Clue");
			response = input.nextLine();
			if (response.equals("1")) {
				return turn;
			} else if (response.equals("2")) {
				turn = turn > 2 ? 1 : 3;
				System.out.println("Pass to " + players.get(turn).getname());
				System.out.println("Press Enter to continue");
				input.nextLine();
			} else if (response.equals("3")) {
				return turn > 2 ? 1 : 3;
			} else {
				System.out.println("Invalid Response");
			}
			System.out.println("------------");
		}
	}
	
	private int switchTeam(int turn) {
		if (turn == 0) turn = 2;
		else if (turn == 1) turn = 3;
		else if (turn == 2) turn = 0;
		else turn = 1;
		return turn;
	}

}
