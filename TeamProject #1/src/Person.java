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
	
	//Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMother(Person mother) {
		this.mother = mother;
		mother.addChildren(this);
	}
	
	public void setFather(Person father) {
		this.father = father;
		father.addChildren(this);
	}
	public void addChildren(Person child) {
		children.add(child);
	}
	public void setChild(int i, Person child) {
		children.set(i, child);
	}
	
	//Getters
	public String getName() {
		return this.name;
	}
	
	public Person getMother() {
		if (this.mother != null) {
			return this.mother;
		}else {
			return null;
		}
	}
	
	public String getMotherName() {
		if (this.mother != null) {
			return this.mother.getName();
		}else {
			return null;
		}
	}
	
	public Person getFather() {
		if (this.father != null) {
			return this.father;
		}else {
			return null;
		}
	}
	
	public String getFatherName() {
		if (this.father != null) {
			return this.father.getName();
		}else {
			return null;
		}
	}
	
	public boolean ifAChild(Person child) {
		for(int i=0;i<this.children.size();i++) {
			if(this.children.get(i).getName() == child.getName()) {
				return true;
			}
		}
		return false;
	}
	
	public Person getChild(int i) { //Return one child at a specific index
		return children.get(i);
	}
	
	public ArrayList<Person> getChildren() { //Return the whole index of children.
		return children;
	}

	//Other
	public String nameToString() {
		return getName();
	}
	
	public ArrayList<String> childrenToString() {
		ArrayList<String> childrenS = new ArrayList<>();
		for (Person p: children) {
			childrenS.add(p.nameToString());
		}
		return childrenS;
	}
	
	public void showDetials() { //This is for testing purposes. I plan to remove it later.
		System.out.println("Person: " + name);
		if(this.getFatherName() != null) {
			 System.out.println("Father: "+this.getFatherName());
		  }else {
			  System.out.println("no Father");
		  }
		  if(this.getMotherName() != null) {
				 System.out.println("Mother: "+this.getMotherName());
			  }else {
				  System.out.println("no Mother");
			  }
		  if(this.getChildren().size() > 0) {
			  System.out.printf("Has %d kids:",this.getChildren().size());
			  System.out.println();
			  for(int i=0;i<this.getChildren().size();i++) {
				  System.out.println(this.getChildren().get(i).getName());
			  }
		  }else {
			  System.out.println("Has no kid");
		  }
	}
	
}
