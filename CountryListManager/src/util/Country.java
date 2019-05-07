package util;

public class Country {
	
	private String name;
	
	public Country() {
		this("");
	}

	public Country(String string) {
		this.name = string;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
