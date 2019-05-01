package business;

import util.Countable;

public class Alligator extends Animal implements Countable {

	@Override
	public void incrementCount() {
		counter ++;
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
		String gatorStr = counter + " alligator";
		return gatorStr;
	}

}
