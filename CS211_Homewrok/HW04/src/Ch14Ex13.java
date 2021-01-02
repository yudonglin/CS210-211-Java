/* CS211 Yudong Lin 
 * HW04
 * 2 May 2020
 * Write a method that accepts a stack of integers as a parameter and make
 * sure that the stack's elements are in nondecreasing oder from top to bottom
 */
import java.util.*;
public class Ch14Ex13 {
	public static void main(String[] args) {
		//create the Stack
		Stack<Integer> testStack = new Stack<Integer>();
		testStack.push(4);
		testStack.push(20);
		testStack.push(15);
		testStack.push(15);
		testStack.push(8);
		testStack.push(5);
		testStack.push(7);
		testStack.push(12);
		testStack.push(3);
		testStack.push(10);
		testStack.push(5);
		testStack.push(1);
		//check the Stack value
		System.out.println("original Stack: "+testStack);
		expunge(testStack);
		System.out.println("new Stack: "+testStack);

	}
	public static void expunge(Stack<Integer> q) {
		Stack<Integer> auxiliaryStorage = new Stack<Integer>();
		//make sure q's size is bigger than 1
		if (q.size()>1){
			auxiliaryStorage.push(q.pop());
			while (!q.isEmpty()) {
		        int next = q.pop();
		      //check whether the next is bigger
		        if (next>=auxiliaryStorage.peek()) {
		        	auxiliaryStorage.push(next);
		        }
		    }
			//put the number back
			while (!auxiliaryStorage.isEmpty()) {
		        q.push(auxiliaryStorage.pop());
		    }
		}
	}

}
