
public class ItemMagazine extends Item {

	private Integer issueNumber;
	
	public ItemMagazine() {
		super();
		this.issueNumber = 0;
		super.loanPeriodDays = 0;
		super.isLoanable = false;
	}
	
	public ItemMagazine(Integer issueNumber, String title) {
		this.issueNumber = issueNumber;
		super.title = title;
		super.isLoanable = false;
	}

	public Integer getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(Integer issueNumber) {
		this.issueNumber = issueNumber;
	}
}
