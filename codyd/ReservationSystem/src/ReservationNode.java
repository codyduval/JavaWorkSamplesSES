import java.util.LinkedList;

public class ReservationNode {
    private int reservationHour;
    private Reservation reservation;
    private int numberOfReservationsAtHourCounter;
    private LinkedList<Reservation> reservationListForHour;
    private ReservationNode leftChild;
    private ReservationNode rightChild;
    

    public ReservationNode(int reservationHour, LinkedList<Reservation> reservationListForHour) {
        this.reservationHour = reservationHour;
        this.reservationListForHour = reservationListForHour;
        this.numberOfReservationsAtHourCounter = 1;
    }

    public int getValue() {
        return reservationHour;
    }
    
    public String getReservationName() {
    	String guestLastName = reservation.getGuestLastName();
        return guestLastName;
    }
    
    public void addOneReservationToCounter() {
    	this.numberOfReservationsAtHourCounter = numberOfReservationsAtHourCounter + 1;
    }
    
    public int getNumberOfReservationsForHour(){
    	return this.numberOfReservationsAtHourCounter;
    }
    
    public LinkedList<Reservation> getReservationListForHour() {
    	return reservationListForHour;
    }

    public ReservationNode getLeftChild() {
        return leftChild;
    }

    public ReservationNode getRightChild() {
        return rightChild;
    }

    public void setLeftChild(ReservationNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(ReservationNode rightChild) {
        this.rightChild = rightChild;
    }
}