import java.util.Random;
import java.util.Scanner;
public class random_while_pro {
	public static final Random rand = new Random();
	public static final Scanner console = new Scanner(System.in);
	public static void main(String[] args) {
		int result_out = 0;
		int int_lb_in;
		int int_ub_in;
		String operator_in;
		while (true) {
			while (true) {
				System.out.print("Choose one operator from +,-,*,/ :");
				operator_in = console.next();
				if(operator_in.equals("+")||operator_in.equals("-")||operator_in.equals("*")||operator_in.equals("/")){
					break;
				} else {
					System.out.println("Erro input, please try again!");
				}
			}
			while (true) {
				System.out.print("Please enter a lower bound:");
				int_lb_in = console.nextInt();
				System.out.print("Please enter a upper bound:");
				int_ub_in = console.nextInt();
				if(int_lb_in < int_ub_in) {
					break;
				} else {
				  System.out.println("lower bound must be smaller than upper bound,please try again");
				}
			}
			int rand_number_area_1 = rand.nextInt(int_ub_in-int_lb_in+1) + int_lb_in;
			int rand_number_area_2 = rand.nextInt(int_ub_in-int_lb_in+1) + int_lb_in;
			if(operator_in.equals("+")) {
				result_out = rand_number_area_1+rand_number_area_2;
			} else if(operator_in.equals("-")) {
				result_out = rand_number_area_1-rand_number_area_2;
			} else if(operator_in.equals("*")) {
				result_out = rand_number_area_1*rand_number_area_2;
			} else if(operator_in.equals("/")) {
				result_out = rand_number_area_1/rand_number_area_2;
			}
			System.out.print(rand_number_area_1+" "+operator_in+" "+rand_number_area_2+" = ");
			int user_answer = console.nextInt();
			if(result_out == user_answer) {
				System.out.println("You are right, good job!");
				break;
			} else {
				System.out.println("The answer is:"+result_out+" You are wrong!");
				System.out.println("Please try again");
			}
		}
	}
}
