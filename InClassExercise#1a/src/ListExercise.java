/*
 * Exercise from Chapter 10 slide 28:
 * We start with a working client that will test the method's operation.
 * Task:
 * Write a method, intersect, that accepts two sorted array lists of integers
 * as parameters and returns a new list that contains only the elements that
 * are found in both lists.
*/
import java.util.*;

public class ListExercise {
    public static void main (String[] args) {
        List<Integer> list1 = Arrays.asList(1, 4, 8, 9, 11, 15, 17, 28, 41, 59);
        List<Integer> list2 = Arrays.asList(4, 7, 11, 17, 19, 20, 23, 28, 37, 59, 81);
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        System.out.println("intersect(list1, list2): " + intersect(list1, list2));
    }
    public static ArrayList<Integer> intersect(List<Integer> list1,List<Integer> list2){
    	ArrayList<Integer> containBoth = new ArrayList<Integer>();
    	if (list1.size()<list2.size()) {
    		for (int i=0;i<list1.size();i++) {
    			int num = list1.get(i);
    			if (list2.contains(num)) {
    				containBoth.add(num);
    			}
    		}
    	}else {
    		for (int i=0;i<list2.size();i++) {
    			int num = list2.get(i);
    			if (list1.contains(num)) {
    				containBoth.add(num);
    			}
    		}
    	}
    	return containBoth;
    }
}
