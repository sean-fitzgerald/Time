import java.text.DecimalFormat; // required import statement

/* X.Page CS180
 * This implements the Time class of the in-class programming exercise, part 1
 */

public class Time {
	private int hour;
	private int minute;
	/* Method
	boolean setTime(int hour, int minute )
	 * - sets the hour and minute value of the calling object to
	 * the parameters, if params hour and minute* have appropriate values.
	 * Returns true, if values were appropriate, false, otherwise. */
	public boolean setTime(int h, int m ) {

		boolean ok = true;
		// check if hour is appropriate
		if ( h < 0 || h > 23){
			System.out.println("Invalid value of hour: "+h);
			ok = false;
		}
		// check if minute is appropriate
		if ( m < 0 || m > 59){
			System.out.println("Invalid value of minute: "+m);
			ok = false;
		}
		
		if (ok) {
			this.minute = m;
			this.hour = h;
		}
		
		return ok;
	}

	/* Accessor methods */

	public int getHour(){
		return this.hour; // can also use hour
	}

	public int getMinute() {
		return this.minute; //can also use minute
	}

	/* public int toMinutes()
         * returns the time of the calling object, represented in minutes only */
	public int toMinutes(){
		// compute the calling object in minutes only
		int thisInMinutes = this.hour *60 + this.minute;
		return thisInMinutes;
	}

	/* public String getAMPMTime()
	 * Returns a string like "2:35 PM" or "7:15 AM" based on the calling object*/

	public String getAMPMTime(){
		String ampm;

		DecimalFormat minFrm = new DecimalFormat("00");
		if (this.hour < 12 )
			ampm = this.hour + ":" + minFrm.format(this.minute) + " AM";
		else if (this.hour == 12)
			ampm = this.hour + ":" + minFrm.format(this.minute) + " PM";
		else // here this.hour > 12
			ampm = (this.hour-12) + ":" + minFrm.format(this.minute) + " PM";
		return ampm;

	}

	/* public Time timeAfter(int min)
	 * creates and returns a Time object, representing the calling object's time
	 * plus min minutes. */

	public Time timeAfter(int min){
		int newMinutes = min + this.toMinutes();
		Time newTime = new Time();
		newTime.setTime(newMinutes/60%24, newMinutes%60); // %24 for wrapping hours in 0..23 range
		return newTime;
		}
	
	public Time(){
		this.hour = 0;
		this.minute = 00;
	}
	
	public Time(int minute, int hour){
		boolean wasOK = this.setTime(minute, hour);
		
		if (wasOK == false){
			System.out.println("Setting time to 0:00");
			this.setTime(0, 00);
		}
	}
	
	
	/* 
	 * This is a program that tests the functionality of the Time class. It is for our own debugging purposes.
	 * The actual client code would be written in a different class.
	 * Similarly, you should have a main to test out the functionality of your methods.
	 */
	public static void main(String[] args) {

		// Testing values - we can just hard code some values here to test out our methods.
		// Test by changing the values here and seeing if the output is correct
		int addMin = 30;
		int t1Hr = 17, t2Hr = 3, t1Min = 45, t2Min = 30;
		
		Time t1 = new Time();
		Time t2 = new Time();
	
		t1.setTime(t1Hr, t1Min);
		t2.setTime(t2Hr, t2Min);
		
		System.out.println("t1.hour is: " + t1.hour);
		System.out.println("t1.minute is: " + t1.minute);

		System.out.println("t2.hour is: " + t2.hour);
		System.out.println("t2.minute is: " + t2.minute);
		
		System.out.println("t1 hour is:  " + t1.getHour() + "   and t1 minute is: " + t1.getMinute());
		System.out.println("t2 hour is:  " + t2.getHour() + "   and t2 minute is: " + t2.getMinute());

		System.out.println("t1 time in minutes is:  " + t1.toMinutes());
		System.out.println("t2 time in minutes is:  " + t2.toMinutes());

		System.out.println("t1 AM/PM time is:  " + t1.getAMPMTime());
		System.out.println("t2 AM/PM time is:  " + t2.getAMPMTime());

		System.out.println("t1 plus " + addMin + " minutes is " + t1.timeAfter(addMin).getAMPMTime());
		System.out.println("t2 plus " + addMin + " minutes is " + t2.timeAfter(addMin).getAMPMTime());
		
	}

}