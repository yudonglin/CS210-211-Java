import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//µÚ16ÕÂµÚ1027#4Ò³
public class TestClient {

	public static void main(String[] args) throws FileNotFoundException {
    	System.out.println("Question 8:");
    	// initialize the list
    	LinkedStringList list1 = new LinkedStringList();
        processList1(list1);
        // print the list before switchPairs
        System.out.println("List before switchPairs: "+list1.toString());
        
    }
    
    //add the elements into the list
    public static void processList1(LinkedStringList list) throws FileNotFoundException {
    	Scanner scan = new Scanner(new File("src/names.txt"));
    	while (scan.hasNextLine()) {
    		list.add(scan.nextLine());
    	}

    }
}
