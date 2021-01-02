/* CS211 Yudong Lin 
 * HW05
 * 9 May 2020
 * page 970 of Chapter 15, exercises 1, 2, 5, 8, and 11. 
 */

public class TestClient {

	public static void main(String[] args) {
		ArrayIntList testList = new ArrayIntList();
		
		//test client for question 1
		//setup the testList
		int[] q1example = {1,18,2,7,18,39,18,40};
		testList.addList(q1example);
		System.out.println("The ArrayIntList for q1: "+testList.toString());
		System.out.println("The last index of 18: "+testList.lastIndexOf(18));
		System.out.println("The last index of 3: "+testList.lastIndexOf(3));
		//clean the mass
		testList.clear();
		
		System.out.println("-------------------");
		
		//test client for question 2
		//set the value of ArrayIntList object testList
		ArrayIntList list2 = new ArrayIntList();
		ArrayIntList list3 = new ArrayIntList();
		
		int[] q2example1 = {11,-7,3,42,0,14};
		int[] q2example2 = {3,42,0};
		int[] q2example3 = {0,14,3};
		testList.addList(q2example1);
		list2.addList(q2example2);
		list3.addList(q2example3);
		System.out.println("The ArrayIntList testList for q2: "+testList.toString());
		System.out.println("The ArrayIntList list2 for q2: "+list2.toString());
		System.out.println("The ArrayIntList list3 for q2: "+list3.toString());
		//check if testList contain list2 or list3
		System.out.println("Index if cotain list2: "+testList.indexOfSubList(list2));
		System.out.println("Index if cotain list3: "+testList.indexOfSubList(list3));
		//clean the mass
		testList.clear();
		
		System.out.println("-------------------");
		
		//test client for question 5
		//setup the testList
		int[] list4 = {2,3,5,4,7,15,20,7};
		testList.addList(list4);
		System.out.println("The original list for q5: "+testList.toString());
		//make a new ArrayIntList copy named list5
		ArrayIntList list5 = testList.runningTotal();
		//check whether the original ArrayIntListchanged
		System.out.println("The original list after runningTotal: "+testList.toString());
		//print the new list's values.
		System.out.println("The new list: "+list5.toString());
		//clean the mass
		testList.clear();
		
		System.out.println("-------------------");
		
		//test client for question 8
		int[] list6 = {2,-3,2,0,5,2,2,6};
		testList.addList(list6);
		//set the number you want to search here
		int numToSearch = 2;
		System.out.println("The original list for q8: "+testList.toString());
		System.out.println("The number "+numToSearch+" appear "+testList.count(numToSearch)+" times.");
		//clean the mass
		testList.clear();
		
		System.out.println("-------------------");
		
		//test client for question 11
		int[] list7 = {8,17,42,3,8};
		testList.addList(list7);
		System.out.println("The original list for q11: "+testList.toString());
		//Use the for loop ... but not for each
		for(int i=testList.size()-1;i>=0;i--) {
			System.out.println("The popped value: "+testList.removeLast());
			System.out.println("How many elements left: "+testList.size());
		}
		//Now the ArrayIntList is empty, the following code will cause NoSuchElementException
		//System.out.println("The popped value: "+testList.removeLast());
	}
}
