import java.util.ArrayList;


public class Board {
	private ArrayList<Character> gameBoard;
	private int boardSize;
	
	public Board(int boardSize) {
		this.boardSize = boardSize;
		int totalBoardSize = boardSize*boardSize;
		this.gameBoard = new ArrayList<Character>();
		for (int i=0;i<totalBoardSize;i++){
			this.gameBoard.add(i,'.');
		}
	}
	
	public ArrayList<Character> getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(ArrayList<Character> gameBoard) {
		this.gameBoard = gameBoard;
	}
	
	public int getBoardSize() {
		return boardSize;
	}
	
	
	
}
