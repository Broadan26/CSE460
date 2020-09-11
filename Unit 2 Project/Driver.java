import java.util.Scanner;

public class Driver 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int selection = -1; //Controls menu
		Symptoms[] gameArray = new Symptoms[5]; //Holds the game objects
		int most_recent_game = 0; //Tracks most recent game
		int num_games = 0;
		
		while(selection != 4)
		{
			System.out.println("Welcome to the Sports Concussion Assessment System!");
			main_menu();
			selection = scan.nextInt();
			
			switch(selection)
			{
				case 1: //Enter Symptoms
					Symptoms game = new Symptoms();
					game.input_Symptoms();
					gameArray[most_recent_game] = game;
					most_recent_game = (most_recent_game + 1) % 5; //Update storage spot
					num_games++; //Update number of games
					break;
					
				case 2: //Display Symptom Summary
					Symptoms_Summary summary = new Symptoms_Summary(gameArray, num_games);
					summary.symptomMenu();
					break;
					
				case 3: //Am I at Risk?
					At_Risk risk = new At_Risk(gameArray, num_games);
					risk.checkRisk();
					break;
				case 4: //Exit
					System.out.println("Exiting Program");
					break;
				default: //Everything Else
					System.out.println("Invalid Selection\n" + "Please enter a value between 1 and 4\n");
			}
		}
	}
	
	/*Main Menu*/
	/*Displays the main menu for the athlete and medical practioner*/
	public static void main_menu()
	{
		System.out.print("Please select one of the following options\n" +
						 "     1. Enter Symptoms\n" +
						 "     2. Display Symptoms Summary\n" +
						 "     3. Am I at Risk?\n" + 
						 "     4. Exit Program\n");
	}
}