import java.io.FileNotFoundException;
/*
1) Yudong Lin
2) If there is any problem, please submit in here: https://github.com/yoshino-lin
3) 950697081
4) 3/17/2019
4) current quarter: winter
5) This program will read the data from a text file and print the result base on different kinds of input
*/
public class Assg08_yudong {
	public static void main(String[] args) throws FileNotFoundException {
		People p =new People("people.txt");
		 p.list(); // List of students AND teachers)
		 p.list("s"); // List of students
		 p.list("s","f"); // List of female students
		 p.list("s","f", 20); // List of female students whose age>=20
		 p.list("s","f", 15, 20); // List of female students whose age>=15 and age<=20
		 p.list("s", 20); // List of students whose age>=20
		 p.list("s", 15, 20); // List of students whose age>=15 and age<=20
	}
}
