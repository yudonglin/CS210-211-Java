import java.util.Arrays;
import java.util.Random;

/* CS211 Yudong Lin 
 * Final Project
 * 14 June 2020
 * Chapter 15 Page 974, #4:
 * Based on the implementation of ArayIntlit or Arraylist, write a class SortedIntlist
 * that provides most of the same operations but maintains its elements in sorted order.
 * When a new value is added to the sorted list, rather than appending it to the end of
 * the list, it is place in the appropriate index to maintain sorted order of the overall list.
 */

public class TestClient {

	public static void main(String[] args) {
		// initialize a SortedIntList
		SortedIntList theList = new SortedIntList();
		
		// set the amount of elements that you plan to put inside the SortedIntList;
		int lenOfarray = 10;
		// initialize a random class
		Random r = new Random();
		
		// loop 100 times to make sure that add method is working properly
		for (int a=0;a<100;a++) {
			// first, initialize the SortedIntList
			theList.clear();
			// and an empty array as comparison
			int[] comparison = new int[10];
			// add several random integers into both SortedIntList and comparison
			// you can customize the length above in lenOfarray
			for (int i=0;i<lenOfarray;i++) {
				//random an integer
				int num = r.nextInt(100);
				theList.add(num);
				comparison[i] = num;
			}
			// using Arrays.sort to sort the comparison
			Arrays.sort(comparison);
			// than compare it with the SortedIntList
			// if they are different, the program will print Error
			if (!theList.euqlas(comparison)) {
				System.out.println("Error");
			}
		}
		
		theList.clear();
		
		// you still can add the value with add method
		theList.add(-1);
		theList.add(3);
		theList.add(5);
		theList.add(8);
		theList.add(15);
		theList.add(18);
		theList.add(22);
		theList.add(39);
		theList.add(40);
		theList.add(42);
		theList.add(50);
		theList.add(57);
		theList.add(71);
		theList.add(73);
		theList.add(74);
		
		// set the parameter for indexOf() here
		int tempValue = 42;
		//theList.add(tempValue);
		
		// print all the elements in the SortedIntList
		System.out.println("The SortedIntList: "+theList.toString());
		
		// does the SortedIntList contain tempValue
		boolean ifContain = theList.contains(tempValue);
		
		// print the result
		System.out.println("Does the SortedIntList contain number "+tempValue+": "+ifContain);
		// if contain, than find out its index
		if (ifContain == true) {
			System.out.println("");
			System.out.println("size: "+theList.size());
			System.out.println("And its index is: "+theList.indexOf(tempValue));
		}

	}
}
