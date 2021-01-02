/*
 * Group 1: Jacob Patton, Kevin Akers, Milan Gurung, Yudong Lin
 * CS211
 * 5/24/2020
 * 
 * Made for Group Assignment #2.
 * This is the testing client for the AbstractList class (and its subclasses).
 * It is designed to utilize every method from AbstractClass. 
 * Numerous helper methods are used on each type of list to accomplish this.
*/

// compiler directive to eliminate superfluous warnings.

public class ListClient {

	public static void main(String[] args) {
		
	// Test 1: testing abstract methods with Integer type
		System.out.println("Test 1: ArrayList<Integer>");
		AbstractList<Integer> list1 = new ArrayList<Integer>();	// new ArrayList for test 1
		processTest1(list1);
		
		System.out.println("Test 1: LinkedList<Integer>");
		AbstractList<Integer> list2 = new LinkedList<Integer>(); // new LinkedList for test 1
		processTest1(list2);
	
	// Test 2: further testing abstract methods with Integer type
		System.out.println("Test 2: ArrayList<Integer>");
		AbstractList<Integer> other1 = new ArrayList<Integer>(); // other ArrayList for test 2
		processTest2(list1, other1);
	    
		System.out.println("Test 2: LinkedList<Integer>");
		AbstractList<Integer> other2 = new LinkedList<Integer>(); // other LinkedList for test 2
		processTest2(list2, other2);
	
	// Test 3: testing abstract methods with String type
		System.out.println("Test 3: ArrayList<String>");
		List<String> list3 = new ArrayList<String>(); // new ArrayList for test 3
		processTest3(list3);
		
		System.out.println("Test 3: LinkedList<String>");
		List<String> list4 = new LinkedList<String>(); // new LinkedList for test 3
		processTest3(list4);
		
	//Test 4: Mixing lists together
		bothListsTest(list2, other1);
		
		
	}
	
	// pre : AbstractList<Integer> required
	// post: prints the before & after state of given list; testing add, remove & size methods
	public static void processTest1(List list) {
		list.add(42);
		list.add(18);
		list.add(27);
		list.add(93);
		System.out.println("list before:  " + list);
		System.out.println("size of list: " + list.size());
		list.remove(2); // removes the value 27 at index 2
		list.remove(0); // removes the value 42 at index 0
		System.out.println("list after removal of 27 and 42: " + list);
		System.out.println("new size of list: " + list.size());
		System.out.println();
	}
	
	// pre : any two AbstractList<Integer> required
	// post: adds all the numbers from the given other list to the given first list
	//		 and prints the before & after state of first list; tests addAll, set & get methods
	public static void processTest2(List list, List other) {
		System.out.println("list before:  " + list);
		other.add(11);
		other.add(12);
		other.add(13);
		System.out.println("list to be added to previous list:  " + other);
		list.addAll(other); // adds all numbers of other list to the given main list
		System.out.println("list after addAll:  " + list);
		System.out.println("Value at index 3: " + list.get(3)); // should return 12
		System.out.println("Set value 7 at index 1");
		list.set(1, 7); // should change the value 93 to 7 at index 1
		System.out.println("list after:   " + list);
		System.out.println();
	}
	
	// pre : AbstractList<String> required
	// post: tests adding Strings and methods such as clear(), isEmpty() & contains()
	//		 prints the before & after state of given list
	public static void processTest3(List list) {
		list.add("seatac");
		list.add("everett");
		System.out.println("list before:  " + list);
		list.clear();	// empties the list
		System.out.println("cleared list: " + list);
		booleanTest(list, "everett");	// should return empty list and not contain target string
		list.add("seattle");
		list.add("bellevue");
		list.add("tacoma");
		System.out.println("list after:   " + list);
		booleanTest(list, "seattle");	// should return new list and contain target string
		System.out.println();
	}
	
	// pre : requires AbstractList<String> and String target to search
	// post: prints the boolean test results of the isEmpty() & contains()
	public static void booleanTest(List list, String target) {
		if (list.isEmpty()) {
			System.out.println("list is empty");
		} else {
			System.out.println("list is not empty");
		}
		if (list.contains(target)) {
			System.out.println("list contains \"" + target + "\"");
		} else {
			System.out.println("list does not contain \"" + target + "\"");
		}
	}
	
	//Extra testing client to demonstrate compability between both types of list.
	//It's also extra testing for some of the other methods.
	public static void bothListsTest(List linkedL, List arrayL) {
		System.out.println("Test 4: List Compability, bonus testing");
		System.out.println(linkedL.toString() + " is a linkedlist.");
		System.out.println(arrayL.toString() + " is an arraylist.");
		linkedL.addAll(arrayL);
		System.out.println("Linkedlist after adding arraylist: " + linkedL.toString());
		if (linkedL.contains(11)) {
			System.out.println("list contains \"" + 11 + "\"");
		} else {
			System.out.println("list does not contain \"" + 11 + "\"");
		}
		linkedL.remove(5);
		System.out.println("Linkedlist after removal of index 5: " + linkedL.toString());
		System.out.println("The last element in LinkedList is: " + linkedL.get(linkedL.size() - 1));
		linkedL.clear();
		System.out.println("Linkedlist after being cleared: " + linkedL.toString());
		if (linkedL.isEmpty()) {
			System.out.println("LinkedList is empty");
		} else {
			System.out.println("LinkedList is not empty");
		}
		
	}
}