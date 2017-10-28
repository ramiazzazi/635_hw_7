// foo again
public class CrapsGame
{
	private PairOfDice dice;
	public static boolean showOutput = true;

	public static void println(String str)
	{
		if (showOutput)
			StdOut.println(str);
	}

	public CrapsGame()
	{
		dice = new PairOfDice();
	}

	public CrapsGame(Die die1, Die die2)
	{
		dice = new PairOfDice(die1, die2);
	}

	
	private int sumOfPair;

	public boolean playOneGame(int[] winsPerRoll, int[] lossesPerRoll)
	{
		int rollNumber = 1;

		doFirstRoll();

		if (isFirstRollWin())
		{
			return singleWinForPlayer(winsPerRoll, rollNumber);
		}
		else if (isFirstRollLoss())
		{
			return singleLossForPlayer(lossesPerRoll, rollNumber);
		}
		else // point rolled: keep going until point rerolled OR 7 rolled
		{
			println("Point is: " + sumOfPair);
			
			int newRollValue = 0;
			do
			{
				dice.roll();
				rollNumber++;
				newRollValue = dice.getLastRoll();
				println("Next roll is: " + newRollValue);
			}
			while (isNeitherWinNorLoss(newRollValue));
			
			if (isRerollLoss(newRollValue))
			{
				println("You lose throwing a 7.");
				lossesPerRoll[rollNumber]++;
				return false;
			}
			else if (isRerollWin(newRollValue))
			{
				println("You win by throwing your point " + newRollValue);
				winsPerRoll[rollNumber]++;
				return true;

			}
		}

		return false;
	}

	//extracted method during refactoring
	private boolean isRerollWin(int newRollValue)
	{
		return newRollValue==sumOfPair;
	}

	//extracted method during refactoring
	private boolean isRerollLoss(int newRollValue)
	{
		return newRollValue==7;
	}

	//extracted method during refactoring
	private boolean isNeitherWinNorLoss(int newRollValue)
	{
		return newRollValue != 7 && newRollValue != sumOfPair;
	}
	
	//extracted method during refactoring
	private boolean isFirstRollLoss()
	{
		return sumOfPair==2 || sumOfPair == 3 || sumOfPair==12;
	}

	//extracted method during refactoring
	private boolean isFirstRollWin()
	{
		return sumOfPair == 7 || sumOfPair == 11;
	}

	private boolean singleLossForPlayer(int[] lossesPerRoll, int rollNumber)
	{
		println("Loss for player with " + sumOfPair);
		lossesPerRoll[rollNumber]++; 
		return false;
	}

	private void doFirstRoll()
	{
		dice.roll();

		sumOfPair = dice.getLastRoll();

		println("First roll is: " + dice.getLastRoll());
	}

	private boolean singleWinForPlayer(int[] winsPerRoll, int rollNumber)
	{
		println("Win for player with " + sumOfPair);
		winsPerRoll[rollNumber]++; 
		return true;
	}

	public static void main(String[] args)
	{
		// play a game!
	}
}
