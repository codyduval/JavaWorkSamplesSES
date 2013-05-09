
public class Restaurant {

	private String restaurantName;
	protected int numberOfTables;
	protected int openHour;
	protected int closedHour;
	private int totalHoursOpen = this.closedHour = this.openHour;
	
	public Restaurant() {
		super();
		this.restaurantName = "Cody's Kitchen";
		this.numberOfTables = 50;
		this.openHour = 17;
		this.closedHour = 24;
	}
	
	public Restaurant(String restaurantName) {
        this();
        this.restaurantName = restaurantName;
    }
	
	public String getRestaurantName() {
		return this.restaurantName;
	}
	
	public int getNumberOfTables() {
        return this.numberOfTables;
    }
	
	public int getOpenHour() {
        return this.openHour;
    }
	
	public int getClosedHour() {
        return this.closedHour;
    }
	
	public int getTotalHoursOpen() {
		return totalHoursOpen;
	}
	
}
