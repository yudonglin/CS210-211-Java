/* CS211 Yudong Lin 
 * HW07
 * 24 May 2020
 * Chapter 12 question 2
 */

public class HW07Ex02 {

	public static void main(String[] args) {
		// this method takes an positive integer as a parameter
		writeNums(12);
		//writeNums(-1);
	}
	
	// this method takes an positive integer n as a parameter and prints to the
	// console the first n integers starting with 1 in sequential order
	public static void writeNums(int n) {
		// throw an IllegalArgumentException if passed a value less than 1;
		if (n < 1) {
			throw new IllegalArgumentException("Number has to be bigger than 0: " + n);
		}
		// if n is bigger than 1, do the recursion until n is equals to 1
		else if (n > 1) {
			writeNums(n-1);
		}
		// if n is not 1, add a comma for the previous number
		if (n != 1) {
			System.out.print(", ");
		}
		// print out the number the current number. When the recursion is break by else if (n > 1),
		// 1 is the first number get printed.
		System.out.print(n);
	}
}
