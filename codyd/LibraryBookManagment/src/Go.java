import java.util.Scanner;


public class Go {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User user = new User();
		Library library = new Library();
		
		Item timeMagazine = new ItemMagazine(5,"Time");
		Item mobyDickBook = new ItemBook("Melville", "MobyDick");
		Item outOfSightMovie = new ItemDVD ("Soderberg", "OutofSight");
		
		library.addItemToLibrary(timeMagazine);
		library.addItemToLibrary(mobyDickBook);
		library.addItemToLibrary(outOfSightMovie);
		
		User codyUser = new User("cody", 1);
		User maryUser = new User("mary", 2);
		
		library.addUserToLibrary(codyUser);
		library.addUserToLibrary(maryUser);
		
		while(true) {
			System.out.print("\nWelcome to the library");
			Scanner consoleScanner = new Scanner(System.in);
	        System.out.print("\nType 'loan', 'return', or 'list' (or 'quit' to exit): ");
	        String result = consoleScanner.next();
	        
	        if (result.equals("loan")) {
	        	System.out.print("\nHere are the items in the library: " + library.getLibraryItems().keySet());
	        	System.out.print("\nWhich item would you like to loan? ");
	        	String tempItemTitle = consoleScanner.next();
	        	Item loanedItem = library.lookupItem(tempItemTitle);
	        	System.out.print("\nHere are all the library users: " + library.getLibraryUsers().keySet());
	        	System.out.print("\nWho would you like to loan it to?");
	        	String tempUser = consoleScanner.next();
	        	User userGettingBook = library.lookupUser(tempUser);
	        	library.issueItem(userGettingBook, loanedItem);
	        }
	        else if (result.equals("return")) {
	        	System.out.print("\nHere are all the library users: " + library.getLibraryUsers().keySet());
	        	System.out.print("\nWho is returning a book?");
	        	String tempUser = consoleScanner.next();
	        	User userReturningBook = library.lookupUser(tempUser);
	        	System.out.print("\nHere are the items that user has checked out: ");
	        	userReturningBook.showLoanedItems();
	        	System.out.print("\nWhich item are they returning? ");
	        	String tempItemTitle = consoleScanner.next();
	        	Item loanedItem = library.lookupItem(tempItemTitle);
	        	library.returnItem(userReturningBook, loanedItem);

	        }
	        else if (result.equals("list")) {
	        	System.out.print("\nType 'all' for all items or 'user' for items checked out for a specific user:");
	        	String listQuery = consoleScanner.next();
	        	if (listQuery.equals("user")) {
		        	System.out.print("\nHere are all the library users: " + library.getLibraryUsers().keySet());
		        	System.out.print("\nFor whom do you want to list items?");
		        	String tempUser = consoleScanner.next();
		        	User userReturningBook = library.lookupUser(tempUser);
		        	System.out.print("\nHere are the items that user has checked out: ");
		        	userReturningBook.showLoanedItems();
		        	}
	        	else if (listQuery.equals("all")){
	        		System.out.print("\nHere are all the items in the library: " + library.getLibraryItems().keySet());
	        	}
	        }
	        else if (result.equals("quit")) {
	        	break;
	        }
		}

	}

}
