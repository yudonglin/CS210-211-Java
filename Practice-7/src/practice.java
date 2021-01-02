import java.util.*;

public class practice {
	public static Random rand = new Random();
	public static Scanner console = new Scanner(System.in);
	public static void main(String[] args) {
		while (true) {
			int f = rand.nextInt(10) + 0;
			int s = rand.nextInt(10) + 0;
			int sum = f + s;
			System.out.print(f+" + "+s+" = ");
			int answer_input = console.nextInt();
			if ( answer_input == sum) {
				break;
			} else{
				System.out.println(f+" + "+s+" = "+sum+", Try again.");
			}
		}
		System.out.println("You did a good job!");
	}

}
