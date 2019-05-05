

public class Player {
	
	int playerNumber;
	int playerScore;

	public Player(int playerNumber) {
		super();
		this.playerNumber = playerNumber;
		this.playerScore = playerScore;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(int score) {
		this.playerScore = playerScore + score;
	}
	
	

}
