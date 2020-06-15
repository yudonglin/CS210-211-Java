import java.util.Arrays;
import java.util.Random;

/* CS211 Yudong Lin 
 * Final Project
 * 14 June 2020
 * Chapter 15 Page 974, #4
 */

public class TestClient {

	public static void main(String[] args) {
		// initialize the SortedIntList
		SortedIntList theList = new SortedIntList();
		
		
		// set the amount of elements that you plan to put inside the SortedIntList;
		int lenOfarray = 10;
		
		for (int a=0;a<100;a++) {
			theList.clear();
			int[] comparison = new int[10];
			
			Random r = new Random();
			for (int i=0;i<lenOfarray;i++) {
				//System.out.println("The SortedIntList: "+theList.toString());
				int num = r.nextInt(100);
				theList.add(num);
				comparison[i] = num;
			}
			Arrays.sort(comparison);
			if (!theList.euqlas(comparison)) {
				System.out.println("Erro");
			}
		}
		
		// you also can add the value with add method
		theList.add(0);
		
		
		// set the parameter for indexOf() here
		int tempValue = 18;
		
		// print all the elements in the SortedIntList
		System.out.println("The SortedIntList: "+theList.toString());
		
		// does the SortedIntList contain tempValue
		boolean ifContain = theList.contains(tempValue);
		
		// print the result
		System.out.println("Does the SortedIntList contain number "+tempValue+": "+ifContain);
		if (ifContain == true) {
			System.out.println("And its index is: "+theList.indexOf(tempValue));
		}

	}
}
