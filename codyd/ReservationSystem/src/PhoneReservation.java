
public class PhoneReservation extends Reservation {

	protected String phoneNumber;
	
	public PhoneReservation(String guestLastName, int partySize, int reservationHour, String phoneNumber) {
		super.guestLastName = guestLastName;
        super.partySize = partySize;
        super.reservationHour = reservationHour;
        this.phoneNumber = phoneNumber;
    }

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
