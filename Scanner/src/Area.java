import java.util.Scanner;

public class Area {
	public static Scanner console = new Scanner(System.in);
	public static void main(String[] args) {		
		  System.out.println("Type Width");
		  double Wdith = console.nextDouble();
		  System.out.println("Type Height");
		  double Height = console.nextDouble();
		  
		  double sum =  Wdith * Height;
		  System.out.println("The Sum is " + sum);

	}
}
