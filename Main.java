import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author MikeBednarski
 * @started June 20, 2019
 * First Version: September 24, 2019
 * 
 * This is a game inspired by the game show Password and its' former spinoff Million Dollar Password. 
 * In the game Password, players guess on "passwords" based on one word clues. The game is intended to
 * be a "pass-around" game where players would pass around the device to play this game. As of now,
 * I am still thinking of how this should be implemented (as a GUI or a mobile app).
 */
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Player> playersList = new ArrayList<Player>();
		Scanner input = new Scanner(System.in);
		String gameResponse;
		String players;
		String response;

		System.out.println("Welcome to Password!");
		System.out.println("Created by Mike Bednarski");
		System.out.println("Choose what game you want to do");

		do {
			System.out.println("(1) Million Dollar Password (2 or 4 Players)");
			System.out.println("(2) Classic Password (4 Players)");
			System.out.println("(3) Exit");
			gameResponse = input.nextLine();
			if (!(gameResponse.equals("1") || gameResponse.equals("2") || gameResponse.equals("3"))) {
				System.out.println("Invalid Response. Try Again");
			}
		} while (!(gameResponse.equals("1") || gameResponse.equals("2") || gameResponse.equals("3")));
		

		if (gameResponse.equals("1")) {
			do {
				System.out.print("How many players?");
				System.out.println(" 2 or 4");
				players = input.next();
				if (!(players.equals("2") || players.equals("4"))) {
					System.out.println("Invalid Response. Try Again");
				}
			} while (!(players.equals("2") || players.equals("4")));

			int numPlayers = Integer.parseInt(players);
			String playerName = "";
			for (int i = 1; i <= numPlayers; i++) {
				System.out.println("Please enter name of player " + i + ": ");
				if (i % 2 == 1 && numPlayers == 4) {
					System.out.println("(Celebrity)");
				} else if (i % 2 == 0 && numPlayers == 4) {
					System.out.println("(Contestant)");
				}
				playerName = input.next();
				playersList.add(new Player(playerName));

			}
			EliminationRound er = new EliminationRound();
			MillionDollarPassword mdp = new MillionDollarPassword();
			if (numPlayers == 2) {
				int p2;
				int winner = er.playEliminationRound2(playersList);
				if (winner == 1)
					p2 = 0;
				else
					p2 = 1;
				mdp.playMillionDollarPassword(playersList.get(winner), playersList.get(p2));
			} else {
				int winner = er.playEliminationRound4(playersList);
				do {
					System.out.println(playersList.get(winner).getname()
							+ ", who do you want to play Million Dollar Password with?");
					System.out.println("(1) " + playersList.get(0).getname() + " (2) " + playersList.get(2).getname());
					response = input.nextLine();
				} while (!(response.equals("1") || response.equals("2")));
				int playerNumber = Integer.parseInt(response);
				if (playerNumber == 1)
					playerNumber = 0;
				mdp.playMillionDollarPassword(playersList.get(winner), playersList.get(playerNumber));
			}


		} else if (gameResponse.equals("2")) {
			String playerName = "";
			for (int i = 1; i <= 4; i++) {
				System.out.println("Please enter name of player " + i + ": ");
				playerName = input.next();
				playersList.add(new Player(playerName));
			}
			ClassicPassword cp = new ClassicPassword();
			cp.playClassicPassword(playersList);
			
		}
		else {
			input.close();
			System.exit(0);
		}
		
		
		System.out.println("Thanks for playing!");
		System.out.println("Press Enter to exit");
		input.nextLine();
		input.close();
		System.exit(0);


	}

}
