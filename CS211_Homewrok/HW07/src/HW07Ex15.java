/* CS211 Yudong Lin 
 * HW07
 * 24 May 2020
 * Chapter 12 question 15
 */

public class HW07Ex15 {

	public static void main(String[] args) {
		// this method takes an string as a parameter
		String theWord = "beautifully";
		System.out.println("After processing the function, the word "+theWord+
				" becomes "+ vowelsToEnd(theWord));
	}
	
	public static String vowelsToEnd(String word) {
		// remove the first character from the word until there is only one character left.
		if (word.length()>1) {
			// remove the first character from the string, then give it to the next layer
			String tempWord = vowelsToEnd(word.substring(1));
			// now, when we get the word back from previous layer
			// we only need to focus on current layer
			if (isVowels(word.charAt(0))) {
				// if the character we keep is a vowel, put it at the back of the words
				// and then return the word
				return tempWord+word.charAt(0);
			}else {
				// if the character we keep is not a vowel, put it at the front of the words
				// and then return the word
				return word.charAt(0)+tempWord;
			}
		// return the word if there is only one character left inside the string
		// or the string pass in is empty or only have one character
		}else {
			return word;
		}
	}
	
	// this method checks whether a character is a vowel
	// return true if yes, false is no
	public static boolean isVowels(char letter) {
		if(letter=='a' || letter=='e' || letter=='i' || letter=='o' || letter=='u' ) {
			return true;
		}else {
			return false;
		}
	}

}
