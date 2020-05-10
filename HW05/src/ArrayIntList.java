/* CS211 Yudong Lin 
 * HW05
 * 9 May 2020
 * page 970 of Chapter 15, exercises 1, 2, 5, 8, and 11. 
 */

// Class ArrayIntList can be used to store a list of integers.

import java.util.*;

public class ArrayIntList {

    private int[] elementData; // list of integers
    private int size;          // current number of elements in the list

    public static final int DEFAULT_CAPACITY = 100;

    // pre : capacity >= 0 (throws IllegalArgumentException if not)
    // post: constructs an empty list with the given capacity
    public ArrayIntList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        elementData = new int[capacity];
        size = 0;
    }

    // post: constructs an empty list of default capacity
    public ArrayIntList() {
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
        for (int i = 0; i < size; i++) {
            if (elementData[i] == value) {
                return i;
            }
        }
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

    // pre : size() < capacity (throws IllegalStateException if not)
    // post: appends the given value to the end of the list
    public void add(int value) {
        ensureCapacity(size + 1); //this public method throws the exception
        elementData[size] = value;
        size++;
    }

    // pre : size() < capacity (throws IllegalStateException if not) &&
    //       0 <= index <= size() (throws IndexOutOfBoundsException if not)
    // post: inserts the given value at the given index, shifting subsequent
    //       values right
    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
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

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: replaces the integer at the given index with the given value
    public void set(int index, int value) {
        checkIndex(index);
        elementData[index] = value;
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
    
    // question 1
    // post: accepts an integer as a parameter and returns the index
    //		in the list of the last occurrence of that value
	public int lastIndexOf(int theValue) {
		//set the index to -1 for in case cannot find that value
		int index = -1;
		//start from the end
		for(int i=size-1;i>=0;i--) {
			if(elementData[i] == theValue) {
				//if find that value, set the index and quickly jump out the loop
				index = i;
				break;
			}
		}
		return index;
	}
	
	// question 2
	// post: accepts another list L as a parameter and returns the starting index
	//		of where L first appears in this list, or -1 if it is not found
    public int indexOfSubList(ArrayIntList L) {
    	//set the index to -1 for in case cannot find that list
    	int index = -1;
    	//loop through the elementData
    	for(int i=0;i<size;i++) {
    		// check whether the element of two array match
    		for(int a=0;a<L.size();a++) {
    			if(elementData[i+a] != L.get(a)) {
    				// if not match, then no need to keep going
    				break;
    			}else if(a==L.size()-1){
    				// if match, set index to current i
    				index = i;
    			}
    		}
    		//if i has been set or the rest element is less than L's length, then jump out
    		if(index != -1 || size-i<L.size()) {
    			break;
    		}
    	}
    	return index;
    }
    
    // question 5
    // post: returns a new ArrayIntList that contains a running total of the original list
    public ArrayIntList runningTotal() {
    	// create a new ArrayIntList with the same capacity
    	ArrayIntList aNewCopy = new ArrayIntList(elementData.length);
    	// create a integer to keep track of the current total value
    	int newValue = 0;
    	for(int i=0;i<size;i++) {
    		newValue = newValue+elementData[i];
    		aNewCopy.add(newValue);
    	}
    	return aNewCopy;
    }
    
 	// question 8
    // post: accept an element value as a parameter and returns the number of occurrences
    //		of that value in the list
    public int count(int value) {
    	// for counting times
    	int timeAppear = 0;
    	for(int i=0;i<size;i++) {
    		// if the current elementData value equals to the input value
    		if(elementData[i] == value) {
    			timeAppear++;
    		}
    	}
    	return timeAppear;
    }
    
    // question 11
    // post: removes and returns the last value from a list integers
    public int removeLast() {
    	//check whether the list is empty
    	if(size<=0) {
    		throw new NoSuchElementException("The list is empty");
    	}else {
    		//get the number on id = size-1 before removing it
    		int theNum = elementData[size-1];
    		//remove the number
    		remove(size-1);
    		//then return it
    		return theNum;
    	}
    }
}
