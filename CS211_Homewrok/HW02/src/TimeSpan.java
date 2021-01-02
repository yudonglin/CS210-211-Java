// CS211 Yudong Lin 
// HW02
// 18 April 2020
/* 
 * Your file header comment block goes above this line.
 *
 * Adapted for CS211 from Building Java Programs, 4th Edition,
 * by Stuart Reges and Marty Stepp
 * adapted by James Livingston, Bellevue College Adjunct Instructor
 */
// Represents a time span of elapsed hours and minutes.
// Simple implementation using only total minutes as state.
public class TimeSpan implements Comparable<TimeSpan> {
   private int totalMinutes;

   // Constructs a time span with the given interval.
   // pre: hours >= 0 && minutes >= 0
   public TimeSpan(int hours, int minutes) {
      totalMinutes = 0;
      add(hours, minutes);
   }
   
   // Adds the given interval to this time span.
   // pre: hours >= 0 && minutes >= 0
   public void add(int hours, int minutes) {
      totalMinutes += 60 * hours + minutes;
   }

   // Returns a String for this time span such as "6h15m".
   public String toString() {
      return (totalMinutes / 60) + "h"
             + (totalMinutes % 60) + "m";
   }
   
	@Override
	public int compareTo(TimeSpan other) {
		if (this.totalMinutes > other.totalMinutes) {
			return 1;
		}else if (this.totalMinutes < other.totalMinutes) {
			return -1;
		}else {
			return 0;
		}
	}
}
