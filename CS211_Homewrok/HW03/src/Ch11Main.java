// CS211 Yudong Lin 
// HW03
// 25 April 2020
// test client
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Ch11Main {
	public static void main(String[] args) {
		//testCLient for ex05
		List<Integer> realList = new ArrayList<Integer>(Arrays.asList(7, 4, -9, 4, 15, 8, 27, 7, 11, -5, 32, -9, -9));
		System.out.println("ex5-the list before process by the method: "+realList);
		//print the set which is sorted
		System.out.println("ex5-the list after process by the method: "+Ch11Ex05.sortAndRemoveDuplicates(realList));
		
		//testCLient for ex11
		//Initial the list1
		Set<Integer> testSet1 = new HashSet<Integer>();
		testSet1.add(1);
		testSet1.add(4);
		testSet1.add(7);
		testSet1.add(9);
		//Initial the list2
		Set<Integer> testSet2 = new HashSet<Integer>();
		testSet2.add(2);
		testSet2.add(4);
		testSet2.add(5);
		testSet2.add(6);
		testSet2.add(7);
		//check the value of two sets
		System.out.println("ex11-the list1: "+testSet1);
		System.out.println("ex11-the list2: "+testSet2);
		//print the unique numbers
		System.out.println("ex11-the unique numbers of two list: "+Ch11Ex11.symmetricSetDifference(testSet1,testSet2));
		
		//testCLient for ex15
		List<Integer> templist = new ArrayList<Integer>(); //Initial the list
		Random random = new Random(); //Initial random object
		int minNum = 0; //The smallest value
		int maxNum = 10; //The highest value
		int listLen = 30; //The length of the list
		for(int i=0;i<listLen;i++) {
			templist.add(random.nextInt(maxNum - minNum + 1) + minNum);
		}
		//print the list
		System.out.println("ex15-the list needs to check: "+templist);
		//print the number of times
		System.out.println("ex15-The most frequent number appears "+Ch11Ex15.maxOccurrences(templist)+" times");
	}
}
