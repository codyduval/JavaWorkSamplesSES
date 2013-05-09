import java.util.*;


public class GameRules {
	
	public ArrayList<Tile> tileStack = new ArrayList<Tile>();
	public ArrayList<Tile> tempTilesForMove = new ArrayList<Tile>();
	public ArrayList<Integer> thisTurnMoves = new ArrayList<Integer>();
	public ArrayList<Integer> validTurnMoves = new ArrayList<Integer>(){
		{
			for (int i=0; i < 225; i++){
				this.add(i);
			}
		}
	};
	public ArrayList<Integer> validGameMoves = new ArrayList<Integer>(){
		{
			for (int i=0; i < 225; i++){
				this.add(i);
			}
		}
	};
	
	private HashMap<Character, Integer> pointValues = new HashMap(){  
	    {  
	    	this.put('A', 1);
			this.put('B', 3);
			this.put('C', 3);
			this.put('D', 2);
			this.put('E', 1);
			this.put('F', 4);
			this.put('G', 2);
			this.put('H', 4);
			this.put('I', 1);
			this.put('J', 8);
			this.put('K', 5);
			this.put('L', 1);
			this.put('M', 3);
			this.put('N', 1);
			this.put('O', 1);
			this.put('P', 3);
			this.put('Q', 10);
			this.put('R', 1);
			this.put('S', 1);
			this.put('T', 1);
			this.put('U', 1);
			this.put('V', 4);
			this.put('W', 4);
			this.put('X', 8);
			this.put('Y', 2);
			this.put('Z', 8);
			this.put('-', 0); 
	     }  
	 };
	 

	private HashMap<Character,Integer> tileDistribution = new HashMap() {
		{
			this.put('A', 9);
			this.put('B', 2);
			this.put('C', 2);
			this.put('D', 4);
			this.put('E', 12);
			this.put('F', 2);
			this.put('G', 3);
			this.put('H', 2);
			this.put('I', 9);
			this.put('J', 1);
			this.put('K', 1);
			this.put('L', 4);
			this.put('M', 2);
			this.put('N', 6);
			this.put('O', 8);
			this.put('P', 2);
			this.put('Q', 1);
			this.put('R', 6);
			this.put('S', 4);
			this.put('T', 6);
			this.put('U', 4);
			this.put('V', 2);
			this.put('W', 2);
			this.put('X', 1);
			this.put('Y', 2);
			this.put('Z', 1);
			this.put('-', 2);
		}
	};

	public ArrayList<Tile> buildTileBag() {
		char letterIndex = 'A';
		for (int i=0; i < 26; i++){
			int numTiles = tileDistribution.get(letterIndex);
			for (int j=0; j < numTiles; j++ ) {
				Tile tile = new Tile(letterIndex, pointValues.get(letterIndex));
				tileStack.add(tile);
			}
			letterIndex++;
		}
		Tile tile_special1 = new Tile('-', pointValues.get(letterIndex));
		tileStack.add(tile_special1);
		Tile tile_special2 = new Tile('-', pointValues.get(letterIndex));
		tileStack.add(tile_special2);
		return tileStack;
	}
	
	public void shuffleTileBag(ArrayList<Tile> tileBag) {
		Collections.shuffle(tileBag);
	}
	
	public void dealInitialTiles(ArrayList<Tile> gameBag, Player player) {
		for (int i = 0; i < 7; i++) {
			Tile tile = gameBag.remove(i);
			player.addTileToPlayer(tile);
		}
	}
	
	public Integer convertCoordinateToInteger(String coordinate) {
		int yAxisInteger = new Integer(0);
		int xAxisInteger = new Integer(0);
		String yAxisString = coordinate.substring(0,1);
		String xAxisString = coordinate.substring(1,3);
		xAxisInteger = Integer.parseInt(xAxisString);
		if (yAxisString.equals("A")) {
			yAxisInteger = 0;
		}
		if (yAxisString.equals("B")) {
			yAxisInteger = 15;
		}
		if (yAxisString.equals("C")) {
			yAxisInteger = 30;
		}
		if (yAxisString.equals("D")) {
			yAxisInteger = 45;
		}
		if (yAxisString.equals("E")) {
			yAxisInteger = 60;
		}
		if (yAxisString.equals("F")) {
			yAxisInteger = 75;
		}
		if (yAxisString.equals("G")) {
			yAxisInteger = 90;
		}
		if (yAxisString.equals("H")) {
			yAxisInteger = 105;
		}
		if (yAxisString.equals("I")) {
			yAxisInteger = 120;
		}
		if (yAxisString.equals("J")) {
			yAxisInteger = 135;
		}
		if (yAxisString.equals("K")) {
			yAxisInteger = 150;
		}
		if (yAxisString.equals("L")) {
			yAxisInteger = 165;
		}
		if (yAxisString.equals("M")) {
			yAxisInteger = 180;
		}
		if (yAxisString.equals("N")) {
			yAxisInteger = 195;
		}
		if (yAxisString.equals("O")) {
			yAxisInteger = 210;
		}

		Integer coordinateAsInt = (yAxisInteger + xAxisInteger);
		return coordinateAsInt;
	}
	
	public Boolean isValidLetterPlacement(HashMap<Character, String> playerLetterPlacement,Player player, Board board) {
		Character letter = playerLetterPlacement.keySet().iterator().next();
		String location = playerLetterPlacement.get(letter);
		ArrayList<Tile> playerTiles = player.getPlayerTiles();
		ArrayList<Character> gameBoard = board.getGameBoard();
		Boolean isValid = new Boolean(false);
		Integer integerLocation = convertCoordinateToInteger(location);
		
		for (int i=0; i < playerTiles.size(); i++) {
			Tile tile = playerTiles.get(i);
			if (tile.getLetter().equals(letter)) {
				isValid = true;
			}
		}
		
		if (gameBoard.get(convertCoordinateToInteger(location)) != '.') {
			isValid = false;
			return isValid;
		}
		
		if (validTurnMoves.contains(convertCoordinateToInteger(location)) != true) {
			isValid = false;
			return isValid;
		}
		
		return isValid;
		
	}
	
	public void putTileOnBoard(Player player, Board board, HashMap<Character,String> playerLetterPlacement) {
		Character letter = playerLetterPlacement.keySet().iterator().next();
		String location = playerLetterPlacement.get(letter);
		ArrayList<Tile> playerTiles = player.getPlayerTiles();
		Integer integerLocation = convertCoordinateToInteger(location);
		
		for (int i=0; i < playerTiles.size(); i++) {
			Tile tile = playerTiles.get(i);
			if (tile.getLetter().equals(letter)) {
				tempTilesForMove.add(tile);
				playerTiles.remove(tile);
				player.setPlayerTiles(playerTiles);
				ArrayList<Character> gameBoard = board.getGameBoard();
				gameBoard.set(convertCoordinateToInteger(location), letter);
				board.setGameBoard(gameBoard);
				break;
			}
		}
		if (playerTiles.size() == 6) {
			validTurnMoves.clear();
		}
		validTurnMoves.add(((integerLocation)+1));
		validTurnMoves.add(((integerLocation)-1));
		validTurnMoves.add(((integerLocation)+15));
		validTurnMoves.add(((integerLocation)-15));
		thisTurnMoves.add(integerLocation);
	}
	
	public void checkWord(){
		
	}
	
	public void resetTurn(){
		
	}
	
	public void playWord(){
		
	}
	
	
}

