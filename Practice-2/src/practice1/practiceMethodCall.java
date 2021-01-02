package practice1;

public class practiceMethodCall {
	public static void A(){
		System.out.println("A");
		C();
		
	}
	
	public static void B(){
		System.out.println("B");
		A();
	}	
	
	public static void C(){
		System.out.println("C");
		
	}	
	
	public static void main(String[] args) {
		A();
		B();
	}
}
