
public class Dice 
{
	private int dieInputs;
	private int[] die1Rolls;
	private int[] die2Rolls;
	private int loadedDieIndex;
	
	private int lastDie1Roll;
	private int lastDie2Roll;
	
	public Dice()
	{
	
	}
	
	public Dice(int[] die1Rolls, int[] die2Rolls, int dieInputs)
	{
		loadedDieIndex = 0;
		this.dieInputs = dieInputs;
		this.die1Rolls = die1Rolls;
		this.die2Rolls = die2Rolls;
	}
	
	public void roll()
	{
		lastDie1Roll = die1Rolls[loadedDieIndex];
		lastDie2Roll = die2Rolls[loadedDieIndex];
		
		loadedDieIndex++;
		if (loadedDieIndex >= dieInputs)
			loadedDieIndex = 0;
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
