package business;

public class Product {

	private String code;
	private String description;
	private double price;

	public Product() {
		code = "";
		description = "";
		price = 0.0;
	}

	public Product(String c, String d, double p) {
		code = c;
		description = d;
		price = p;
	}
// I wrote this getter
	
//	public String getCode() {
//		return code;
//	}
//	
//	
// I wrote this setter
	
//	public void setCode(String c) {
//		code = c;
//	}
	
// GENERATED GETTERS AND SETTERS
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", description=" + description + ", price=" + price + "]";
	}
	
	

}
