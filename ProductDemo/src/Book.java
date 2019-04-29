
public class Book extends Product {
	
	private String author;

	public Book() {
		super();
	}

	public Book(String c, String d, double p, String author) {
		super(c, d, p);
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", " + super.toString() + "]";
	}
	
		
	
}
