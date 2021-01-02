import java.util.*;

public class scanner_string_parameter_passing {
	public static Scanner console = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Are you a girl?");
		String gender_input = console.nextLine();
        gender_input = gender_input.toLowerCase();

	    if (gender_input.equals("yes") || gender_input.equals("y")) {
			System.out.print("How old are you?");
			String age_input = console.nextLine();
			System.out.println("She is "+age_input+" years old.");
	    } else if (gender_input.equals("no") || gender_input.equals("n")) {
			System.out.print("How old are you?");
			String age_input = console.nextLine();
			System.out.println("He is "+age_input+" years old.");
	    } else if (gender_input.equals("none of above")){
	    	System.out.println("Bye!");
	    } else {
	    	System.out.println("Erro!");
	    }
	}

}
