/*
 * ==========================================
 * CS211 Spring chapter11
 * Yudong Lin 4/22/2020
 * In-Class Exercise #2
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCount {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("src/mobydick.txt"));
		input.useDelimiter("[^a-zA-Z']+");
		//Add necessary code to complete the main program; it will have to call the 
		//methods you make below    

		/*
		 * Create code to surround the snippet below with what's needed to make it a 
		 * method that accepts a Scanner object. At a minimum, there needs to be a method
		 * signature line that defines its input parameter as a Scanner, and returns a 
		 * Map<String, Integer> to the caller
		 */
		    // read file into a map of [word --> number of occurrences]
		    Map<String, Integer> wordCount = new TreeMap<String, Integer>();
		    while (input.hasNext()) {
		        String word = input.next();
		        if (wordCount.containsKey(word)) {
		            // seen this word before; increase count by 1
		            int count = wordCount.get(word);
		            wordCount.put(word, count + 1);
		        } else {
		            // never seen this word before
		            wordCount.put(word, 1);
		        }
		    }
		    for(String word:wordCount.keySet()) {
		    	if (wordCount.get(word)>=2000){
		    		System.out.println("Word '"+word+"' appears " + wordCount.get(word) + " times.");
		    	}
		    	
		    }
		    //don't forget your return statement
		    
		/* 
		 * User interaction snippet is below; it needs to be turned into a method also.
		 * Be sure to provide this method with access to the data structure, and don't 
		 * limit the user to a single query. Be sure to tell the user how to exit the 
		 * program in your prompt
		 */
		    boolean keepAsking = true;
		    while(keepAsking == true) {
		    	Scanner console = new Scanner(System.in);
			    System.out.printf("Word to search for? Enter %s to exit","quit()");
			    String word = console.next();
			    if(word.equals("quit()")) {
			    	keepAsking = false;
			    }else {
			    	System.out.println("Word '"+word+"' appears " + wordCount.get(word) + " times.");
			    }
		    }

	}

}
