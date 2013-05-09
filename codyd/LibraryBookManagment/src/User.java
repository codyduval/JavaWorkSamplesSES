import java.util.*;

public class User {
	private String name;
	private Integer cardNumber;
	private Boolean isOverdue;
	private ArrayList<Item> loanedItems;
	
	public User() {
		this.name = "unknown guest";
		this.isOverdue = false;
		this.cardNumber = 99999;
		this.loanedItems = new ArrayList<Item>();
	}
	
	public User(String name, Integer cardNumber) {
		this.name = name;
		this.isOverdue = false;
		this.cardNumber = cardNumber;
		this.loanedItems = new ArrayList<Item>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Boolean getIsOverdue() {
		return isOverdue;
	}

	public void setIsOverdue(Boolean isOverdue) {
		this.isOverdue = isOverdue;
	}

	public ArrayList<Item> getLoanedItems() {
		return loanedItems;
	}

	public void setLoanedItems(ArrayList<Item> loanedItems) {
		this.loanedItems = loanedItems;
	}
	
	public void showLoanedItems() {
		ArrayList<Item> items = this.getLoanedItems();
		for (int i=0; items.size() > i; i++) {
			System.out.print(" " + items.get(i).getTitle());
		}
	}
	
	public void addLoanedItem(Item item) {
		this.loanedItems.add(item);
	}
	
	public void returnLoanedItem(Item item) {
		this.loanedItems.remove(item);
	}
	
	
}


