import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
/*
1) Yudong Lin
2) If there is any problem, please submit in here: https://github.com/yoshino-lin
3) 950697081
4) 3/4/2019
4) current quarter: winter
5) This program for a rudimentary (and highly insecure) database for the storage of only the user generated identities
*/
public class UserNames {
	public static final Random random = new Random();
	public static void main(String[] args) throws FileNotFoundException {
		while(true) {
		@SuppressWarnings("resource")
		Scanner console = new Scanner(System.in);
		System.out.print("Please input a filename to load:");
		
		String txt_name = console.nextLine();  //"users.txt";
		ArrayList<String> user_name_list = listUserNames(txt_name);
		System.out.println(""); // a empty line
		boolean check_loop_break = false;
		String new_user_name_in = null;
		while(check_loop_break == false) {
			System.out.print("Create a new user: ");
			new_user_name_in = console.nextLine();
			boolean check_loop_break_0 = check_same(new_user_name_in,user_name_list);
			boolean check_loop_break_1 = check_length(new_user_name_in);
			boolean check_loop_break_2 = check_space(new_user_name_in);
			boolean check_loop_break_3 = check_char(new_user_name_in);
			boolean check_loop_break_4 = check_contain_number(new_user_name_in);
			if(check_loop_break_0 == true&&check_loop_break_1 == true&&check_loop_break_2 == true&&check_loop_break_3 == true&&check_loop_break_4 == true) {
				check_loop_break = true;
			}
		}
		user_name_list.add(new_user_name_in);
		System.out.println("User "+new_user_name_in+" added successfully!");
		System.out.println("");
		System.out.println("List of Usernames");
		PrintStream output = new PrintStream(new File(txt_name));
		for(int i = 0; i<user_name_list.size(); i++) {
			output.println(user_name_list.get(i));
			System.out.println(user_name_list.get(i));
		}
		System.out.println("");
	}
}
	
	public static void loadErroMessages(int number) {
		String [] errMsg = new String[5];
		errMsg[0] = "Duplicate usernames should be disallowed, and the usernames are case sensitive.";
		errMsg[1] = "Usernames must be between 3 and 6 characters in length.";
		errMsg[2] = "Username can¡¯t contain any space.";
		errMsg[3] = "Usernames must start with a letter like [a-z A-Z]";
		errMsg[4] = "Usernames must have at least one number like [0-9]";
		System.out.println(errMsg[number]);
	}
	public static boolean check_same(String newUserName,ArrayList<String>user_name_list) {
		boolean check_loop_break = false;
		for(int i = 0; i<user_name_list.size(); i++) {
			if(newUserName.equals(user_name_list.get(i))) {
				loadErroMessages(0);
				check_loop_break = false;
				break;
			} else {
				check_loop_break = true;
			}
		}	
		return check_loop_break;
	}	
	public static boolean check_length(String newUserName) {
		boolean check_loop_break;
		if (newUserName.length()<3 ||newUserName.length()>6) {
			loadErroMessages(1);
			check_loop_break = false;
		} else {
			check_loop_break = true;
		}
		return check_loop_break;
	}	
	public static boolean check_space(String newUserName) {	
		boolean check_loop_break;
		if(newUserName.contains(" ") == true) {
			loadErroMessages(2);
			check_loop_break = false;
		} else {
			check_loop_break = true;
		}
		return check_loop_break;
	}	
	public static boolean check_char(String newUserName) {		
		boolean check_loop_break;
		char newUserName_c = newUserName.charAt(0);
		if((newUserName_c>='a'&&newUserName_c<='z') || (newUserName_c>='A'&&newUserName_c<='Z')) {
			check_loop_break = true;
		} else {
			loadErroMessages(3);
			check_loop_break = false;
		}
		return check_loop_break;
	}	
	public static boolean check_contain_number(String newUserName) {		
		boolean check_loop_break = false;
		int errm_num = 0;
		for(int i=0; i<10; i++) {
			if(newUserName.contains(i+"") == true) {
				check_loop_break = true;
				errm_num = 0;
				break;
			} else {
				errm_num = 1;
				check_loop_break = false;
			}
		}
		if (errm_num == 1) {
			loadErroMessages(4);
		}
		return check_loop_break;
	}

	@SuppressWarnings("resource")
	public static ArrayList<String> listUserNames(String txt_name) throws FileNotFoundException {
		Scanner file_input = new Scanner(new File(txt_name));
		ArrayList<String> user_name = new ArrayList<String>();
		System.out.println("List of Usernames");
		while (file_input.hasNext()){
			 String name = file_input.next();
			 System.out.println(name);
			 user_name.add(name);
		}
		return user_name;
	}
}
