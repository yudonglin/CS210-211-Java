import java.util.Random;
import java.util.Scanner;
/*
1) Yudong Lin
2) If there is any problem, please hand in here: https://github.com/yoshino-lin/Assignment3-RANDOM-NUMBER-GUESSING
3) 950697081
4) 2/10/2019
5) This is a very basic game about guessing number.
*/
public class GuessingGame {
	public static final Random random = new Random();
	public static final Scanner console = new Scanner(System.in);
	public static void main(String[] args) {
		while(true) {		
			System.out.print("Please input lower bound: ");
			int lb_in = console.nextInt();
			while (lb_in<=0) {
				System.out.println("Lower bound can not be smaller than or equals to 0! Please try again.");
				System.out.print("Please input lower bound: ");
				lb_in = console.nextInt();
			}
			System.out.print("Please input upper bound: ");
			int ub_in = console.nextInt();
			while (ub_in-lb_in<20) {
				System.out.println("The upper bound max big than or equals to "+(lb_in+20)+"! Please try again.");
				System.out.print("Please input upper bound: ");
				ub_in = console.nextInt();
			}
			System.out.print("Do you want computer do self-reports? y/n: ");
			String self_reports = console.next();
			int game;
			int guess_result = 0;
			if(self_reports.equals("y")) {
				game = 2;
			} else {
				game = 1;
			}
			if(game == 2) {
				System.out.print("The number which need to be guess: ");
				guess_result = console.nextInt();
				while (guess_result<=lb_in || ub_in<=guess_result) {
					System.out.println("Erro: Number not in the area, please try again");
					System.out.print("The number which need to be guess: ");
					guess_result = console.nextInt();
				}
			}
			int guess_numer = lb_in + (ub_in-lb_in)/2;
			int guess_min = lb_in;
			int guess_max = ub_in;
			int count_time = 0;	
			while(game == 1) {
				System.out.println("I guess, the answer is "+guess_numer);
				while(true) {
					System.out.print("Your answer is (high, low, correct):");
					String answer_check = console.next();
					answer_check = answer_check.toLowerCase();
					if(answer_check.equals("high")||answer_check.equals("h")) {
						guess_max = guess_numer;
						guess_numer = random.nextInt(guess_max-guess_min)+guess_min;
						//code for testing: System.out.println("当前猜测范围："+guess_max+"到"+guess_min);
						count_time += 1;
						break; //go back to game loop
					}else if(answer_check.equals("low")||answer_check.equals("l")) {
						guess_min = guess_numer;
						guess_numer = random.nextInt(guess_max-guess_min)+guess_min;
						//code for testing: System.out.println("当前猜测范围："+guess_max+"到"+guess_min);
						count_time += 1;
						break; //go back to game loop
					}else if(answer_check.equals("correct")||answer_check.equals("c")) {
						game = 0; //game is over
						break;
					}else {
						System.out.println("Please re-type.");
					}
				}
			}
			while(game == 2) {
				System.out.println("I guess, the answer is "+guess_numer);
				if(guess_numer > guess_result) {
					System.out.println("Ok, the number I guess is too big.");
					guess_max = guess_numer;
					guess_numer = random.nextInt(guess_max-guess_min-1)+guess_min;
					//code for testing: System.out.println("当前猜测范围："+guess_max+"到"+guess_min);
					count_time += 1;
				}else if(guess_numer < guess_result) {
					System.out.println("Ok, the number I guess is too small.");
					guess_min = guess_numer;
					guess_numer = random.nextInt(guess_max-guess_min-1)+guess_min;
					//code for testing: System.out.println("当前猜测范围："+guess_max+"到"+guess_min);
					count_time += 1;
				}else if(guess_numer == guess_result) {
					System.out.println("That is the correct number, right?!");
					game = 0; //game is over
				}
			}
			System.out.println("I am a genius computer!!");
			System.out.println("Total times I guess: "+count_time);
			System.out.print("Play again?");
			String play_gain_check = console.next();
			play_gain_check = play_gain_check.toLowerCase();
			if(play_gain_check.equals("n")||play_gain_check.equals("no")) {
				break;
			}else if(play_gain_check.equals("y")||play_gain_check.equals("yes")) {
				// I do not know... let me leave this part for later...
			}
		}
		System.out.println("Thanks for playing!");
	}
}
