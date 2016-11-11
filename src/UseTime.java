
import java.util.Scanner;

/* X.Page 
 * This implements the client program described in the in-class programming exercise part 1.
 */
public class UseTime {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		Time t = new Time();
		boolean validInput;
		
		System.out.println("Testing the Time class definition: ");
		do {
			System.out.println("Please enter hour and minute value: ");
			int h = kb.nextInt();
			int m = kb.nextInt();
			validInput = t.setTime(h, m);	// Remember, this method already prints an error statement for us
		} while (!validInput);
				
		System.out.println("Hour is " + t.getHour() + ", minute is " + t.getMinute() + ".");
		
		System.out.println("That’s " + t.toMinutes() + " minutes, or " + t.getAMPMTime() + ". ");
	
		System.out.println("How many minutes would you like to add to that time? ");
		int addMin = kb.nextInt();

		System.out.println("That's " + t.timeAfter(addMin).getAMPMTime());
		
		kb.close();
	}

}