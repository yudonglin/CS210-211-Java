/* CS211 Yudong Lin 
 * HW06
 * 16 May 2020
 * Chapter 16, do exercises 8 and 12 on page 1023
 */

public class ListClient {
    public static void main(String[] args) {
    	
    	System.out.println("Question 8:");
    	// initialize the list
    	LinkedIntList list1 = new LinkedIntList();
        processList1(list1);
        // print the list before switchPairs
        System.out.println("List before switchPairs: "+list1.toString());
        // switchPairs the list
        list1.switchPairs();
        // print the list after switchPairs
        System.out.println("List after switchPairs: "+list1.toString());
        
        System.out.println("Question 12:");
        // initialize the list
        LinkedIntList list2 = new LinkedIntList();
        processList2(list2);
        // print the list before split
        System.out.println("List before split: "+list2.toString());
        // split the list
        list2.split();
        // print the list after split
        System.out.println("List after split: "+list2.toString());
        
    }
    
    //add the elements into the list
    public static void processList1(IntList list) {
        list.add(10);
        list.add(25);
        list.add(31);
        list.add(47);
        list.add(52);
        list.add(68);
        list.add(77);
    }
    public static void processList2(IntList list) {
        list.add(8);
        list.add(7);
        list.add(-4);
        list.add(19);
        list.add(0);
        list.add(43);
        list.add(-8);
        list.add(-7);
        list.add(2);
    }
}
