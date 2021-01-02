import java.io.FileNotFoundException;

public class Assg08_yudong {

	public static void main(String[] args) throws FileNotFoundException {
		People p =new People("people.txt");
		p.c1 = 'w';
		p.c2 = 'm';
		p.s = "t";
		
		p.list(p.c1);
		System.out.println();
		p.list(p.c1,p.c2);
		System.out.println();
		p.list(p.s,p.c2);
		System.out.println();
		p.list(p.s,p.c1,p.c2); // List of female students whose age>=20
	}
}
