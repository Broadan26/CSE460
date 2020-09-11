import java.util.ArrayList;
import java.util.Scanner;

public class Personnel 
{
	private ArrayList<Person> personList;
	private int totalpersonnel;

	public Personnel() 
	{
		personList = new ArrayList<Person>();
		totalpersonnel = 0;
	}

	public void addPersonnel(Person p)
	{
		personList.add(p);
		totalpersonnel++; //Changed
	}
	
	public Person getPersonnel(int location)
	{
		return personList.get(location);
	}

	public int getTotalpersonnel() //Added
	{
		return totalpersonnel;
	}
	
	public void printPersons() //Added from PersonnelDirectory
	{
		if(getTotalpersonnel() == 0)
			System.out.println("No personnel in the database");
		else
		{
			System.out.println("Enter the order 0: first, middle,  last, 1: last, middle, first, 2: last, first , middle ");
			Scanner scan = new Scanner(System.in);
			int order = scan.nextInt();
			
			if(order == 0) //Standard Print
				for(int i = 0; i < getTotalpersonnel(); i++) //Changed
				{
					getPersonnel(i).printStandard();
				}
			else if(order == 1) //Reverse Print
				for(int i = 0; i < getTotalpersonnel(); i++) //Changed
				{
					getPersonnel(i).printReverse(); 
				}
			else //Weird Print
				for(int i = 0; i < getTotalpersonnel(); i++) //Changed
				{
					getPersonnel(i).printLast(); 
				}
		}
	}
	
	public void findPerson() //Added from PersonnelDirectory
	{
		String firstN, lastN;
		boolean found = false;
		int location = -1;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter first name : ");
		firstN = scan.nextLine();
		System.out.println("Enter last name : ");
		lastN = scan.nextLine();
		
		for(int i = 0; i < getTotalpersonnel(); i++)
		{
			if(getPersonnel(i).getFirstName().equals(firstN) && getPersonnel(i).getLastName().equals(lastN))
			{
				found = true;
				location = i;
			}
		}
		
		if(found == true)
		{
			System.out.println("Person Found");
			getPersonnel(location).printStandard();
		}
		else
		{
			System.out.println("Person Not Found, Adding to Personnel List");
			Person p1  = new Person(lastN, firstN, " ");
			addPersonnel(p1);
		}
	}
}