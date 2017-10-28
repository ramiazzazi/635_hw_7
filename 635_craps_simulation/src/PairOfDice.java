/**
 * Dice represents a single pair of rollable Die objects, randomly generating
 * sums of their two values
 * 
 * This is a Javadoc comment: add more to your finished class below
 * 
 * @author eric
 *
 */
public class PairOfDice
{
	// Instance fields (variables) may be declared anywhere in class body
	// Convention: put at top

	private int lastRoll;
	private Die die1;
	private Die die2;

	// Constructors (object initializers) also can be declared anywhere
	// Convention: after instance fields/variables

	public PairOfDice()
	{
		// initialize instance variables die1 and die2 by
		// creating a new instance of each

		this.die1 = new Die();
		this.die2 = new Die();
		this.roll();
	}

	public PairOfDice(Die die1, Die die2) // overloaded constructor
	{
		this.die1 = die1;
		this.die2 = die2;
	}

	// Instance methods can also be declared anywhere
	// Convention: after constructors

	public int getLastRoll()
	{
		return this.lastRoll;
	}

	public void roll()
	{
		// roll each of die1, die2, sum their last rolls,
		// then set Dice.lastRoll to this value

		die1.roll();
		die2.roll();
		this.lastRoll = die1.getLastRoll() + die2.getLastRoll();

	}

	
	public String toString()
	{
		return "Roll of " + getLastRoll() + ": " + die1.getLastRoll() + " + " + die2.getLastRoll();

	}

	// static methods can go anywhere - but at end is standard

	public static final int NUM_OF_ROLLS = 360;

	public static void main(String[] args)
	{
		PairOfDice pairOfdice = new PairOfDice();
		int snakeEyesCount = 0;

		for (int i = 0; i < NUM_OF_ROLLS; i++)
		{
			pairOfdice.roll();
			StdOut.println(pairOfdice);
			
			if (isSnakeEyes(pairOfdice))				//refactored from if (dice1.getLastRoll() == 2)
				snakeEyesCount++;
		}

		StdOut.println("Actual count: " + snakeEyesCount);
		StdOut.println("Expected count: " + (NUM_OF_ROLLS / 36.0));
	}

	private static boolean isSnakeEyes(PairOfDice pairOfdice)
	{
		return pairOfdice.getLastRoll() == 2;
	}
}
