import java.util.Scanner;


public class Application {

	

	public static void main(String[] args) {
		
		Restaurant restaurant = new Restaurant();
		ReservationBook reservationBook = new ReservationBook();
		while(true) {
			System.out.print("\nWelcome to " + restaurant.getRestaurantName());
			Scanner consoleScanner = new Scanner(System.in);
	        System.out.print("\nType 'add', 'list', or 'lookup' (or 'quit' to exit): ");
	        String result = consoleScanner.next();
        
	        if (result.equals("add")) {
	        	System.out.print("\nEnter '1' for walk-in, '2' for phone, or '3' for internet: ");
	        	int reservationType = consoleScanner.nextInt();
	        	System.out.print("\nLast Name? ");
	        	String tempName = consoleScanner.next();
	        	System.out.print("\nReservation Hour? ");
	        	int tempTime = consoleScanner.nextInt();
	        	System.out.print("\nNumber of people? ");
	        	int tempSize = consoleScanner.nextInt();
	        	if (reservationType == 1){
		        	Reservation reservation = new Reservation(tempName, tempSize, tempTime);
		        	insertReservation(reservation, reservationBook, restaurant);
		        }
	        	else {
	        		System.out.print("\nPhone Number? ");
		        	String tempPhone = consoleScanner.next();
		        	if (reservationType == 2) {
		        		PhoneReservation reservation = new PhoneReservation(tempName, tempSize, tempTime, tempPhone);
		        		insertReservation(reservation, reservationBook, restaurant);
		        	}
		        	else {
		        		System.out.print("\nSource Website? ");
		        		String tempWebsite = consoleScanner.next();
		        		Reservation reservation = new InternetReservation(tempName, tempSize, tempTime, tempPhone, tempWebsite); 
		        		insertReservation(reservation, reservationBook, restaurant);
		        	}

	        	}
	        	
	        }
	        else if (result.equals("list")) {
	        	reservationBook.listReservations();
	            
	        }
	        
	        else if (result.equals("lookup")) {
	        	System.out.print("Enter last name of reservation to lookup (case sensitive): ");
		        String nameToLookUp = consoleScanner.next();
		        ReservationIndex reservationIndex = reservationBook.getReservationIndex();
		        Reservation reservation = lookUpReservationByName(nameToLookUp, reservationIndex); 
		        if (reservation == null) {
		        	System.out.print("\nSorry, couldn't find any reservations with that last name.");
		        }
		        else {
		        	System.out.print("\nFound a reservation for " + reservation.getGuestLastName());
		        	System.out.print(" at " + reservation.getReservationHour() + "pm for " + reservation.getPartySize() + " people.");
		        }
	        }
	        
	        else if (result.equals("quit")) {
	        	System.out.println("Quitting");
	        	return;
	        }
	        
	        else {
	            System.out.println("Invalid input, try again");
	        }
        }
	}
	
	public static void insertReservation(Reservation reservation, ReservationBook reservationBook, Restaurant restaurant) {
		reservationBook.addReservation(reservation, restaurant);
	}
	
	public static Reservation lookUpReservationByName(String nameToLookUp, ReservationIndex reservationIndex) {
		Reservation reservation = reservationIndex.getReservationByName(nameToLookUp, reservationIndex);
		return reservation;
	}

}
