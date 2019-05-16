package business;

public class Movie {
	
	String title;
	int year;
	double rating;
	
	
	
	public Movie() {
		this.title = "";
		this.year = 0;
		this.rating = 0;
		
	}



	public Movie(String title, int year, double rating) {
		super();
		this.title = title;
		this.year = year;
		this.rating = rating;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public double getRating() {
		return rating;
	}



	public void setRating(double rating) {
		this.rating = rating;
	}



	@Override
	public String toString() {
		return "Movie [title=" + title + ", year=" + year + ", rating=" + rating + "]";
	}
	

}
