
public class Dice 
{
	private int die1Inputs;
	private int die2Inputs;
	private int[] die1Rolls;
	private int[] die2Rolls;
	private int loadedDie1Index;
	private int loadedDie2Index;
	
	private int lastDie1Roll;
	private int lastDie2Roll;
	
	public Dice()
	{
	
	}
	
	public Dice(int[] die1Rolls, int[] die2Rolls)
	{
		loadedDie1Index = 0;
		loadedDie2Index = 0;
		
		this.die1Rolls = die1Rolls;
		this.die2Rolls = die2Rolls;
		
		die1Inputs = die1Rolls.length;
		die2Inputs = die2Rolls.length;
	}
	
	public void roll()
	{
		lastDie1Roll = die1Rolls[loadedDie1Index];
		lastDie2Roll = die2Rolls[loadedDie2Index];
		
		loadedDie1Index++;
		if (loadedDie1Index >= die1Inputs )
			loadedDie1Index = 0;
		
		loadedDie2Index++;
		if (loadedDie2Index >= die1Inputs )
			loadedDie2Index = 0;
	}
	
	public int getDie1Roll()
	{
		return lastDie1Roll;
	}
	
	public int getDie2Roll()
	{
		return lastDie2Roll;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
