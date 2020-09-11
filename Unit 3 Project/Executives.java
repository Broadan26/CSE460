import java.util.Scanner;

public class Executives extends Person
{
	private int empID;
	private double baseSalary;
	
	public Executives()
	{
		super("Doe", "John", " ");
		empID = -1;
		baseSalary = -1;
	}
	
	public Executives(String last, String first, String middle, int id, double sal)
	{
		super(last, first, middle);
		empID = id;
		baseSalary = sal;
	}
	
	public void createExecutive() //Added
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
		
		System.out.println("Enter employee id : ");
		empID = scan.nextInt();
		System.out.println("Enter base salary" );
		baseSalary = scan.nextDouble();
	}
	
	public int getID()
	{
		return empID;
	}
	
	public void setID(int empID) //Added
	{
		this.empID = empID;
	}
	
	public double getSalary() //Added
	{
		return baseSalary;
	}
	
	public void setSalary(double baseSalary) //Added
	{
		this.baseSalary = baseSalary;
	}
}
