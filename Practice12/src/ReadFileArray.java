import java.io.*;
import java.util.*;
public class ReadFileArray {
	public static Scanner console = new Scanner(System.in);
	public static final Random random = new Random();
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<Integer> age = new ArrayList<Integer>();
		int index = -1;
		int check_num = 0;
		@SuppressWarnings("resource")
		Scanner file_input = new Scanner(new File("nameAge.txt"));
		while (file_input.hasNext()) {
			index++;
			name.add(file_input.next());
			age.add(file_input.nextInt());
		}
		while(true) {
			System.out.print("Please type a age:");
			int age_comp = console.nextInt();
			if(age_comp < 0) {
				break;
			}
			System.out.println("name"+"\t"+"age");
			for(int i = 0; i<=index; i++) {
				if(age.get(i)>=age_comp) {
					System.out.println(name.get(i)+"\t"+age.get(i));
					check_num +=1;
				}
			}
			if(check_num==0) {
				System.out.println("none\tnone");
			}
		}
	}
}