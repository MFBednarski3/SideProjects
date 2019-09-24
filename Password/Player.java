/**
 * 
 * @author MikeBednarski
 * This is the player class which gives info on the player
 */
public class Player {
	private String name;
	private int score;
	
	public Player(String name) {
		this.name = name;
		score = 0;
	}
	
	public String getname() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void addToScore(int num) {
		score += num;
	}
	
}
