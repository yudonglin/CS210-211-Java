
public class loop_exercise_5 {

	public static void main(String[] args) {
		
		int num_out = 1234;
		for (int i = 1; i <= 4; i++) {
			System.out.println(num_out);
			num_out /= 10;
		}
		
		
		System.out.println();
		
		for (int i = 1; i <=4; i++) {
		    for (int a = i; a > 0; a--) {
			    System.out.print(a);
		    }
		    System.out.println();
		}

		System.out.println();
		
		for (int i = 3; i >= 0; i--) {
			for (int a = i; a>= 0; a--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 1; i <= 10; i++) {
			for (int b = i; b > 0; b--) {
				System.out.print("*");
			}
			for (int c = 20-2*i; c > 0; c--) {
				System.out.print(" ");
			}
		    for (int d = 1; d <= i; d++) {
			System.out.print("*");
			}
		System.out.println();
		}
		
		System.out.println();
		
		for (int i = 1; i <= 5; i++) {
			for (int a = 1; a <= 5-i; a++) {
				System.out.print(".");
			}
			for (int b = 1; b <= i; b++) {
				System.out.print(i);
		    }
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 1; i <= 5; i++) {
			for (int a = 1; a <= 5-i; a++) {
				System.out.print(".");
		    }
			System.out.print(i);
			for (int b = 2; b <= i; b++) {
				System.out.print(".");
			}
			System.out.println();
		}
	}

}
