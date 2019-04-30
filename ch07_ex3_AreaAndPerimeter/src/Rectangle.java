import java.text.NumberFormat;
import java.util.Scanner;

public class Rectangle {
	Scanner sc = new Scanner(System.in);
	double length;
	double width;
	
	public Rectangle() {
		length = 0;
		width = 0;
	}
	
	public double getPerimeter(double width, double length) {
		double p = (2* width) + (2 * length);
		return p;
	}
	
	public String getPerimeterString() {
		String pString = "";
		NumberFormat n = NumberFormat.getNumberInstance();
		n.setMinimumFractionDigits(3);
		n.format(pString);
		return pString;
	}
	
	public double getArea(double width, double length) {
		double area = width * length;
		return area;
	}
	
	public String getAreaString() {
		String areaString = "";
		NumberFormat number = NumberFormat.getNumberInstance();
		number.setMinimumFractionDigits(3);
		number.format(areaString);
		return areaString;
	}
	
	public Rectangle(double length, double width) {
		super();
		this.length = length;
		this.width = width;
	}
	
	public double getLength() {
		System.out.print("Enter length: ");
        double length = Double.parseDouble(sc.nextLine());
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		System.out.print("Enter width:  ");
        double width = Double.parseDouble(sc.nextLine());
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	
	

}
