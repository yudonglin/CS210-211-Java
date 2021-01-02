import java.util.Random;
import java.util.Scanner;
import java.io.*;
/*
1) Yudong Lin
2) If there is any problem, please submit in here: https://github.com/yoshino-lin
3) 2/21/2019
4) current quarter: winter
5) This program will read an external data collection, then report information back to the user based on user inputs.
*/
public class ReadingData {
	public static Scanner console = new Scanner(System.in);
	public static final Random random = new Random();
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		String gender_print = null;
		System.out.print("Please input a filename to load:");
		String txt_name = console.next();
		System.out.println();
		System.out.print("Parse by gender (M/F/f/m):");
		String gender_in = console.next().toLowerCase();
		System.out.println();
		if(gender_in.equals("m")) {
			gender_print = "male";
		}else if(gender_in.equals("f")) {
			gender_print = "female";
		}
		System.out.println("List of "+gender_print+" students:");
		System.out.println("Id	name	age");
		System.out.println("------------------");
		Scanner file_input = new Scanner(new File(txt_name));
		int total_number = 0;
		double total_age = 0;
		double avg_age = 0;
		while (file_input.hasNext()) {
			 int id = file_input.nextInt();
			 String name = file_input.next();
			 String gender = file_input.next();
			 int age = file_input.nextInt();
			 if(gender.equals(gender_in)) {
				 System.out.printf("%d	%s	%d",id,name,age);
				 System.out.println();
				 total_number += 1; //total_number is the value of how many students
				 total_age += age; // total_age is the value of total ages of everyone
			 }
		}
		avg_age = total_age/total_number; //double is needed for accurate result
		System.out.println("There are "+total_number+" "+gender_print+" students.");
		System.out.println("Their average age is "+avg_age+".");
		PrintStream output = new PrintStream(new File("Summary.txt"));
		output.println("There are "+total_number+" "+gender_print+" students.");
		output.println("Their average age is "+avg_age+".");
	}
}
