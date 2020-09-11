import java.util.Scanner;

public class Volunteers extends Person
{
	public Volunteers()
	{
		super("Doe", "John", " ");
	}
	
	public Volunteers(String last, String first, String middle)
	{
		super(last, first, middle);
	}
	
	public void createVolunteer() //Added
	{
		Scanner scan = new Scanner(System.in);
		String firstN, lastN, midN;
		
		System.out.println("Enter first name: ");
		firstN = scan.nextLine();
		System.out.println("Enter last name: ");
		lastN = scan.nextLine();
		System.out.println("Enter middle name: ");
		midN = scan.nextLine();
		super.setFirstName(firstN);
		super.setLastName(lastN);
		super.setMiddleName(midN);
	}
}