/* CS211 Yudong Lin 
 * HW03
 * 25 April 2020
 * Write a method that accepts a list of integers as a parameter and returns the number
 * of times the most frequently occurring integer occurs in the list
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Ch11Ex15 {
	public static int maxOccurrences(List<Integer> theList) {
		//Initial the return value and set to 0
		int maxTimes = 0;
		//Check whether the list is empty or not
		if (theList.size()>0) {
			//Initial HashMap so it is faster to loop
			HashMap<Integer,Integer> mapTemp = new HashMap<>();
			//loop through the list and put the number into the HashMap
			for(int num:theList) {
				//if the map has the key, then the value++
				if (mapTemp.containsKey(num)) {
					mapTemp.put(num,mapTemp.get(num)+1);
				//if the map does not have the key, then add the key with value 1
				}else {
					mapTemp.put(num,1);
				}
			}
			//Check the value of the map
			//System.out.println("ex15-the map data about this list: "+mapTemp);
			
			//Initial Iterator to loop the map
			Iterator<Integer> iter = mapTemp.keySet().iterator();
			//tell the java that key is a Integer
			int key;
			while(iter.hasNext()){
			   key = iter.next();
			   //if the value(times) is bigger than the existing maximum value
			   if (maxTimes < mapTemp.get(key)) {
				   maxTimes = mapTemp.get(key);
			   }
			}
		}
		return maxTimes;
	}
}
