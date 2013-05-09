import java.util.HashMap;
import java.util.LinkedList;


public class ReservationBook {
    private ReservationNode rootNode;
    public ReservationIndex reservationIndex = new ReservationIndex();
    
    public void listReservations() {
        LinkedList<ReservationNode> queue = new LinkedList<ReservationNode>();
        queue.add(rootNode);
	        System.out.println("\nAll reservations:" );
	        while(!queue.isEmpty()) {
	        	ReservationNode node = queue.remove();
	            System.out.println("\nAt " + node.getValue() + " o'clock:");
	            LinkedList<Reservation> reservationsAtHour = node.getReservationListForHour();
	            for(int i = 0, n = reservationsAtHour.size(); i < n; i++) {
	                Reservation reservation = reservationsAtHour.get(i);
	                System.out.println(reservation.getGuestLastName() + " for a party size of " + reservation.getPartySize()); 
	               // System.out.println(reservation.getPhoneNumber());
	            }
	
	            if (node.getLeftChild() != null)
	                queue.add(node.getLeftChild());
	            if (node.getRightChild() != null)
	                queue.add(node.getRightChild());
	        }
   	
    }

    public void addReservationToHour(Reservation reservation, LinkedList<Reservation> reservationListForHour) {
    	reservationListForHour.add(reservation);
    }
        
    public void addReservation(Reservation reservation, Restaurant restaurant) {
        int reservationHour = reservation.getReservationHour();
        ReservationNode foundReservationHour = searchForExistingReservationNode(reservationHour);
        if (foundReservationHour != null) {
        	if (foundReservationHour.getNumberOfReservationsForHour() >= restaurant.getNumberOfTables() ) {
        		System.out.println("Sorry, there are no more reservations open for that time." );

        	}
        	LinkedList<Reservation> reservationListForHour = foundReservationHour.getReservationListForHour();
        	reservationListForHour.add(reservation);
        	foundReservationHour.addOneReservationToCounter();
        	reservationIndex.addReservationToIndex(reservation, reservationIndex);
        }
        else {
	    	if (rootNode == null) {
	    		LinkedList<Reservation> reservationListForHour = new LinkedList<Reservation>();
	    		reservationListForHour.add(reservation);
	            rootNode = new ReservationNode(reservationHour, reservationListForHour);
	            reservationIndex.addReservationToIndex(reservation,reservationIndex);
	        }
	
	        else {
	        	
	        	ReservationNode currentNode = rootNode;
	
	            while (currentNode.getValue() != reservationHour) {
	                if (reservationHour > currentNode.getValue()) { // Right child path
	                    if (currentNode.getRightChild() == null) {
	                		LinkedList<Reservation> reservationListForHour = new LinkedList<Reservation>();
	                		reservationListForHour.add(reservation);
	                        currentNode.setRightChild(new ReservationNode(reservationHour, reservationListForHour));
	                    }
	                    currentNode = currentNode.getRightChild();
	                }
	                else { // Left child path
	                    if (currentNode.getLeftChild() == null) {
	                    	LinkedList<Reservation> reservationListForHour = new LinkedList<Reservation>();
	                		reservationListForHour.add(reservation);
	                        currentNode.setLeftChild(new ReservationNode(reservationHour, reservationListForHour));
	                    }
	                    currentNode = currentNode.getLeftChild();
	                }
	            }
	        }
        }
    }


    
    public ReservationNode searchForExistingReservationNode(int reservationHour) {
    	ReservationNode currentNode = rootNode;

        while(currentNode != null && (currentNode.getValue() != reservationHour)) {
            if (reservationHour > currentNode.getValue()) { // Continue down the right child path
                currentNode = currentNode.getRightChild();
            }
            else { // Continue down the left child path
                currentNode = currentNode.getLeftChild();
            }
        }
        // If the current node exists and its value is equal to the input, return true, else return false
        return currentNode;
    }
    
    public ReservationIndex getReservationIndex(){
		return reservationIndex;
	}

    public void remove(int value) {
        // TODO: 
        // To remove, first examine the find the node, then:
        // 1) Node N has no children? Just remove N
        // 2) Node N has one child? Just remove N and replace with the child
        // 3) Node N has two children? A little harder. Either take the in-order successor or predecessor R, swap the values of N and R, then delete R

    }
}