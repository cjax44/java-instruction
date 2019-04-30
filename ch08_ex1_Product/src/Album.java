import java.text.NumberFormat;

public class Album extends Product {
	
	String artist = "";
	double price = 0.0;
	
	public Album() {
		super();
		this.artist = artist;
		count++;
	}

	public Album(String artist) {
		super();
		this.artist = artist;
		count++;
	}


	public String getArtist() {
		return artist;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}


	@Override
	public String toString() {
		return description + "(" + artist + ")";
	}
	
	


	
	
	
}
