/* CS211 Yudong Lin 
 * HW07
 * 24 May 2020
 * Chapter 12 question 8
 */

public class HW07Ex08 {
	
	public static void main(String[] args) {
		// this method takes an positive integer as a parameter
		int num = 4;
		System.out.print("The product of the first "+num+" even intergers is "+multiplyEvens(4));
	}
	
	// this method returns the product of the first n even integers.
	public static int multiplyEvens(int n) {
		if (n > 0) {
			if(n>1) {
				// so, the first thing i want to do is doing the recursion until n equals to 1.
				// first, we get the result front the last layer, then times it 2n
				// after doing that, return the value to the next top layer.
				return multiplyEvens(n-1)*2*n;
			}else {
				// return 2 (now n=1, so n*2=2) when n==1
				return 2;
			}
		}else{
			// throw an IllegalArgumentException if passed a value less than 1;
			throw new IllegalArgumentException("Number has to be bigger than 0: " + n);
		}
	}
	
}
