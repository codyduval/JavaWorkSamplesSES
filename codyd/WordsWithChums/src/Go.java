import java.util.ArrayList;
import java.util.HashMap;

public class Go {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int boardSize = 15;
		final String player1Name = "Cody";
		final String player2Name = "Ryan";
		final ArrayList<Tile> gameBag;

		Player player1 = new Player(player1Name);
		Player player2 = new Player(player2Name);
		View view = new View();
		Board board = new Board(boardSize);
		GameRules gameRules = new GameRules();
		
		gameBag = gameRules.buildTileBag();
		gameRules.shuffleTileBag(gameBag);
		gameRules.dealInitialTiles(gameBag, player1);
		gameRules.dealInitialTiles(gameBag, player2);
		
		view.drawBoard(board);
		view.drawPlayerInfo(player1);
		view.drawPlayerInfo(player2);
		
		while (true) {
			HashMap<Character,String> letterPlacement = view.getPlayerLetterPlacement(player1);
			Boolean validMove = gameRules.isValidLetterPlacement(letterPlacement, player1, board);
			if (validMove == false) {
				System.out.println("Sorry, that's not a valid move. Try again.");		
			}
			else {
				gameRules.putTileOnBoard(player1, board, letterPlacement);
				view.drawBoard(board);
				view.drawPlayerInfo(player1);
				view.drawPlayerInfo(player2);
			}
		}
		
	}
	
	public static void setUpGame() {
		
	}

}
