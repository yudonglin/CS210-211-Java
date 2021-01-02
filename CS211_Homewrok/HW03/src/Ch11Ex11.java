/* CS211 Yudong Lin 
 * HW03
 * 25 April 2020
 * Write a method that accepts two sets as parameters and returns a new set
 * containing their symmetric set difference.
 */
import java.util.Set;
import java.util.TreeSet;

public class Ch11Ex11 {
	public static Set<Integer> symmetricSetDifference(Set<Integer> list1, Set<Integer>list2) {
		//Use TreeSet so the set will be sorted
		Set<Integer> sortedSet = new TreeSet<Integer>();
		//loop list1 first and find out the unique number
		for(int intValue1:list1) {
			if(!list2.contains(intValue1)) {
				sortedSet.add(intValue1);
			}
		}
		//then loop list2 to make sure I do not miss any number
		for(int intValue2:list2) {
			if(!list1.contains(intValue2)) {
				sortedSet.add(intValue2);
			}
		}
    	return sortedSet;
	}
}
