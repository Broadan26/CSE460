public class At_Risk extends Symptoms_Summary
{
	//Colors for At Risk
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	
	/*Set Parameters*/
	public At_Risk(Symptoms[] games, int num_games) 
	{
		super(games, num_games);
	}
	
	/*Check Risk*/
	/*Checks the risk of the last two games played and displays an image*/
	public void checkRisk()
	{
		if(num_games < 2)
			System.out.println("Not enough games\n");
		else
		{
			int lookup1, lookup2;
			if(num_games < 6) //Check for only 5 games played
			{
				lookup1 = num_games - 1;
				lookup2 = num_games - 2;
			}
			else //Use modulus to perform cycle
			{
				lookup1 = (num_games - 1) % 5;
				lookup2 = (num_games - 2) % 5;
			}
			int diffType = performComparison(lookup1, lookup2);
			
			System.out.println("RISK INDICATOR");
			System.out.println("--------------------");
			if(diffType == 1) //No difference
			{
				System.out.println(ANSI_GREEN_BACKGROUND + "No Difference\n" + ANSI_RESET);
			}
			else if(diffType == 2) //Unsure of difference
			{
				System.out.println(ANSI_YELLOW_BACKGROUND + "Unsure of Difference\n" + ANSI_RESET);
			}
			else if(diffType == 3) //Very different
			{
				System.out.println(ANSI_RED_BACKGROUND + "Very Different\n" + ANSI_RESET);
			}
			else //Unable to perform correct logic
			{
				System.out.println("Unable to determine\n");
			}
		}
	}
}