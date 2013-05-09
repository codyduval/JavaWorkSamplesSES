import java.util.Random;

public class Domino {
	
	Random randomNo = new Random();
	
	private int topValue;
	private int bottomValue;
	private Boolean isPlayed;
	
	Domino() {
		this.topValue = randomNo.nextInt(6)+1;
		this.bottomValue = randomNo.nextInt(6)+1;
		this.isPlayed = false;
	}
	
	public int getTopValue() {
		return topValue;
	}
	public void setTopValue(int topValue) {
		this.topValue = topValue;
	}
	
	public int getBottomValue() {
		return bottomValue;
	}
	public void setBottomValue(int bottomValue) {
		this.bottomValue = bottomValue;
	}
	
	public Boolean getIsPlayed() {
		return isPlayed;
	}
	public void setIsPlayed(Boolean isPlayed) {
		this.isPlayed = isPlayed;
	}
}
