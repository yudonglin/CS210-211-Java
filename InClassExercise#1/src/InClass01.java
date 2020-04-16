import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InClass01 {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Scanner input = new Scanner(new File("Numbers.txt"));
		while (input.hasNextInt()) {
		    int n = input.nextInt();
		    numbers.add(n);
		}
		
		//print all numbers as a arraylist
		System.out.println(numbers);
		
		//print the list of numbers, with a count
		printWithCount(numbers);
		
		//print the average of the list
		double avg = findAvg(numbers);
		System.out.printf("avg: %.2f",avg);
		System.out.println();
		
		//print the maximum number of the list
		int max = findMaxNum(numbers);
		System.out.printf("maximum number: %d",max);
		System.out.println();
		
		//print the minimum number of the list
		int min = findMinNum(numbers);
		System.out.printf("minimum number: %d",min);
		System.out.println();
		
		// Removes all elements with even values from the given list.
		filterEvens(numbers);
		System.out.println(numbers);
		
	}
	private static void printWithCount(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println("id: "+i);
			System.out.println("number: "+list.get(i));
	    }
		
	}
	
	public static void filterEvens(ArrayList<Integer> list) {
	    for (int i = list.size() - 1; i >= 0; i--) {
	        int n = list.get(i);
	        if (n % 2 == 0) {
	            list.remove(i);
	        }
	    }
	}
	
	public static double findAvg(ArrayList<Integer> list) {
		int sum = 0;
		for (int i=list.size()-1; i>= 0; i--) {
	        sum += list.get(i);
	    }
		return (double)sum/list.size();
	}

	public static int findMaxNum(ArrayList<Integer> list) {
		if (list.size()==1){
			return list.get(1);
		}else{
			int maxNum = list.get(list.size()-1);
			for (int i=list.size()-2; i>= 0; i--) {
				if (maxNum < list.get(i)) {
					maxNum = list.get(i);
				}
		    }
			return maxNum;
		}
	}

	private static int findMinNum(ArrayList<Integer> list) {
		if (list.size()==1){
			return list.get(1);
		}else {
			int minNum = list.get(list.size()-1);
			for (int i=list.size()-2; i>= 0; i--) {
				if (minNum > list.get(i)) {
					minNum = list.get(i);
				}
		    }
			return minNum;
		}
	}

}
