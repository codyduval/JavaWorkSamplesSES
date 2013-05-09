
public class Item {
	
	protected String title;
	protected Boolean isLoanable;
	protected Integer loanPeriodDays;
	protected Boolean isLoaned;

	public Item() {
		this.title = "unknown title";
		this.isLoanable = true;
		this.isLoaned = false;
	}
	
	public Item(String title, Boolean isLoanable) {
		this.title = title;
		this.isLoanable = isLoanable;
		this.isLoaned = false;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getIsLoanable() {
		return isLoanable;
	}

	public void setIsLoanable(Boolean isLoanable) {
		this.isLoanable = isLoanable;
	}
	
	public Boolean getIsLoaned() {
		return isLoaned;
	}

	public void setIsLoaned(Boolean isLoaned) {
		this.isLoaned = isLoaned;
	}

	public Integer getLoanPeriodDays() {
		return loanPeriodDays;
	}

	public void setLoanPeriodDays(Integer loanPeriodDays) {
		this.loanPeriodDays = loanPeriodDays;
	}
	
	
	
	
}