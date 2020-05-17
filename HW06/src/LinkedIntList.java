/* CS211 Yudong Lin 
 * HW06
 * 16 May 2020
 * Chapter 16, do exercises 8 and 12 on page 1023
 */

// Class LinkedIntList can be used to store a list of integers.
public class LinkedIntList implements IntList {
    private ListNode front;  // first value in the list

    // post: constructs an empty list
    public LinkedIntList() {
        front = null;
    }

    // post: returns the current number of elements in the list
    public int size() {
        int count = 0;
        ListNode current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return nodeAt(index).data;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
        int index = 0;
        ListNode current = front;
        while (current !=  null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode(value, front);
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = new ListNode(value, current.next);
        }
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    // pre : 0 <= i < size()
    // post: returns a reference to the node at the given index
    private ListNode nodeAt(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    
    // q8: switch the order of the value
    public void switchPairs() {
    	// set the walker
    	ListNode walker = front;
    	// make sure that both walker and walker.next is not null
    	while(walker != null && walker.next != null) {
    		// temporarily store the current walker value
    		int tempValue = walker.data;
    		// set the current walker value to its next node's value
    		walker.data = walker.next.data;
    		// set the next walker value to current walker value
    		walker.next.data = tempValue;
    		// go to next.next because we already set the walker.next's value
    		walker = walker.next.next;
    	}
    }
    
    // q12: rearrange the elements of the list
	public void split() {
		//set the walker
		ListNode walker = front;
		// make sure that both walker and walker.next is not null
        while (walker != null && walker.next != null) {
        	// if the value is positive, keep it inside the link list
        	// walker can keep going forward
        	if (walker.next.data >= 0) {
        		walker = walker.next;
        	}else {
        		// if the value is negative, we find a new node with negative value
        		// and it is waiting for us to rearrange
        		// create a container to temporarily store the nodes after walker.next
        		ListNode tempNodeList = walker.next.next;
        		// Connect walker.next with front (now it is a looped link list)
                walker.next.next = front;
                // set the walker.next, which contain the negative value, as the head of the list
                front = walker.next;
                // after rearranging the new current negative value to be the head
                // of the link list, break the loop and add nodes back
                walker.next = tempNodeList;
        	}
        }
    }
}
