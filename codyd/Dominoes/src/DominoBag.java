import java.util.HashMap;
import java.util.ArrayList;

public class DominoBag {
	
	private ArrayList<Domino> dominoesInBag;
	private HashMap<Integer,ArrayList> dominoValuesTable;
	private ArrayList<Domino> similarDominoes;
	
	DominoBag() {
		this.dominoValuesTable = new HashMap<Integer,ArrayList>();
		this.dominoesInBag = new ArrayList<Domino>();
	}
	
	public void addToDominoValuesTable(Domino domino) {
		int topVal = domino.getTopValue();
		int bottomVal = domino.getBottomValue();
		if (dominoValuesTable.get(topVal) == null) {
			ArrayList<Domino> similarDominoes = new ArrayList<Domino>();
			dominoValuesTable.put(topVal,similarDominoes);
		}
		dominoValuesTable.get(topVal).add(domino);
		if (dominoValuesTable.get(bottomVal) == null) {
			ArrayList<Domino> similarDominoes = new ArrayList<Domino>();
			dominoValuesTable.put(bottomVal,similarDominoes);
		}
		dominoValuesTable.get(bottomVal).add(domino);
	}
	
	
	public void makeDominoes(int numberOfDominoes) {
		for (int i=0; i <= numberOfDominoes; i++) {
			Domino domino = new Domino();
			this.dominoesInBag.add(domino);
			this.addToDominoValuesTable(domino);
		}
	}

	public HashMap<Integer, ArrayList> getDominoValuesTable() {
		return dominoValuesTable;
	}

	public void setDominoValuesTable(HashMap<Integer, ArrayList> dominoValuesTable) {
		this.dominoValuesTable = dominoValuesTable;
	}

	public ArrayList<Domino> getDominoesInBag() {
		return dominoesInBag;
	}

	public void setDominoesInBag(ArrayList<Domino> dominoesInBag) {
		this.dominoesInBag = dominoesInBag;
	}
	
	
	
	

}
