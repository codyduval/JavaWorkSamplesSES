import java.util.ArrayList;


public class Player {
	private int score;
	private String name;
	private ArrayList<Tile> playerTiles = new ArrayList<Tile>();
	
	public Player(String name) {
		this.score = 0;
		this.name = name;
	}
	
	public void addTileToPlayer(Tile tile) {
		this.playerTiles.add(tile);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Tile> getPlayerTiles() {
		return playerTiles;
	}

	public void setPlayerTiles(ArrayList<Tile> playerTiles) {
		this.playerTiles = playerTiles;
	}
	
	

}
