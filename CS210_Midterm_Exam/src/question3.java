import java.util.Scanner;
import java.util.Random;
/*
1) Yudong Lin
2) If there is any problem, please submit in here: https://github.com/yoshino-lin
3) 950697081
4) 2/15/2019
5) This is a small math game.
*/
public class question3 {
	public static Scanner console = new Scanner(System.in);
	public static final Random random = new Random();
	public static void main(String[] args) {
		int game = 1;
		while(game == 1) {
			//operator checker
			String oprator_retun;
			while(true) {
				System.out.print("choose one operator from +, -, *, /.");
				String operator_input = console.next();
				if(operator_input.equals("+")){
					oprator_retun = "+";
					break;
				}else if(operator_input.equals("-")){
					oprator_retun = "-";
					break;
				}else if(operator_input.equals("*")) {
					oprator_retun = "*";
					break;
				}else if(operator_input.equals("/")) {
					oprator_retun = "/";
					break;		
				} else {
					System.out.println("Erro! Please try again!");
				}
			}
			//number checker
			int number_in_1;
			int number_in_2;
			while(true){
				System.out.print("Please enter the first number:");
				number_in_1 = console.nextInt();
				System.out.print("Please enter the seconde number:");
				number_in_2 = console.nextInt();
				if(number_in_1 == 0 || number_in_2 == 0 || number_in_1 == number_in_2) {
					System.out.println("Erro! Please try again!");
				}else {
					break;
				}
			}
			//set upper and lower bound
			int ub = 0;
			int lb = 0;
			if(number_in_1 > number_in_2) {
				ub = number_in_1;
				lb = number_in_2;
			}else if(number_in_1 < number_in_2) {
				lb = number_in_1;
				ub = number_in_2;
			}
			//random two numbers
			int number_cal_1 = random.nextInt(ub-lb+1)+lb;
			int number_cal_2 = random.nextInt(ub-lb+1)+lb;
			// question asking
			int try_time = 1;
			while(true){
				int real_answer = math(oprator_retun,number_cal_1,number_cal_2);
				if(oprator_retun == "+") {
					System.out.print(number_cal_1+" + "+number_cal_2+" = ");
				}else if(oprator_retun == "-") {
					System.out.print(number_cal_1+" - "+number_cal_2+" = ");
				}else if(oprator_retun == "*") {
					System.out.print(number_cal_1+" * "+number_cal_2+" = ");
				}else if(oprator_retun == "/") {
					System.out.print(number_cal_1+" / "+number_cal_2+" = ");
				}
				int user_answer = console.nextInt();
				if (real_answer == user_answer) {
					System.out.println("You are right!");
					break;
				}else if(try_time ==3) {
					System.out.println("The answer is "+real_answer+", study more!");
					break;
				}else{
					System.out.println("Wrong answer, please try again.");
				}
			}
			System.out.print("Play again? ");
			String play_gain = console.next().toUpperCase();
			if(play_gain.equals("Y")){
				//do nothing?
			}else if(play_gain.equals("N")){
				System.out.print("good bye!");
				game = 0;
			}
		}
		
	}
	public static int math(String operator,int a,int b){
		int answer_return = 0;
		if(operator.equals("+")){
			answer_return = a+b;
		}else if(operator.equals("-")){
			answer_return = a-b;
		}else if(operator.equals("*")) {
			answer_return = a*b;
		}else if(operator.equals("/")) {
			answer_return = a/b;
		}
		return answer_return;
	}
}
