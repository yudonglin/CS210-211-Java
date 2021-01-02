// CS211 Yudong Lin 
// HW02
// 18 April 2020
/* 
 * Your file header comment block goes above this line
 *
 * TimeSpanClient: a simple test client for the TimeSpan class
 * Shows creation of an instance object, displaying that object,
 * adding hours and minutes to that object, and showing the result.
 */
 public class TimeSpanClient {
    public static void main(String[] args) {
    	//create time object t1
        int h1 = 3, m1 = 15;
        TimeSpan t1 = new TimeSpan(h1, m1);
        System.out.println("New object t1: " + t1);
        //create time object t2
        int h2 = 1, m2 = 40;
        TimeSpan t2 = new TimeSpan(h2, m2);
        System.out.println("New object t2: " + t2);
        //compare t1 with t2
        if (t1.compareTo(t2)==1){
        	System.out.println(t1+" is bigger than "+t2);
        }else if (t1.compareTo(t2)==-1){
        	System.out.println(t1+" is smaller than "+t2);
        }else {
        	System.out.println(t1+" is qeual to "+t2);
        }
        //compare t2 with t1
        if (t2.compareTo(t1)==1){
        	System.out.println(t2+" is bigger than "+t1);
        }else if (t2.compareTo(t1)==-1){
        	System.out.println(t2+" is smaller than "+t1);
        }else {
        	System.out.println(t2+" is qeual to "+t1);
        }
        
        h1 = 3; m1 = 40;
        System.out.println("Adding " + h1 + " hours, " + m1 + " minutes to t1");        
        t1.add(h1, m1);
        System.out.println("New t1 state: " + t1);
    }
}