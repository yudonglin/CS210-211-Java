/* CS211 Yudong Lin 
 * HW07
 * 24 May 2020
 * Chapter 12 question 6
 */

public class HW07Ex06 {
	
	public static void main(String[] args) {
		// this method takes an positive integer as a parameter
		writeSquares(8);
		System.out.println();
		writeSquares(1);
	}
	
	// this method takes an positive integer n as a parameter and prints the first
	// n squares separated by commas, with the odd squares in descending order followed
	// by the even squares in ascending order
	public static void writeSquares(int n) {
		if(n>0) {
			// so, the first thing we need to do is printing out the odd squares
			// while we are doing the recursion at the same thing
			if(n%2!=0) {
				// print the odd squares
				System.out.print(n*n);
				// print a comma after the odd squares until the number is 1.
				if(n!=1) {
					System.out.print(", ");
				}
			}
			// make sure n is bigger than 1 so the recursion can stop before touching the IllegalArgumentException
			if(n > 1){
				// after printing out the odd square for this layer, do the recursion to go to the next layer
				writeSquares(n-1);
			}
			// now we are on the deepest layer of the recursion, so when we come out
			// we need to print the even squares at the same time
			if(n%2==0) {
				// print a comma before the even squares (so when n is 1, the result will not be "1," )
				System.out.print(", ");
				// print the even squares
				System.out.print(n*n);
			}
		}else {
			// throw an IllegalArgumentException if passed a value less than 1;
			throw new IllegalArgumentException("Number has to be bigger than 0: " + n);
		}
	}
}
