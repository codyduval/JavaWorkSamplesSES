import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;



public class View {

	
	

	public void drawBoard(Board board) {
		char rowLabel = 'A';
		ArrayList<Character> gameBoard = board.getGameBoard();
		System.out.print("      ");
		for (int h=0; h < board.getBoardSize(); h++) {
			if (h < 10) {
				System.out.print(" ");
			}
			System.out.print(h + "  ");
		}
		System.out.println();
		for (int i = 0; i < board.getBoardSize() ; i++) {
			System.out.print(rowLabel + " -> ");
			rowLabel++;
			for (int j = 0; j < board.getBoardSize(); j++) {
				int boardIndex = (j + (i*board.getBoardSize()));
				System.out.print("  " + gameBoard.get(boardIndex) + " ");
			}
			System.out.println();
		}
	}
	
	public void drawPlayerInfo(Player player) {
		System.out.print("\n"+ player.getName());
		System.out.print("'s Tiles: ");
		ArrayList<Tile> tiles = player.getPlayerTiles();
		for (int i=0; i < tiles.size(); i++) {
			Tile tile = tiles.get(i);
			System.out.print(tile.getLetter() + " ");
		}
		System.out.print(" *** Score: "+ player.getScore());
		
	}
	
	public HashMap<Character,String> getPlayerLetterPlacement(Player player) {
		Scanner consoleScanner = new Scanner(System.in);
		System.out.print("\n"+ player.getName());
		System.out.print("'s Move. Enter letter of tile to place (or 'done' when finished): ");
        Character letterToMove = consoleScanner.next().charAt(0);
        System.out.print("Enter coordinate to place letter (eg 'L13'): ");
        String letterPosition = consoleScanner.next();
        HashMap<Character,String> playerLetterPlacement = new HashMap<Character,String>();
        playerLetterPlacement.put(letterToMove,letterPosition);
        return playerLetterPlacement;
	}
	
	
}
