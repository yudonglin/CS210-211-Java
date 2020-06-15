/* CS211 Yudong Lin 
 * Final Project
 * 14 June 2020
 * Chapter 15 Page 974, #4
 */

import java.util.Arrays;

public class SortedIntList {
	private int[] elementData; // list of integers
    private int size;          // current number of elements in the list

    public static final int DEFAULT_CAPACITY = 100;

    // pre : capacity >= 0 (throws IllegalArgumentException if not)
    // post: constructs an empty list with the given capacity
    public SortedIntList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        elementData = new int[capacity];
        size = 0;
    }

    // post: constructs an empty list of default capacity
    public SortedIntList() {
        this(DEFAULT_CAPACITY);
    }

    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the integer at the given index in the list
    public int get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + elementData[0];
            for (int i = 1; i < size; i++) {
                result += ", " + elementData[i];
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
    	// the starting point
		int startPoint = 0;
		// the ending point
		int endPoint = size-1;
		// while the starting point is smaller than the ending point
		while(startPoint<=endPoint) {
			// set the middle point to the middle point between the starting
			// point and the ending point
			int midPoint = (endPoint+startPoint)/2;	
			// if the value we need to find is smaller than the value on middle point
			if (value < elementData[midPoint]) {
				// we know that the index must be somewhere before the middle point
				// since we have checked the middle point, so we do not need to check it again
				endPoint = midPoint-1;
			// if the value we need to find is bigger than the value on middle point
			}else if (value > elementData[midPoint]){
				// we know that the index must be somewhere after the middle point
				// since we have checked the middle point, so we do not need to check it again
				startPoint = midPoint+1;
			// if the value we need to find equals to the value on middle point
			}else {
				// than we find that number, return its index
				return midPoint;
			}
		}
		// so we cannot find that number, return -1
		return -1;
    }

    // post: returns true if list is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    // post: returns true if the given value is contained in the list,
    //       false otherwise
    public boolean contains(int value) {
        return indexOf(value) >= 0;
    }

    // pre : size() < capacity (throws IllegalStateException if not) &&
    //       0 <= index <= size() (throws IndexOutOfBoundsException if not)
    // post: inserts the given value at the given index, shifting subsequent
    //       values right   
    public void add(int value) {
    	int index = 0;
    	// if array is not empty
    	if (size > 1) {
    		// the starting point
    		int startPoint = 0;
    		// the ending point
    		int endPoint = size-1;
    		index = -1;
    		// while the difference between endPoint and startPoint are bigger than 1
    		while(endPoint-startPoint>1) {
    			// set the middle point to the middle point between the current
    			// starting point and the current ending point
    			int midPoint = (endPoint+startPoint)/2;	
    			// if the value we need to find is smaller than the value on middle point
    			if (value < elementData[midPoint]) {
    				// we know that the index must be somewhere before the middle point
    				endPoint = midPoint;
    			// if the value we need to find is bigger than the value on middle point
    			}else if (value > elementData[midPoint]){
    				// we know that the index must be somewhere after the middle point
    				startPoint = midPoint;
    			// if the value on middle point equals to the value we need to put
    			}else {
    				// this mean that this array already contain this value
    				// than we set the ending point to equal to the starting point
    				// and break out
    				index = midPoint+1;
    				break;
    			}
    		}
    		if (index == -1) {
    			if (value <= elementData[startPoint]) {
    				index = startPoint;
    			} else if (value <= elementData[startPoint+1]){
    				index = startPoint+1;
    			} else {
    				index = startPoint+2;
    			}
    		}
    	} else if (size == 1 && value > elementData[0]) {
    		index = 1;
    	}
        ensureCapacity(size + 1); //this public method throws the exception
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
    }

    // post: list is empty
    public void clear() {
        size = 0;
    }

    // post: ensures that the underlying array has the given capacity; if not,
    //       the size is doubled (or more if given capacity is even larger)
    private void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newCapacity = elementData.length * 2 + 1;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    // post: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }
    
    // post: quickly add all elements from an array L to
    //		 to the current ArrayIntList
    public void addList(int[] L) {
    	for(int i=0;i<L.length;i++) {
    		add(L[i]);
    	}
    }
    
 // post: quickly add all elements from an array L to
    //		 to the current ArrayIntList
    public boolean euqlas(int[] L) {
    	for(int i=0;i<L.length;i++) {
    		if (elementData[i] != L[i]) {
    			return false;
    		}
    	}
    	return true;
    }
}
