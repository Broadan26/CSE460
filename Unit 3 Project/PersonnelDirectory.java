import java.util.Scanner;

public class PersonnelDirectory
{
	public static void main(String[] args)
	{
		Personnel per = new Personnel();
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		int choice = -1;
		
		do
		{
			main_menu(); //Changed
	        choice = scan.nextInt();
	        scan.nextLine();
	
	        switch(choice)
	        {
				case 1: //Add a new Employee
					per.addPersonnel(addPerson(scan)); //Call to factory
					break;
				case 2: //Find a Person
					per.findPerson();
					break;
				case 3: //Print list of Names
					per.printPersons();
					break;
				case 4: //Print total People
					System.out.println("Total Entries : " + per.getTotalpersonnel());
					break;
				case 5: //Exit program
					System.out.println("Exiting Program");
					run = false;
					break;
				default:
					System.out.println("Incorrect Input");
			}
	    } while(run);
	 }
	
	public static void main_menu() //Improve menu modularity
	{
		System.out.println("Welcome to the Personnel Directory Management System");
		System.out.println("====================================================");
        System.out.println("\n\t 1. Add Personnel");
        System.out.println("\n\t 2. Find Personnel");
        System.out.println("\n\t 3. Print Names");
        System.out.println("\n\t 4. Number of Entries in the Directory");
        System.out.println("\n\t 5. Exit the Program");
        System.out.println("\n\t Select one of the options above (1, 2, 3, 4, 5)");
	}
	
	public static Person addPerson(Scanner scan) //Personnel Factory
	{
		boolean run = true;
		int type = -1;
		
		while(run)
		{
			System.out.println("What role do you want to add to the personnel directory?");
			System.out.println("(1 - Employee, 2 - Executive, 3 - Security, 4 - Volunteer");
			type = scan.nextInt();
		
			if(type > 0 && type < 5)
				run = false;
			else
				System.out.println("Please enter a valid option");
		}
		
		Person person = PersonnelFactory.PersonCreation(type);
		return person;
	}
}