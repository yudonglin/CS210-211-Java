/* CS211 Yudong Lin 
 * HW07
 * 24 May 2020
 * Chapter 12 question 5
 */

public class HW07Ex05 {

	public static void main(String[] args) {
		// this method takes an integer as a parameter
		writeBinary(44);
		System.out.println();
		writeBinary(-133);
	}
	
	// this method accepts an integer as a parameter and writes its binary
	// representation to the console.
	public static void writeBinary(int num) {
		// if the number is negative
		if (num<0) {
			// print a "-" at the front
			System.out.print("-");
			// set the number to positive, so the calculation will work just fine
			num = Math.abs(num);
		}
		// get the remainder after num is divided by 2
		int tempNum = num%2;
		// if the number is bigger than 1, use the (int) num/2 to do the recursion again
		if (num > 1) {
			writeBinary((num-tempNum)/2);
		}
		// when num is 1, start to print out the remainder for each layer.
		System.out.print(tempNum);
	}

}
