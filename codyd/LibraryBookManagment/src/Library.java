import java.util.*;


public class Library {

	private HashMap<String, User> libraryUsers;
	private HashMap<String, Item> libraryItems;
	
	public Library() {
		this.libraryUsers = new HashMap<String, User>();
		this.libraryItems = new HashMap<String, Item>();
	}
	
	public HashMap<String, User> getLibraryUsers() {
		return libraryUsers;
	}
	
	public void setLibraryUsers(HashMap<String, User> libraryUsers) {
		this.libraryUsers = libraryUsers;
	}
	
	public HashMap<String, Item> getLibraryItems() {
		return libraryItems;
	}
	
	public HashMap<String, Item> getAvailLibraryItems() {
		return libraryItems;
	}
	
	public void setLibraryItems(HashMap<String, Item> libraryItems) {
		this.libraryItems = libraryItems;
	}
	
	public void issueItem(User user, Item item) {
		if ((item.isLoanable == true) && (item.isLoaned == false) && (user.getIsOverdue() == false)) {
		user.addLoanedItem(item);
		item.setIsLoaned(true);
		}
		else if (item.isLoaned == true) {
			System.out.print("\nSorry, that item is already checked out.");
			return;
		}
		else if (user.getIsOverdue() == true) {
			System.out.print("\nSorry, that user has overdue books.");
			return;
		}
		else if (item.getIsLoanable() == false) {
			System.out.print("\nSorry, that item is not available to be checked out.");
			return;
		}
	}
	
	
	public void returnItem(User user, Item item) {
		user.returnLoanedItem(item);
		item.isLoaned = false;
	}
	
	public void addItemToLibrary(Item item) {
		this.libraryItems.put(item.getTitle(),item);
	}
	
	public void addUserToLibrary(User user) {
		this.libraryUsers.put(user.getName(), user);
	}
	
	public Item lookupItem(String tempItemTitle) {
		Item item = libraryItems.get(tempItemTitle);
		return item;
	}
	
	public User lookupUser(String tempUser) {
		User user = libraryUsers.get(tempUser);
		return user;
	}
	
	
}
