import java.util.Scanner;

public class Symptoms 
{
	private int[] symptomArray = new int[22];
	
	/*Input Symptoms*/
	/*Handles athlete input for entering in their symptoms*/
	public void input_Symptoms()
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nENTER SYMPTOMS FROM THE LAST GAME");
		System.out.println("---------------------------------------------------");
		System.out.print("Please enter your headache score" + " (none (0), mild (1-2), moderate (3-4), or severe (5-6)): ");
		symptomArray[0] = scan.nextInt();
		System.out.print("Please enter your pressure in head score" + " (none (0), mild (1-2), moderate (3-4), or severe (5-6)): ");
		symptomArray[1] = scan.nextInt();
		System.out.print("Please enter your neck pain score" + " (none (0), mild (1-2), moderate (3-4), or severe (5-6)): ");
		symptomArray[2] = scan.nextInt();
		System.out.print("Please enter your nausea or vomitting score" + " (none (0), mild (1-2), moderate (3-4), or severe (5-6)): ");
		symptomArray[3] = scan.nextInt();
		System.out.print("Please enter your dizziness score" + " (none (0), mild (1-2), moderate (3-4), or severe (5-6)): ");
		symptomArray[4] = scan.nextInt();
		System.out.print("Please enter your blurred vision score" + " (none (0), mild (1-2), moderate (3-4), or severe (5-6)): ");
		symptomArray[5] = scan.nextInt();
		System.out.print("Please enter your balance problems score" + " (none (0), mild (1-2), moderate (3-4), or severe (5-6)): ");
		symptomArray[6] = scan.nextInt();
		System.out.print("Please enter your sensitivity to light score" + " (none (0), mild (1-2), moderate (3-4), or severe (5-6)): ");
		symptomArray[7] = scan.nextInt();
		System.out.print("Please enter your sensitivity to noise score" + " (none (0), mild (1-2), moderate (3-4), or severe (5-6)): ");
		symptomArray[8] = scan.nextInt();
		System.out.print("Please enter your feeling slowed down score" + " (none (0), mild (1-2), moderate (3-4), or severe (5-6)): ");
		symptomArray[9] = scan.nextInt();
		System.out.print("Please enter your feeling like \"in a fog\" score" + " (none (0), mild (1-2), moderate (3-4), or severe (5-6)): ");
		symptomArray[10] = scan.nextInt();
		
		System.out.print("Please enter your \"don't feel right\" score" + " (none (0), mild (1-2), moderate (3-4), or severe (5-6)): ");
		symptomArray[11] = scan.nextInt();
		System.out.print("Please enter your difficulty concentrating score" + " (none (0), mild (1-2), moderate (3-4), or severe (5-6)): ");
		symptomArray[12] = scan.nextInt();
		System.out.print("Please enter your difficulty remembering score" + " (none (0), mild (1-2), moderate (3-4), or severe (5-6)): ");
		symptomArray[13] = scan.nextInt();
		System.out.print("Please enter your fatigue or low energy score" + " (none (0), mild (1-2), moderate (3-4), or severe (5-6)): ");
		symptomArray[14] = scan.nextInt();
		System.out.print("Please enter your confusion score" + " (none (0), mild (1-2), moderate (3-4), or severe (5-6)): ");
		symptomArray[15] = scan.nextInt();
		System.out.print("Please enter your drowsiness score" + " (none (0), mild (1-2), moderate (3-4), or severe (5-6)): ");
		symptomArray[16] = scan.nextInt();
		System.out.print("Please enter your trouble falling asleep score" + " (none (0), mild (1-2), moderate (3-4), or severe (5-6)): ");
		symptomArray[17] = scan.nextInt();
		System.out.print("Please enter your feeling more emotional score" + " (none (0), mild (1-2), moderate (3-4), or severe (5-6)): ");
		symptomArray[18] = scan.nextInt();
		System.out.print("Please enter your irritability score" + " (none (0), mild (1-2), moderate (3-4), or severe (5-6)): ");
		symptomArray[19] = scan.nextInt();
		System.out.print("Please enter your sadness score" + " (none (0), mild (1-2), moderate (3-4), or severe (5-6)): ");
		symptomArray[20] = scan.nextInt();
		System.out.print("Please enter your nervous or anxious score" + " (none (0), mild (1-2), moderate (3-4), or severe (5-6)): ");
		symptomArray[21] = scan.nextInt();
		System.out.println("");
	}
	
	/*Get Symptom Array*/
	/*Returns the created symptom array*/
	public int[] get_Symptom_Array()
	{
		return symptomArray;
	}
}