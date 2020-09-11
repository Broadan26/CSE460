public class PersonnelFactory 
{
	public static Person PersonCreation(int type)
	{
		switch(type)
		{
			case 1: //Employee
				Employee emp = new Employee();
				emp.createEmployee();
				return emp;
			case 2: //Executives
				Executives exec = new Executives();
				exec.createExecutive();
				return exec;
			case 3: //Security
				Security sec = new Security();
				sec.createSecurity();
				return sec;
			case 4: //Volunteers
				Volunteers vol = new Volunteers();
				vol.createVolunteer();
				return vol;
			default:
				return null;
		}
	}
}