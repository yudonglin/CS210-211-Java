import java.util.*;   

public class ex1Sum {  
	public static int sum(int[] list) {
		int total = 0;
		for (int i=0; i<list.length; i++) {
			total +=  list[i];
		}
		return total;
	}

	public static void main(String[] args) {     
	    int[] myArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  
	    int s= sum(myArray);
	    System.out.println("Original Array: " + Arrays.toString(myArray));  
	    System.out.println("Sum of the array = " + s); 
	 }
}
