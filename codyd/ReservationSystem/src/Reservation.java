
public class Reservation {

	protected String guestLastName;
	protected int partySize;
	protected int reservationHour;
	
	public Reservation() {
		super();
	}
	
	public Reservation(String guestLastName, int partySize, int reservationHour) {
        this();
        this.guestLastName = guestLastName;
        this.partySize = partySize;
        this.reservationHour = reservationHour;
    }

	public String getGuestLastName() {
		return guestLastName;
	}

	public void setGuestLastName(String guestLastName) {
		this.guestLastName = guestLastName;
	}

	public int getPartySize() {
		return partySize;
	}

	public void setPartySize(int partySize) {
		this.partySize = partySize;
	}

	public int getReservationHour() {
		return reservationHour;
	}

	public void setReservationHour(int reservationHour) {
		this.reservationHour = reservationHour;
	}
	
	
	
}
