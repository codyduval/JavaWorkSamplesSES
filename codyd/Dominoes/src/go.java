
public class go {

	public static int numberOfDominoes = 24;
	
	public static void main(String[] args) {
		
		DominoBag dominoBag = new DominoBag();
		dominoBag.makeDominoes(numberOfDominoes);
		GameBoard gameBoard = new GameBoard();
		
		Domino firstDomino = gameBoard.getTileFromBag(dominoBag);
		System.out.print("\nFirst domino has a top value of " + firstDomino.getTopValue() + " and a bottom value of " + firstDomino.getBottomValue());
		gameBoard.setGameHead(firstDomino.getTopValue());
		gameBoard.setGameTail(firstDomino.getBottomValue());
		firstDomino.setIsPlayed(true);
		
		while(true) {
			System.out.print("\nHead value: " + gameBoard.getGameHead() + " || Tail value: " + gameBoard.getGameTail());
			if ((gameBoard.matchTile(gameBoard.getGameHead(), gameBoard.getGameTail(), dominoBag)) == null) {
				System.out.print("\nThat's the end, no more dominoes to play");
				break;
			}
			Domino matchedDomino = gameBoard.matchTile(gameBoard.getGameHead(), gameBoard.getGameTail(), dominoBag);
			System.out.print("\nI found a matching domino with a top value of " + matchedDomino.getTopValue() + " and a bottom value of " + matchedDomino.getBottomValue());
			if (matchedDomino.getTopValue() == gameBoard.getGameHead()) {
				gameBoard.setGameHead(matchedDomino.getBottomValue());
			}
			else if (matchedDomino.getBottomValue() == gameBoard.getGameHead()) {
				gameBoard.setGameHead(matchedDomino.getTopValue());
			}
			else if (matchedDomino.getTopValue() == gameBoard.getGameTail()) {
				gameBoard.setGameTail(matchedDomino.getBottomValue());
			}
			else if (matchedDomino.getBottomValue() == gameBoard.getGameTail()) {
				gameBoard.setGameTail(matchedDomino.getTopValue());
			}
			matchedDomino.setIsPlayed(true);
		}
	}
}
