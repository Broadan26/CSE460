public class Person 
{
	private String last;
	private String first;
	private String middle;
	
	public Person(String last, String first, String middle) 
	{
		this.last = last;
		this.first = first;
		this.middle = middle;
	}
	
	public String getFirstName()
	{
		return first;
	}
	
	public void setFirstName(String first)
	{
		this.first = first;
	}
	
	public String getLastName()
	{
		return last;
	}
	
	public void setLastName(String last)
	{
		this.last = last;
	}
	
	public String getMiddleName()
	{
		return middle;
	}
	
	public void setMiddleName(String middle)
	{
		this.middle = middle;
	}

	public void printStandard() //Changed
	{
		System.out.println(first + "  " + middle + "  " + last);
	}
	
	public void printReverse() //Changed
	{
		System.out.println(last + " " + middle + " " + first);
	}
	
	public void printLast() //Changed
	{
		System.out.println(last + ", " + first + " " + middle);
	}
}