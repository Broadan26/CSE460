import java.util.Scanner;

public class Symptoms_Summary 
{
	protected Symptoms[] gameArray;
	protected int num_games;
	
	/*Create the Symptom Summary object*/
	public Symptoms_Summary(Symptoms[] games, int num_games)
	{
		gameArray = games;
		this.num_games = num_games;
	}
	
	/*Symptom Menu*/
	/*Shows options for the Symptom commands*/
	public void symptomMenu()
	{
		int selection = 0;
		Scanner scan = new Scanner(System.in);
		
		while(selection != 4)
		{
			System.out.println("Welcome to the Symptoms Summary Menu");
			System.out.print("Please select one of the following options\n" +
					 "     1. Single Game Summary\n" +
					 "     2. Compare Successive Games\n" +
					 "     3. Compare Any Two Games\n" +
					 "     4. Back to Main Menu\n");
			
			selection = scan.nextInt();
			switch(selection)
			{
				case 1: //Single Game Summary
					viewSingleGame();
					break;
				case 2: //Compare Two Games
					compareSuccessiveGames();
					break;
				case 3:
					compareAnyTwoGames();
					break;
				case 4: //Exit this section
					break;
				default:
					System.out.println("Invalid Entry");
			}
		}
	}
	
	/*View the symptoms summary*/
	protected void viewSingleGame()
	{
		if(gameArray[0] == null) //Check for no entries
		{
			System.out.println("There are no games to show");
		}
		else //Generate Summary information
		{
			int totalSymptoms = 0;
			int symptomSeverity = 0;
			int lookup = getGame();
			
			int analyze[] = new int[22];
			analyze = gameArray[lookup].get_Symptom_Array();
			
			totalSymptoms = calculateTotalSymptoms(analyze);
			symptomSeverity = calculateSeverityScore(analyze);
			
			System.out.println("Symptom Score for Game " + (lookup + 1));
			System.out.println("---------------------");
			System.out.println("Total Symptoms: " + totalSymptoms + "\nSymptom Severity Overall: " + symptomSeverity + "\n");
		}
	}
	
	/*Compare Successive Games*/
	/*Comapres two games, starting with the most recent game*/
	protected void compareSuccessiveGames()
	{
		if(gameArray[1] == null) //Check for too few entries
		{
			System.out.println("There are not enough games to perform a comparison");
		}
		else
		{
			int lookup1 = getGame(); //Most recent entry
			int lookup2;
			if(lookup1 == 0 && num_games < 6) //Check for less than 5 entries
				System.out.println("No other games to compare to");
			else
			{
				if(lookup1 == 0 && num_games > 5) //Check for more than 5 entries
					lookup2 = 4; //Circular list
				else
					lookup2 = lookup1 - 1;
				performComparison(lookup1, lookup2);
			}
		}
	}
	
	/*Compare Games*/
	/*Compares two games of the athletes choice*/
	protected void compareAnyTwoGames()
	{
		if(gameArray[1] == null) //Check for too few entries
		{
			System.out.println("There are not enough games to perform a comparison");
		}
		else //Generate Summary information
		{
			int lookup1 = getGame(); //First entry
			int lookup2 = getGame(); //Second entry
			
			if(lookup1 == lookup2) //Check for same game entered
			{
				System.out.println("No Difference: Same game selected");
			}
			else //Perform comparison
			{
				performComparison(lookup1, lookup2);
			}
		}
	}
	
	/*Perform Comparison*/
	/*Performs the comparison of two games once information is collected*/
	protected int performComparison(int lookup1, int lookup2)
	{
		int diffType = -1;
		int analyze1[] = new int[22];
		analyze1 = gameArray[lookup1].get_Symptom_Array();
		int analyze2[] = new int[22];
		analyze2 = gameArray[lookup2].get_Symptom_Array();
		
		int totalSymptomDiff = calculateTotalSymptoms(analyze1) - calculateTotalSymptoms(analyze2); //Find diff
		totalSymptomDiff = Math.abs(totalSymptomDiff); 
		int severityScoreDiff = calculateSeverityScore(analyze1) - calculateSeverityScore(analyze2); //Find diff
		severityScoreDiff = Math.abs(severityScoreDiff);
		
		if(totalSymptomDiff < 3 && severityScoreDiff < 10)
		{
			System.out.println("No Difference\n");
			diffType = 1;
		}
		else if(totalSymptomDiff < 3 && severityScoreDiff >= 10)
		{
			System.out.println("Unsure of Difference\n");
			diffType = 2;
		}
		else if(totalSymptomDiff >= 3 || severityScoreDiff >= 15)
		{
			System.out.println("Very Different\n");
			diffType = 3;
		}
		
		return diffType;
	}
	
	/*Get Game*/
	/*Takes user input to collect game data from object array*/
	private int getGame()
	{
		Scanner scan = new Scanner(System.in);
		int lookup = num_games + 1;
		
		while(lookup > num_games)
		{
			System.out.print("Select the game you want the summary for " + " (Enter a value between 1 and 5: ");
			lookup = scan.nextInt();
			lookup--;
			if((lookup < 0 || lookup > 4) || lookup > num_games - 1) //Remove bad entries
			{
				lookup = num_games + 1;
				System.out.println("Invalid entry");
			}
		}
		return lookup;
	}
	
	/*Calculate Total Symptoms*/
	/*Calculates the total number of symptoms for a game*/
	private int calculateTotalSymptoms(int[] analyze)
	{
		int totalSymptoms = 0;
		for(int i = 0; i < 22; i++)
			if(analyze[i] != 0)
				totalSymptoms++;
		return totalSymptoms;
	}
	
	/*Calculate Severity Score*/
	/*Calcualtes the severity score for a game*/
	private int calculateSeverityScore(int[] analyze)
	{
		int severityScore = 0;
		for(int i = 0; i < 22; i++)
			severityScore = severityScore + analyze[i];
		
		return severityScore;
	}
}