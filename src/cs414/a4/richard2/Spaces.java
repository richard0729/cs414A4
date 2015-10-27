package cs414.a4.richard2;

public class Spaces {

	private int maxSpaces = 5;
	private int usedSpaces = 0;
	
	public double getMaxSpaces() { return maxSpaces; }
	public void setMaxSpaces(int newSpaces) {
		maxSpaces = newSpaces;
	}
	
	public double getUsedSpaces() { return usedSpaces; }
	public void setUsedSpaces(int newSpaces) {
		usedSpaces = newSpaces;
	}
	
	public void increaseEnter()
	{
		++usedSpaces;
	}
	
	public void decreaseExit()
	{
		--usedSpaces;
	}
	
}
