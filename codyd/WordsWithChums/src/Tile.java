
public class Tile {
	private Character letter;
	private Integer pointValue;
	private Boolean isPlayed;
	
	public Tile(Character letter, Integer pointValue) {
		this.letter = letter;
		this.pointValue = pointValue;
		this.isPlayed = false;
	}

	public Character getLetter() {
		return letter;
	}

	public void setLetter(Character letter) {
		this.letter = letter;
	}

	public Integer getPointValue() {
		return pointValue;
	}

	public void setPointValue(Integer pointValue) {
		this.pointValue = pointValue;
	}

	public Boolean getIsPlayed() {
		return isPlayed;
	}

	public void setIsPlayed(Boolean isPlayed) {
		this.isPlayed = isPlayed;
	}
	
	
	
	

}
