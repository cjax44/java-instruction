package business;

import util.Countable;

public class Sheep extends Animal implements Cloneable, Countable {
	
	String name = "Blackie";

	@Override
	public void incrementCount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetCount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCountString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		String name = "Dolly";
		
		return name;
	}

	@Override
	public String toString() {
		String sheepName = counter + " " + name;
		return sheepName;
	}

}
