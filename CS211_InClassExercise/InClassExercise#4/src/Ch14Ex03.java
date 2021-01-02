/* CS211 Yudong Lin 
 * In-Class Exercise #4
 * 1 May 2020
 */
import java.util.*;

public class Ch14Ex03 {
	public static void main(String[] args) {
		Stack<Integer> theTestStack = new Stack<Integer>();
		for(int i=0;i<10;i++) {
			theTestStack.add(i);
		}
		System.out.println(theTestStack);
		Stack<Integer> aNewCopy = CopyStack.copyStack(theTestStack);
		System.out.println(theTestStack);
		System.out.println(aNewCopy);
	}
}
