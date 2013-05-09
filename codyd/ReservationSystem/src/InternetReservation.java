
public class InternetReservation extends Reservation {
	
	protected String phoneNumber;
	protected String referringWebsite;
	
	public InternetReservation(String guestLastName, int partySize, int reservationHour, String phoneNumber, String referringWebsite) {
		super.guestLastName = guestLastName;
        super.partySize = partySize;
        super.reservationHour = reservationHour;
        this.phoneNumber = phoneNumber;
        this.referringWebsite = referringWebsite;
    }
	
	
}
