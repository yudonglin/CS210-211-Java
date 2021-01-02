/* CS211 Yudong Lin 
 * HW08
 * 30 May 2020
 * Chapter 17 question 1, 5, 8
 */
// Simple binary tree class that includes methods to construct a
// tree of ints, to print the structure, and to print the data
// using a preorder, inorder or postorder traversal.  The trees
// built have nodes numbered starting with 1 and numbered
// sequentially level by level with no gaps in the tree.  The
// documentation refers to these as "sequential trees."

public class IntTree {
    public IntTreeNode overallRoot;

    // pre : max > 0
    // post: constructs a sequential tree with given number of
    //       nodes
    public IntTree(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("max: " + max);
        }
        overallRoot = buildTree(1, max);
    }

    // post: returns a sequential tree with n as its root unless
    //       n is greater than max, in which case it returns an
    //       empty tree
    private IntTreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        } else {
            return new IntTreeNode(n, buildTree(2 * n, max),
                                   buildTree(2 * n + 1, max));
        }
    }

    // post: prints the tree contents using a preorder traversal
    public void printPreorder() {
        System.out.print("preorder:");
        printPreorder(overallRoot);
        System.out.println();
    }

    // post: prints the tree contents using a preorder traversal
    // post: prints in preorder the tree with given root
    private void printPreorder(IntTreeNode root) {
        if (root != null) {
            System.out.print(" " + root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    // post: prints the tree contents using a inorder traversal
    public void printInorder() {
        System.out.print("inorder:");
        printInorder(overallRoot);
        System.out.println();
    }

    // post: prints in inorder the tree with given root
    private void printInorder(IntTreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(" " + root.data);
            printInorder(root.right);
        }
    }

    // post: prints the tree contents using a postorder traversal
    public void printPostorder() {
        System.out.print("postorder:");
        printPostorder(overallRoot);
        System.out.println();
    }

    // post: prints in postorder the tree with given root
    private void printPostorder(IntTreeNode root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(" " + root.data);
        }
    }

    // post: prints the tree contents, one per line, following an
    //       inorder traversal and using indentation to indicate
    //       node depth; prints right to left so that it looks
    //       correct when the output is rotated.
    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    // post: prints in reversed preorder the tree with given
    //       root, indenting each line to the given level
    private void printSideways(IntTreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }
    
    // post: return the number of left children in the tree
    public int countLeftNodes() {
    	// I want to use recursion to solve this question, although solution with no recursion is possible
    	// notice that I set default int num to 0
    	return countLeftNodes(overallRoot,0);
    }
    // Set it to private because I do not want client to touch it!
    private int countLeftNodes(IntTreeNode root, int num) {
    	if (root.right != null) {
    		// if there is treeNode on the right side, go ahead and check it
    		// then set the num to the num that returned
    		num = countLeftNodes(root.right,num);
    	}
    	// OK now we are done for the right side only for this current node
    	if (root.left != null) {
    		// Now we need to check the left side. Since we know there is left children exist, so we need to add 1
    		// then give the root.left and num+1 to the next recursion
    		num = countLeftNodes(root.left,num+1);
    	}
    	// Great! We check all the children for current node!
    	// So why not just go ahead and return the number?
    	return num;
    }
    
    // post: accepts an integer parameter n and prints the values at level n
    // from left to right, one per line
    public void printLevel(int n) {
    	// first, check whether input n is less than 1
    	if(n<1) {
    		throw new IllegalArgumentException("input for printLevel must be bigger than 1: " + n);
    	}else {
    		// No? Then I guess I have to print it...
    		printLevel(overallRoot,n);
    	}
    }
    //Recursion is a easier option
    private void printLevel(IntTreeNode root, int n) {
    	// if n is 1, then we are on the level which we need to print the value
    	if(n==1) {
    		System.out.println(root.data);
    	}else {
    		// Due to the fact that I an required to prints the values from left to right
    		// So let's start from left side first, if it is available
    		if(root.left!=null) {
    			// minus 1 from n before hand it in to the next recursion
    			// so I can keep track on which layer I am on
    			printLevel(root.left,n-1);
    		}
    		// When we are done with the left side for current Node,
    		// we should focus on right side, if it is available
    		if(root.right!=null) {
    			// minus 1 from n before hand it in to the next recursion
    			// so I can keep track on which layer I am on
    			printLevel(root.right,n-1);
    		}
    	}
    }
    
    // post: return "empty" for an empty tree. For a leaf node, it should return
    // the data in the node as a string. For a leaf node, it should return a parenthesized
    // String that has tree elements separated by commas: the data at the root, a string
    // representation of the left subtree, and then a string representation of the right subtree
    public String toString() {
    	return toString(overallRoot);
    }
    // All right... The reason that I use recursion is because I do not want to
    // figure out a solution without recursion
    private String toString(IntTreeNode root) {
    	// So if the current root is not a null:
    	if(root != null) {
    		// Initial a String variable with sth similar to root.data.toString()
    		String tempStr = ""+root.data;
    		// Is this a tree Node? Do this if the answer is yes.
    		if (root.left != null || root.right != null) {
    			// put a "(" at the front, then current Node value, then a comma,
    			// then string representation of the left subtree, then a comma,
    			// then a string representation of the right subtree, then close it will a ")"
    			tempStr = "("+tempStr+", "+toString(root.left)+", "+toString(root.right)+")";
    		}
    		// after we are done with current node, return it
    	    return tempStr;
    	}else {
    		// return "empty" is current Node is null
    		// Maybe current node is the overallRoot of the Tree? I don know.
    		return "empty";
    	}  
	}
    
    // post: this method will edit the values inside the tree, so its structure
    // will be the same as the Reference Tree #1 at the beginning of the exercise
    public void setUpTreeExmaple1() {
    	overallRoot = new IntTreeNode(3);
    	overallRoot.left = new IntTreeNode(5);
    	overallRoot.left.left = new IntTreeNode(1);
    	overallRoot.right = new IntTreeNode(2);
    	overallRoot.right.left = new IntTreeNode(4);;
    	overallRoot.right.right = new IntTreeNode(6);
    }
    
    // post: this method will edit the values inside the tree, so its structure
    // will be the same as the Reference Tree #2 at the beginning of the exercise
    public void setUpTreeExmaple2() {
    	overallRoot = new IntTreeNode(2);
    	overallRoot.left = new IntTreeNode(8);
    	overallRoot.left.left = new IntTreeNode(0);
    	overallRoot.right = new IntTreeNode(1);
    	overallRoot.right.left = new IntTreeNode(7);
    	overallRoot.right.left.left = new IntTreeNode(4);
    	overallRoot.right.right = new IntTreeNode(6);
    	overallRoot.right.right.right = new IntTreeNode(9);
    }
}