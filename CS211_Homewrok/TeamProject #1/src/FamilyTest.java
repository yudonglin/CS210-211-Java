//Family testing client. Allows the user to search the database.

import java.io.FileNotFoundException;
import java.util.Scanner;

public class FamilyTest {

 public static void main(String[] args) throws FileNotFoundException { 
	 
	boolean cont = true; //sentinel loop variable
	FamilyDatabase r = new FamilyDatabase("tudor.dat");
  
  	while (cont) { //Sentinel loop
  		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
  		System.out.println("Person's name?");
  		System.out.println("Type 'stop' to exit.");
  		String s = in.nextLine();
 
  		if (s.equalsIgnoreCase("stop")) { //Exit the loop if the user types in "stop".
  			cont = false;
  			System.out.println("Exiting database!");
  			break;
  		}
  		
  		Person that_Person = r.getPerson(s);
  			if (that_Person != null) { //If the person can be found, retrieve and print their data.
  				System.out.println("Person: " + that_Person.getName());
  				
  				if (that_Person.getFatherName() != null) { //Print paternal information
  				  	System.out.println("Paternal Line: ");
  				  	System.out.println("\t" + that_Person.getName()); //This is done to replicate the formatting in the book.
  				  	System.out.println("\t \t "+ that_Person.getFatherName()); 
  				} else {
  				  	System.out.println("Paternal Line: ");
  				  	System.out.println("\t" + "Unknown Father");
  				}
  				
  				  if (that_Person.getMotherName() != null) { //Print maternal information
  					  System.out.println("Maternal Line: ");
  					  System.out.println("\t" + that_Person.getName());
  					  System.out.println("\t \t "+ that_Person.getMotherName());
  				  } else {
  					  System.out.println("Maternal Line: ");
  					  System.out.println("\t" + "Unknown Mother");
  				  }
  				  
  				  if (that_Person.getChildren().size() > 0) { //Print children information
  				  		System.out.printf("Has %d children:",that_Person.getChildren().size());
  				  		System.out.println();
  				  	
  				  		for (Person p: that_Person.getChildren()) {
  				  			System.out.println("\t" + p.getName());
  				  		}
  				  } else {
  					  System.out.println("Unknown Children");
  			  } 
  			} else {
  				System.out.println("Cannot find this person"); //Printed if the person can't be found.
  			}
  			System.out.println(); //Some blank space between each loop
  		}
  	}
}