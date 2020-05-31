/* CS211 Yudong Lin 
 * HW08
 * 30 May 2020
 * Chapter 17 question 1, 5, 8
 */
// Short program that demonstrates the use of the IntTree class.

public class IntTreeClient {
    public static void main(String[] args) {
        IntTree t = new IntTree(1);
        // Set up the IntTree t so it's structure will be the same
        // as Reference Tree #1 at the beginning of the exercise
        t.setUpTreeExmaple1();
        
        // print the Tree to check whether the tree is correctly set up
        System.out.println("Tree structure for qeustion 1:");
        t.printSideways();
        System.out.println();
        
        // qestion1
        System.out.println("There are "+t.countLeftNodes()+" left children in the tree");
        System.out.println("------------------------------------------------------------");
        
        // OK, so since we have finished question 1, I will go ahead to edit the values inside the tree
        // So its structure will be the same as the Reference Tree #2 at the beginning of the exercise
        t.setUpTreeExmaple2();
        System.out.println("Tree structure for question 5 and 8:");
        t.printSideways();
        System.out.println();
        
        // qestion5
        int levelNum = 3; // Please set the input for printLevel here
        System.out.println("printLevel("+levelNum+") from left to right:");
        t.printLevel(levelNum);
        
        // qestion8
        System.out.println("The result of toString() method: "+ t.toString());
    }
}
