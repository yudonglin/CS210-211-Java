/* CS211 Yudong Lin 
 * HW09
 * 6 June 2020
 * Chapter 18 question 1, 2, 3, 9, 11
 */
import java.util.PriorityQueue;
import java.util.Stack;

public class HW09Client {

	public static void main(String[] args) {
		// Initialize two HashIntSets for testing
		HashIntSet set1 = new HashIntSet();
        HashIntSet set2 = new HashIntSet();
        
        //----- question 1 starts from here -----
        // add values into the first HashIntSet
        set1.add(-5);
        set1.add(1);
        set1.add(2);
        set1.add(3);
     	// add values into the second HashIntSet
        set2.add(2);
        set2.add(3);
        set2.add(6);
        set2.add(44);
        set2.add(79);
        // print out the values in two HashIntSets to check
        // whether the values are added correctly.
        System.out.println("The values in set1 for question1: "+set1.toString());
        System.out.println("The values in set2 for question1: "+set2.toString());
        // add the values in set2 into set 1
        set1.addAll(set2);
        // print out the values in set1 after doing addAll
        System.out.println("The values in set1 after being added the values in set2: "+set1.toString());
        System.out.println();
        //----- question 1 ends here -----
        
        //Initialize two HashIntSets
        set1.clear();
        set2.clear();
        
        //----- question 2 starts from here -----
        // add values into the first HashIntSet
        set1.add(-2);
        set1.add(3);
        set1.add(5);
        set1.add(6);
        set1.add(8);
        // add values into the second HashIntSet
        set2.add(3);
        set2.add(6);
        set2.add(8);
        //set2.add(7); // set1.containsAll(set2) == False
        // print out the values in two HashIntSets to check
        // whether the values are added correctly.
        System.out.println("The values in set1 for question2: "+set1.toString());
        System.out.println("The values in set2 for question2: "+set2.toString());
        // check whether set1 contains all elements which set2 has.
        System.out.println("?Did set1 catains all elements in set2: "+set1.containsAll(set2));
        System.out.println();
        //----- question 2 ends here -----
        
        //----- question 3 starts from here -----
        // I will keep using the set1 in question 2
        // So I will only initialize the set2
        set2.clear();
        // add the same values in set1 but different order
        set2.add(8);
        set2.add(5);
        set2.add(-2);
        set2.add(6);
        set2.add(3);
        // print out the values in two HashIntSets to check
        // whether the values are added correctly.
        System.out.println("The values in set1 for question3: "+set1.toString());
        System.out.println("The values in set2 for question3: "+set2.toString());
        // check whether they are equal
        System.out.println("?Whether set1 euqlas to set2: "+set1.equals(set2));
        System.out.println();
        //----- question 3 ends here -----
        
        // Initialize a PriorityQueue for question 9 and 11
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        //----- question 9 starts from here -----
        // add values into PriorityQueue for testing
        pq.add(42);
        pq.add(50);
        pq.add(45);
        pq.add(78);
        pq.add(61);
        // print out the values in the PriorityQueue to check
        // whether the values are added correctly.
        System.out.println("The original PriorityQueue for question9: "+pq.toString());
        // please set the index here
        int k = 4;
        System.out.println("The "+k+"th smallest number in the PriorityQueue: "+kthSmallest(pq,k));
        System.out.println("The values in PriorityQueue after processing"
        		+ "kthSmallest in question 9: "+pq.toString());
        System.out.println();
        //----- question 9 ends here -----
     
        // Initialize the PriorityQueue for next question
        pq.clear();
        
        //----- question 11 starts from here -----
        // add values into PriorityQueue for testing
        pq.add(7);
        pq.add(7);
        pq.add(8);
        pq.add(8);
        pq.add(8);
        pq.add(10);
        pq.add(45);
        pq.add(45);
        // print out the values in the PriorityQueue to check
        // whether the values are added correctly.
        System.out.println("The original PriorityQueue for question11: "+pq.toString());
        // processing "removeDuplicates" method
        removeDuplicates(pq);
        // Show the results
        System.out.println("The values in PriorityQueue after processing"
        		+ " removeDuplicates in question 11: "+pq.toString());
        //----- question 11 ends here -----
	}
	
	// This method accepts a PriorityQueue of integers and an integers k as parameters
	// and returns the kth-smallest integer from the priority queue
	public static int kthSmallest(PriorityQueue<Integer> pq, int k) {
		// throw IllegalArgumentException if k is out of boundary
		if (k<=0) {
			throw new IllegalArgumentException("Index k has to be bigger than 0: " + k);
		}else if (k>pq.size()) {
			throw new IllegalArgumentException("Index " + k + " out of bounds for length " + pq.size());
		}else {
			// Initialize a Stack for temporary storage
			Stack<Integer> tempStorage = new Stack<Integer>();
			// add all value into the tempStorage
			for(int num:pq) {
				// The reason I use iterator is because I want to make sure that
				// I will add the value base on original order instead of from small to big 
				tempStorage.add(num);
			}
			// initialize NUM to store the k-th smallest value
			int NUM = 0 ;
			// Since the size of PriorityQueue will change after removing the values,
			// I have to start from size to 0. As a result,
			// it is a smart move to calculate the index in the first place
			int theIndex = pq.size()-k+1;
			
			//i will start from size to 0
			for(int i=pq.size();i>0;i--) {
				// if i equals to the index, than we find the k-th smallest value
				if (i == theIndex) {
					// Set NUM to that number
					NUM = pq.poll();
				}else {
					// remove all the elements from original PriorityQueue one by one
					pq.poll();
				}
			}
			
			// now the original PriorityQueue is empty
			// let us add the values back in order
			for(int num:tempStorage) {
				pq.add(num);
			}
			
			//return the k-th smallest number
			return NUM;
		}
	}
	
	// This method accepts a PriorityQueue of integers as a parameter and modifies
	// the queue's state so that any element that is equal to another element in
	// the queue is removed
	public static void removeDuplicates(PriorityQueue<Integer> pq) {
		// Initialize a Stack for temporary storage
		Stack<Integer> tempStorage = new Stack<Integer>();
		// Again, the reason I use iterator is because I want to make sure that
		// I will add the value base on original order instead of from small to big 
		for(int num:pq) {
			// Check whether the value has already been added
			if(!tempStorage.contains(num)) {
				// if not, then go ahead and add it!!
				tempStorage.add(num);
			}
		}
		// remove all the elements in PriorityQueue
		pq.clear();
		// add the value back from tempStorage Stack
		for(int num:tempStorage) {
			pq.add(num);
		}
		
		// OK, this is a void method£¬ right?
		// So for sure I will not return anything!
	}
}
