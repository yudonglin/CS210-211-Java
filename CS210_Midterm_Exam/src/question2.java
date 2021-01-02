import java.util.Scanner;
/*
1) Yudong Lin
2) If there is any problem, please submit in here: https://github.com/yoshino-lin
3) 950697081
4) 2/15/2019
5) This is a Java program that calculates sales price.
*/
public class question2 {
	public static Scanner console = new Scanner(System.in);
	public static void main(String[] args) {
		String id_input;
		boolean running = true;
		while(running == true) {
			while(true) {
				System.out.print("ID? ");
				id_input = console.next();
				if(id_input.length() == 1 && id_input.charAt(0) == '0') {
					System.out.print("Good Bye!");
					running = false;
					break;
				}else if(id_input.length() == 5 && id_input.charAt(id_input.length()-1) == 'F' || id_input.charAt(id_input.length()-1) == 'M') {
					break;
				}else {
					System.out.println("Wrong ID, please input ID again.");
				}
			} //check whether the id is right now is done
			if(running == true) {
				System.out.print("Price? ");
				double price_input = console.nextDouble();
				
				double you_pay = pay(price_input,id_input);
				System.out.println("You pay : "+you_pay);
			}
		}
	}
	public static double pay(double price, String id) {
		double your_pay_return = 0;
		if(id.charAt(0) == 'A') {
			your_pay_return = price * (0.9);
		}else if (id.charAt(0) == 'B') {
			your_pay_return = price * (0.95);
		}else{
			your_pay_return = price;
		}
		return your_pay_return;
	}

}
