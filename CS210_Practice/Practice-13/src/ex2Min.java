import java.util.Arrays;   

public class ex2Min {  
	public static int min(int[] list) {
		int min_num = list[0];
		for (int i=1; i<list.length; i++) {
			if(list[i]<min_num) {
				min_num = list[i];
			}
		}
		return min_num;
	}

	public static void main(String[] args) {     
		int[] myArray = new int[]{10, 20, 30, 40, -50, 60, 70};  
		int s= min(myArray);
		System.out.println("Original Array: " + Arrays.toString(myArray));  
		System.out.println("Min of the array = " + s); 
	}
}
