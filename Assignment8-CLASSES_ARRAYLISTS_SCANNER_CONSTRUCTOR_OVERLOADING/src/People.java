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
	public void quick_print(String type1,String type2,String type3){
		System.out.println("List of People");
		System.out.println("Type: "+type1+", Gender: "+type2+", Age: "+type3);
	}
	
	public void list(){
		quick_print("Students and teachers","Male and female","All");
		for(int i = 0; i<allList.size(); i++) {
			System.out.println(allList.get(i).name);
		}
	}
	
	public void list(String type){
		String type_out = null;
		if(type.toLowerCase().equals("s")){
			type_out = "Students";
		}else if(type.toLowerCase().equals("t")) {
			type_out = "Teachers";
		}
		quick_print(type_out,"Male and female","All");
		for(int i = 0; i<allList.size(); i++) {
			if(type.equals(allList.get(i).type)){
				System.out.println(allList.get(i).name);
			}
		}
	}
	
	public void list(String type, String gender){
		String type_out = null;
		String gender_out = null;
		if(type.toLowerCase().equals("s")){
			type_out = "Students";
		}else if(type.toLowerCase().equals("t")) {
			type_out = "Teachers";
		}
		if(gender.toLowerCase().equals("m")){
			gender_out = "Male";
		}else if(gender.toLowerCase().equals("f")) {
			gender_out = "Female";
		}
		quick_print(type_out,gender_out,"All");
		for(int i = 0; i<allList.size(); i++) {
			if(type.equals(allList.get(i).type) && gender.equals(allList.get(i).gender)){
				System.out.println(allList.get(i).name);
			}
		}
	}
	
	public void list(String type, String gender, int age1){
		String type_out = null;
		String gender_out = null;
		String age_out = "bigger than "+age1;
		if(type.toLowerCase().equals("s")){
			type_out = "Students";
		}else if(type.toLowerCase().equals("t")) {
			type_out = "Teachers";
		}
		if(gender.toLowerCase().equals("m")){
			gender_out = "Male";
		}else if(gender.toLowerCase().equals("f")) {
			gender_out = "Female";
		}
		quick_print(type_out,gender_out,age_out);
		for(int i = 0; i<allList.size(); i++) {
			if(type.equals(allList.get(i).type) && gender.equals(allList.get(i).gender) && allList.get(i).age >= age1){
				System.out.println(allList.get(i).name);
			}
		}
	}
	
	public void list(String type, String gender, int age1, int age2){
		String type_out = null;
		String gender_out = null;
		String age_out = "between "+age1+" and "+age2;
		if(type.toLowerCase().equals("s")){
			type_out = "Students";
		}else if(type.toLowerCase().equals("t")) {
			type_out = "Teachers";
		}
		if(gender.toLowerCase().equals("m")){
			gender_out = "Male";
		}else if(gender.toLowerCase().equals("f")) {
			gender_out = "Female";
		}
		quick_print(type_out,gender_out,age_out);
		for(int i = 0; i<allList.size(); i++) {
			if(type.equals(allList.get(i).type) && gender.equals(allList.get(i).gender) && allList.get(i).age >= age1 && allList.get(i).age <= age2){
				System.out.println(allList.get(i).name);
			}
		}
	}
	
	public void list(String type, int age1){
		String type_out = null;
		String age_out = "bigger than "+age1;
		if(type.toLowerCase().equals("s")){
			type_out = "Students";
		}else if(type.toLowerCase().equals("t")) {
			type_out = "Teachers";
		}
		quick_print(type_out,"Male and female",age_out);
		for(int i = 0; i<allList.size(); i++) {
			if(type.equals(allList.get(i).type) && allList.get(i).age >= age1){
				System.out.println(allList.get(i).name);
			}
		}
	}
	
	public void list(String type, int age1, int age2){
		String type_out = null;
		String age_out = "between "+age1+" and "+age2;
		if(type.toLowerCase().equals("s")){
			type_out = "Students";
		}else if(type.toLowerCase().equals("t")) {
			type_out = "Teachers";
		}
		quick_print(type_out,"Male and female",age_out);
		for(int i = 0; i<allList.size(); i++) {
			if(type.equals(allList.get(i).type) && allList.get(i).age >= age1 && allList.get(i).age <= age2){
				System.out.println(allList.get(i).name);
			}
		}
	}
}