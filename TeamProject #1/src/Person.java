//Defines a person and allows them to have a name, mother, father, and children.
import java.util.ArrayList;

public class Person {
	private String name;
	private Person mother;
	private Person father;
	private ArrayList<Person> children;
	//since there can be numerous children, this is saved as an ArrayList
			
	public Person(String name) { //regular constructor. Mother and father fields unknown by default.
		this.name = name;
		this.mother = null;
		this.father = null;
		this.children = new ArrayList<Person>();
	}
	
	public Person() { //blank constructor
		this.name = null;
		this.mother = null;
		this.father = null;
		this.children = new ArrayList<Person>();
	}
	
//Setters
	public void setName(String name) { //Set the name
		this.name = name;
	}
	
	public void setMother(Person mother) { //Set the mother
		this.mother = mother;
		mother.addChildren(this); //Automatically add this Person as a child of the mother.
	}
	
	public void setFather(Person father) { //Set the father
		this.father = father;
		father.addChildren(this); //Automatically add this Person as a child of the father.
	}
	
	public void addChildren(Person child) { //Add a child
		children.add(child);
	}
	
	public void setChild(int i, Person child) { //Set a child
		children.set(i, child);
	}
	
	
//Getters
	public String getName() { //Get the name from this Person (String)
		return this.name;
	}
	
	public Person getMother() { //Get the mother (Person)
		if (this.mother != null) {
			return this.mother;
		} else {
			return null;
		}
	}
	
	public String getMotherName() { //Get the mother name (String)
		if (this.mother != null) {
			return this.mother.getName();
		} else {
			return null;
		}
	}
	
	public Person getFather() { //Get the father (Person)
		if (this.father != null) {
			return this.father;
		} else {
			return null;
		}
	}
	
	public String getFatherName() { //Get the father name (String)
		if (this.father != null) {
			return this.father.getName();
		}else {
			return null;
		}
	}
	
	public Person getChild(int i) { //Return one child at a specific index
		return children.get(i);
	}
	
	public ArrayList<Person> getChildren() { //Return the whole index of children.
		return children;
	}
	

//Other
	public ArrayList<String> childrenToString() { //Returns the list of children as a list of Strings
		ArrayList<String> childrenS = new ArrayList<>();
		for (Person p: children) {
			childrenS.add(p.getName());
		}
		return childrenS;
	}
}