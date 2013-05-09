import java.util.HashMap;

public class ReservationIndex extends HashMap {
	private String guestLastName;
	private Reservation reservation;
	private HashMap<String,Reservation> reservationIndex;
	
	public ReservationIndex() {
		this.guestLastName = guestLastName;
        this.reservation = reservation;
    }
	
	public void addReservationToIndex(Reservation reservation, ReservationIndex reservationIndex) {
		guestLastName = reservation.getGuestLastName();
		reservationIndex.put(guestLastName, reservation);
	}
	
	public Reservation getReservationByName(String guestLastName, ReservationIndex reservationIndex){
			Reservation reservation = (Reservation) reservationIndex.get(guestLastName);
			return reservation;
	}
	
	
	

}
