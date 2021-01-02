package final_test_test;

import java.util.ArrayList;

class student {
	  int id=0;
	  String name="";
	  String gender="";
	  
	  student() {
	    System.out.println(id + " " + name + " " + gender);
	  }
	    
	  student(int i, String n, String g) {
	    id=i;
	    name=n;
	    gender=g;
	    System.out.println(id + " " + name + " " + gender);
	 }
	}

public class testing_file {
		public static void main(String[] args) {
		  student s1 = new student(1, "Chloe", "FeMale");
		  student s2 = new student();
		}
}
