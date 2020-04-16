import java.util.*;
import java.io.FileNotFoundException;

public class FamilyTest {

 public static void main(String[] args) throws FileNotFoundException {

    
  // instantiate family databases class 
  
  familyDatabase r = new familyDatabase("tudor.dat");
  
  
   
  // ask user for person name from scanner 
  
  @SuppressWarnings("resource")
  Scanner in = new Scanner(System.in);
  
  System.out.println("Person's name?");
  
  String s = in.nextLine();
  Person that_Person = r.getPerson(s);
  
  if (that_Person != null) {
	  that_Person.showDetials();
  }else {
	  System.out.println("cannot find this person");
  }
 }
}