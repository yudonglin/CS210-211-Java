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
	  if(that_Person.getFatherName() != null) {
		 System.out.println("Father: "+that_Person.getFatherName());
	  }else {
		  System.out.println("no Father");
	  }
	  if(that_Person.getMotherName() != null) {
			 System.out.println("Mother: "+that_Person.getMotherName());
		  }else {
			  System.out.println("no Mother");
		  }
	  if(that_Person.getChildren().size() > 0) {
		  System.out.printf("Has %d kids:",that_Person.getChildren().size());
		  System.out.println();
		  for(int i=0;i<that_Person.getChildren().size();i++) {
			  System.out.println(that_Person.getChildren().get(i).getName());
		  }
	  }else {
		  System.out.println("Has no kid");
	  }
	  
	  
  }else {
	  System.out.println("cannot find this person");
  }
 }
}