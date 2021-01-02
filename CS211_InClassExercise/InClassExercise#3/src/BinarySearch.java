/* CS211 Yudong Lin 
 * In-Class Exercise #3
 * 27 April 2020
 * Returns the index of an occurrence of target in a,
 * or a negative number if the target is not found.
 * Precondition: elements of a are in sorted order
 */
import java.util.*;

public class BinarySearch {

	public static void main(String[] args) {
		int[] theList = new int[] {22,33,11,4433,2123,111,15,67};
		System.out.println(Arrays.toString(theList));
		int mum = 30;
		System.out.println(binarySearch(theList,mum));
	}
	
	public static int binarySearch(int[] a, int target) {
	    int min = 0;
	    int max = a.length - 1;
	    //sort array
	    Arrays.sort(a);
	    //System.out.println(Arrays.toString(a));

	    while (min <= max) {
	        int mid = (min + max) / 2;
	        if (a[mid] < target) {
	            min = mid + 1;
	        } else if (a[mid] > target) {
	            max = mid - 1;
	        } else {
	            return mid;   // target found
	        }
	    }
	    return -(min + 1);    // target not found
	}
}
