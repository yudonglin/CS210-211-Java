import java.util.Scanner;

public class Bonus_String {
	public static Scanner console = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("What's your gender?");
		String gender_input = console.nextLine();
		
	    gender_input = gender_input.toLowerCase();
	    char gender_input_check = gender_input.charAt(0);
	    
	    if(gender_input_check == 'm'&&gender_input != "male" ) {
			System.out.println("Do you mean 'male'?");
	    }else if(gender_input_check == 'f'&&gender_input != "female" ) {
			System.out.println("Do you mean 'female'?");
	    }
	    
		if (gender_input_check == 'm') {
		System.out.println("You are a girl.");
		} else if (gender_input_check == 'f') {
		System.out.println("You are a boy.");
		} else {
			System.out.println("I have not idea what is your gender");
		}
	}

}
