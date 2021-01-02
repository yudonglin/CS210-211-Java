import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class People {
	
	public class person{
	String type;
	String name;
	String gender;
	int age;
	}
	ArrayList<person>allList = new ArrayList<>();
	People(String f) throws FileNotFoundException{ 
	 readfile(f);
	}
	void readfile(String FileName) throws FileNotFoundException{ 
		@SuppressWarnings("resource")
		Scanner file_input = new Scanner(new File(FileName));
		while(file_input.hasNext()) {
			person p = new person();
			p.type = file_input.next();
			p.name = file_input.next();
			p.gender = file_input.next();
			p.age = file_input.nextInt();
			allList.add(p);
		}
	}
	String s = null;
	char c1 = ' ';
	char c2 = ' ';
	public void list(char c1){
		for(int j = 0; j<allList.size(); j++) {
			if(allList.get(j).name.charAt(0) == Character.toUpperCase(c1)) {
			System.out.print(allList.get(j).type);
			System.out.print(" ");
			System.out.print(allList.get(j).name);
			System.out.print(" ");
			System.out.print(allList.get(j).gender);
			System.out.print(" ");
			System.out.print(allList.get(j).age);
			System.out.println();
			}
		}
	}
	public void list(char c1, char c2){
		for(int j = 0; j<allList.size(); j++) {
			if(allList.get(j).name.charAt(0) == Character.toUpperCase(c1) && allList.get(j).name.charAt(allList.get(j).name.length()-1) == c2) {
				System.out.print(allList.get(j).type);
				System.out.print(" ");
				System.out.print(allList.get(j).name);
				System.out.print(" ");
				System.out.print(allList.get(j).gender);
				System.out.print(" ");
				System.out.print(allList.get(j).age);
				System.out.println();
			}
		}
	}
	public void list(String s, char c2){
			for(int j = 0; j<allList.size(); j++) {
				if(allList.get(j).type.equals(s) && allList.get(j).name.charAt(0) == Character.toUpperCase(c1)){
					System.out.print(allList.get(j).type);
					System.out.print(" ");
					System.out.print(allList.get(j).name);
					System.out.print(" ");
					System.out.print(allList.get(j).gender);
					System.out.print(" ");
					System.out.print(allList.get(j).age);
					System.out.println();
				}
			}	
	}	
	public void list(String s, char c1, char c2){ {
			for(int j = 0; j<allList.size(); j++) {
				if(allList.get(j).type.toLowerCase().equals(s) && allList.get(j).name.charAt(0) == Character.toUpperCase(c1) && allList.get(j).name.charAt(allList.get(j).name.length()-1) == c2) {
					System.out.print(allList.get(j).type);
					System.out.print(" ");
					System.out.print(allList.get(j).name);
					System.out.print(" ");
					System.out.print(allList.get(j).gender);
					System.out.print(" ");
					System.out.print(allList.get(j).age);
					System.out.println();
				}
			}
		}	
			/*
			if(allList.get(j).type.equals("s") && allList.get(j).gender.equals("f")&& allList.get(j).age>i){
				System.out.print(allList.get(j).type);
				System.out.print(" ");
				System.out.print(allList.get(j).name);
				System.out.print(" ");
				System.out.print(allList.get(j).gender);
				System.out.print(" ");
				System.out.print(allList.get(j).age);
				System.out.println();
			}
			*/
	}
}
