import java.util.*;
import java.io.FileNotFoundException;

public class FamilyTest {

 public static void main(String[] args) throws FileNotFoundException {

    
  // instantiate family databases class 
  boolean continueLoop = true;
  familyDatabase r = new familyDatabase("tudor.dat");
  @SuppressWarnings("resource")
  Scanner in = new Scanner(System.in);

  // ask user for person name from scanner 
  while (continueLoop) {
	  System.out.println("Person's name?");
	  String s = in.nextLine();
	  if (s.equalsIgnoreCase("stop") || s.equalsIgnoreCase("s")) { //End sentinel loop
	  		continueLoop = false;
	  		System.out.print("Exiting database.");
	  } else {
		  Person that_Person = r.getPerson(s);
		  if (that_Person != null) {
			  that_Person.showDetials();
		  }else {
			  System.out.println("cannot find this person");
		  }
		 }
	  }
 }
}