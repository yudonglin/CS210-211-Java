import java.util.*;
public class array_practice {
	public static Scanner console = new Scanner(System.in);
	public static final Random random = new Random();
	public static void main(String[] args) {
		int [] number = new int[5];
		for(int i=0 ; i<=4; i++) {
			number[i]=random.nextInt(9);
		}
		int total_num = m1(number);
		double average_number = count_avg(total_num);
		above_age(number,average_number);
	}
	public static int m1(int[] num_in){
		System.out.println("index	number");
		System.out.println("----------------");
		int total_num = 0;
		for(int i=0 ; i<=4; i++) {
			System.out.println(i+"       "+num_in[i]);
			total_num = num_in[i] + total_num;
		}
		return total_num;
	}
	public static double count_avg(int total){
		double avg_num = total/5;
		System.out.println("average = "+avg_num);
		return avg_num;
	}
	public static void above_age(int[] num_in,double average_number){
		System.out.println("");
		System.out.println("above average");
		System.out.println("index	number");
		System.out.println("---------------");
		for(int i=0 ; i<=4; i++) {
			if(num_in[i] > average_number) {
				System.out.println(i+"       "+num_in[i]);
			}
		}
	}
}