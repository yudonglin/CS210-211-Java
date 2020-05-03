/* CS211 Yudong Lin 
 * In-Class Exercise #4
 * 1 May 2020
 */
import java.util.*;

public class CopyStack {
	public static Stack<Integer> copyStack(Stack<Integer> originalStack) {
		Queue<Integer> backup = new LinkedList<Integer>();
		Stack<Integer> newCopy = null;
		for(var i =0;i<2;i++) {
			newCopy = new Stack<Integer>();
			while (!originalStack.isEmpty()) {
		        int next = originalStack.pop();
		        backup.add(next);
		    }
		    while (!backup.isEmpty()) {
		    	int next = backup.remove();
		    	originalStack.push(next);
		    	newCopy.push(next);
		    }
		}
	    return newCopy;
	}
}
