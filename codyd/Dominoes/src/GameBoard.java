import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class GameBoard {
	
	private int gameTail;
	private int gameHead;
	
	Random randomNo = new Random();
	
	public Domino getTileFromBag(DominoBag dominoBag) {
		int numberOfDominoes = dominoBag.getDominoesInBag().size();
		int randomDominoNumber = randomNo.nextInt(numberOfDominoes);
		Domino randomDomino = dominoBag.getDominoesInBag().get(randomDominoNumber);
		randomDomino.setIsPlayed(true);
		dominoBag.getDominoesInBag().remove(randomDominoNumber);
		return randomDomino;
	}
	
	public Domino matchTile(int gameHead, int gameTail, DominoBag dominoBag) {
		HashMap<Integer,ArrayList> tempValuesTable = dominoBag.getDominoValuesTable();
		ArrayList<Domino> tempDominoHeadList = tempValuesTable.get(gameHead);
		ArrayList<Domino> tempDominoTailList = tempValuesTable.get(gameTail);
		
		for (int i=0; i < tempDominoHeadList.size(); i++) {
			Domino tempHeadDomino = tempDominoHeadList.get(i);
			if (tempHeadDomino.getIsPlayed() == false) {
				return tempHeadDomino;
			}
		}
		for (int j=0; j < tempDominoTailList.size(); j++) {
			Domino tempTailDomino = tempDominoTailList.get(j);
			if (tempTailDomino.getIsPlayed() == false) {
				return tempTailDomino;
			}
		}
		return null;
	}

	public int getGameTail() {
		return gameTail;
	}

	public void setGameTail(int gameTail) {
		this.gameTail = gameTail;
	}

	public int getGameHead() {
		return gameHead;
	}

	public void setGameHead(int gameHead) {
		this.gameHead = gameHead;
	}
	
	

}

