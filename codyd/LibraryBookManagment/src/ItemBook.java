
public class ItemBook extends Item {
	private String author;
	
	public ItemBook() {
		super();
		this.author = "unknown author";
		super.loanPeriodDays = 14;
		super.isLoanable = true;
	}
	
	public ItemBook(String author, String title) {
		this.author = author;
		super.title = title;
		super.isLoanable = true;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
