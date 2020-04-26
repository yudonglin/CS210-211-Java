/* CS211 Yudong Lin 
 * HW03
 * 25 April 2020
 * Write a method that accepts a list of integers as its parameter and rearranges
 * the list's elements into sorted ascending order, as well as removing all duplicate
 *  values from the list
 */
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Ch11Ex05 {
	public static Set<Integer> sortAndRemoveDuplicates(List<Integer> theList){
		//Use TreeSet so the set will be sorted
		Set<Integer> sortedSet = new TreeSet<Integer>();
		//loop through the list input
		if (theList.size()>0){
			for(int elementValue:theList) {
				//if the set does not contain the value
				if (!sortedSet.contains(elementValue)) {
					//then add the value
					sortedSet.add(elementValue);
				}
			}
		}
    	return sortedSet;
	}
}
