//Family database class that creates family relationships
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FamilyDatabase {
	private ArrayList<Person> allPersons = new ArrayList<Person>();
   
	private static final String end = "END"; //Instantiates the end
   
	// creates constructor for family database
	public FamilyDatabase(String fileName) throws FileNotFoundException { //Takes a file and creates a family database
		Scanner scan = new Scanner(new File(fileName));
		
	   	while (scan.hasNextLine()) { //This initial loop is used to skip just past the first instance of END.
	   		String sonName = scan.nextLine();
	   		if(sonName.equals(end)) {
	   			break;
	   		}
	   	}
	   	while (scan.hasNextLine()) {
	   		String sonName = scan.nextLine();
	   		
	   		if (sonName.equals(end)) { //Close once the 2nd instance of "END" is found.
	   			break;
	   			
	   		} else {
	   			String motherName = scan.nextLine();
	   			String fatherName = scan.nextLine();
	   			Person newSon;
	   			int id = ifAdded(sonName);
	   			
	   			if (id == -1) { //Is this person present?
	   				newSon = new Person(sonName);
	   			} else {
	   				newSon = this.allPersons.get(id);
	   			}
	   			
	   			if (!motherName.equals("unknown")) { //Finds and sets the person's mother.
	   				id = ifAdded(motherName);
	   				if (id == -1) {
	   					Person newMother = new Person(motherName);
	   					this.allPersons.add(newMother);
	   					newSon.setMother(newMother);
				   	} else {
				   		newSon.setMother(this.allPersons.get(id));
				   	}
			   	}
			   	if (!fatherName.equals("unknown")) { //Finds and sets the person's father.
				   	id = ifAdded(fatherName);
				   	if (id == -1) {
					   	Person newFather = new Person(fatherName);
					   	newSon.setFather(newFather);
					   	this.allPersons.add(newFather);
				   	} else {
					   	newSon.setFather(this.allPersons.get(id));
				   	}
			   	}
			   	this.allPersons.add(newSon);
		   	} 
	   	}
   	}
   
   	public int ifAdded(String personName) { //Find a person's index in the list.
   		if(this.allPersons.size() > 0) {
   			for(int i = 0; i < this.allPersons.size(); i++) {
   				if(this.allPersons.get(i).getName().equalsIgnoreCase(personName)) {
   					return i;
   				}
   			}
   		}
   		return -1; //Return -1 if the person is not found.
   	}
   
   	public Person getPerson(String name) { //Grabs Person by name using a String
   		int person_id = ifAdded(name);
   		if (person_id == -1) { //Return null if the person cannot be found
   			return null;
   		} else {
   			return this.allPersons.get(person_id);
   		}
   	}
}