/* CS211 Yudong Lin 
 * HW04
 * 2 May 2020
 * Write a method that accepts a queue of integers as a parameter
 * and rearranges the order of the values
 */
import java.util.*;

public class Ch14Ex06 {
	public static void main(String[] args) {
		//create the Queue
		Queue<Integer> testQueue = new LinkedList<Integer>();
		testQueue.add(3);
		testQueue.add(5);
		testQueue.add(4);
		testQueue.add(17);
		testQueue.add(6);
		testQueue.add(83);
		testQueue.add(1);
		testQueue.add(84);
		testQueue.add(16);
		testQueue.add(37);
		//check the Queue value
		System.out.println("original queue: "+testQueue);
		rearrange(testQueue);
		//check the new Queue value
		System.out.println("nuw queue: "+testQueue);
	}
	public static void rearrange(Queue<Integer> q) {
		Stack<Integer> auxiliaryStorage = new Stack<Integer>();
		//do it two times so the value of auxiliaryStorage will reverse
		for(int a=0;a<2;a++) {
			//pick out the odd number
			for(int i=q.size();i>0;i--) {
				int next = q.remove();
				if (next%2!=0) {
					auxiliaryStorage.push(next);
				}else {
					//put the number back is the number is even
					q.add(next);
				}
			}
			//put the odd number back
			while (!auxiliaryStorage.isEmpty()) {
		        int next = auxiliaryStorage.pop();
		        q.add(next);
		    }
		}
	}
}
