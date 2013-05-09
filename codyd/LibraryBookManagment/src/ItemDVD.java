
public class ItemDVD extends Item {
	
	private String director;
	
	public ItemDVD() {
		super();
		this.director = "unknown director";
		super.loanPeriodDays = 3;
		super.isLoanable = true;
	}
	
	public ItemDVD(String director, String title) {
		super.title = title;
		this.director = director;
		super.isLoanable = true;
		super.loanPeriodDays = 3;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	
	
}
