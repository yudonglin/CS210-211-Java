package practice1;

public class practiceMethodSong { 
	public static void song_repeat(){
		System.out.println("\nLeaves are falling");
		System.out.println("Leaves are falling");
	}
	/* This is the easist way
	public static void main(String[] args) {
		System.out.println("Leaves are Falling");
		song_repeat();
		System.out.println("One fell on my nose!");
		song_repeat();
		System.out.println("One fell on my toes!");
		song_repeat();
		System.out.println("One fell on my head!");
		song_repeat();
		System.out.println("Yellow, Orange and red!");
	}
	*/
	
	// This is what I will code.
	public static void main(String[] args) {
		System.out.println("Leaves are Falling");
		String item = "nose"; 
		for (int i = 0; i < 4; i++) {
          if(i == 1) {
        	 item = "toes";
          }
          else if(i == 2) {
         	 item = "head";
           }
          song_repeat();
        if(i < 3) {
  		    System.out.println("One fell on my "+item);
	    }
        else {
        	System.out.println("Yellow, Organge and red!");
        }
     }
   }
}

