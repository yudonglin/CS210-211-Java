import java.util.Scanner;
/*
1) Yudong Lin
2) If there is any problem, please submit in here: https://github.com/yoshino-lin
3) 950697081
4) 2/15/2019
5) This is a Java program that calculates and print out sales price(including tax).
*/
public class question1 {
	public static Scanner console = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Price?");
		double price_input = console.nextInt();
		System.out.print("Tax(%)?");
		double tax_input = console.nextDouble();
		System.out.print("Age?");
		int age_input = console.nextInt();
		double your_pay = pay(price_input,tax_input,age_input);
		System.out.println("You pay :"+your_pay);
	}
	public static double pay(double price, double tax, int age) {
		double your_pay_return = 0;
		if(age<=55) {
			your_pay_return = price * (1+tax/100);
		}else if (age>55 && age<=60) {
			your_pay_return = price * (1+tax/100) * 0.95;
		}else if (age>60) {
			your_pay_return = price * (1+tax/100) * 0.9;
		}else{
			System.out.print("Erro!");
		}
		return your_pay_return;
	}

}
