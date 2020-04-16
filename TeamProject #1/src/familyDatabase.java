// Family database class that creates family relationships
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class familyDatabase {
   private ArrayList<Person> allPersons = new ArrayList<Person>();
   
   private static final String end = "END";
   
   // creates constructor for family database
   public familyDatabase(String fileName) throws FileNotFoundException {
	   Scanner scan = new Scanner(new File(fileName));
	   while (scan.hasNextLine()) {
		   String sonName = scan.nextLine();
		   if(sonName.equals(end)) {
			   break;
		   }
	   }
	   while (scan.hasNextLine()) {
		   String sonName = scan.nextLine();
		   if (sonName.equals(end)) {
			   break;
		   }else {
			   String motherName = scan.nextLine();
			   String fatherName = scan.nextLine();
			   Person newSon;
			   int id = ifAdded(sonName);
			   if (id == -1) {
				   newSon = new Person(sonName);
			   }else {
				   newSon = this.allPersons.get(id);
			   }
			   if (!motherName.equals("unknown")) {
				   id = ifAdded(motherName);
				   if (id == -1) {
					   Person newMother = new Person(motherName);
					   this.allPersons.add(newMother);
					   newSon.setMother(newMother);
				   }else {
					   newSon.setMother(this.allPersons.get(id));
				   }
			   }
			   if (!fatherName.equals("unknown")) {
				   id = ifAdded(fatherName);
				   if (id == -1) {
					   Person newFather = new Person(fatherName);
					   newSon.setFather(newFather);
					   this.allPersons.add(newFather);
				   }else {
					   newSon.setFather(this.allPersons.get(id));
				   }
			   }
			   this.allPersons.add(newSon);
		   }
		   
	   }
   }
   public int ifAdded(String personName) {
	   if(this.allPersons.size()>0) {
		   for(int i=0; i<this.allPersons.size();i++) {
			   if(this.allPersons.get(i).getName().equalsIgnoreCase(personName)) {
				   return i;
			   }
		   }
		   return -1;
	   }else {
		   return -1;
	   }
   }
   // gets person by name
   public Person getPerson(String name) {
	   int person_id = ifAdded(name);
	   if (person_id == -1) {
		   return null;
	   }else {
		   return this.allPersons.get(person_id);
	   }
   }
	public void getPersonDetails(String name) {
	   int person_id = ifAdded(name);
	   if (person_id != -1) {
		   this.allPersons.get(person_id).showDetials();
	   }
   }

}