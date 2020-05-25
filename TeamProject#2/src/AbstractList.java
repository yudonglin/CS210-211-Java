/*
 * Group 1: Jacob Patton, Kevin Akers, Milan Gurung, Yudong Lin
 * CS211
 * 5/24/2020
 * 
 * Made for Group Assignment #2.
 * This is the AbstractList class. It unifies the LinkedList and ArrayList classes, causing them to
 * share various methods; reducing redundancy.
*/

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class AbstractList<E> implements List<E> {
	private int size; //Keep track of the size of the list
	private AbstractList<E> l = this; //store the list itself
	
	//Methods in this class are stored in the same order as they are in the list interface.
	
	// post: returns the current number of elements in the list
	public int size() {
	   return size;
	}
	
	//Post: Return the index of a given value. Returns -1 if the value is not found.
    public int indexOf(E value) {
    	if (size == 0) {
			return -1;
		} else {
			int index = 0;
			Iterator<E> itr = l.iterator();
			while (itr.hasNext()) {
				if(value.equals(itr.next())) {
					return index;
				} else {
					index++;
				}
			}
			return -1;
		}
    }
	
	// post: returns true if list is empty, false otherwise
	public boolean isEmpty() {
        return size == 0;
    }
	
    //Post: Return whether or not an item is in a list.
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }
	
	//Post: Append a value to the end of the list.
	public void add(E value) {
	    add(size, value);
	}
	
	//Post: Append all values from one list to the end of the current list.
    public void addAll(List<E> other) {
    	Iterator<E> itr = other.iterator();
        while(itr.hasNext()) {
        	l.add(itr.next());
        }
    }
    
    //Remove function that checks the validity of a remove and reduces the size. Called from the subclasses.
    public void remove(int index) {
        checkIndex(index);
        size--;
    }
    
	//Replace a sepcific index with another value.
	public void set(int index, E value) {
	    l.remove(index); //Remove the item at the index
	    l.add(index, value); //Add the new item at that index
	}
	
    //post: clear out the contents of the list, rendering it empty.
  	public void clear() {
  		size = 0;
  	}
    
    //Convert the list to a String
    public String toString() {
		if (size == 0) {
			return "[]";
		} 
		else {
			Iterator<E> itr = l.iterator();
			String result = "[" + itr.next();
			while (itr.hasNext()) {
				result += ", " + itr.next();
			}
			result += "]";
			return result;
			}
	} 
    
	//throw an error if the index is not valid
	public void checkIndex(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
	}
	
	//throw an error if the index is not valid. Designed mostly for add statements, as it expands the list for adds.
	public void addChecker(int index, E value) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        size++;
	}
    
	
	
	
	public abstract class AbstractIterator implements Iterator<E> { //The abstract list iterator
		private int position; //Keep track of where the iterator is
        private boolean removeOK; //Keep track of whether or not it's okay to remove
        
        //Set whether or not it's okay to remove the current item grabbed by the iterator
        public void setremoveOK(boolean situation) {
            removeOK = situation;
        }
        
        //Move the position to a specific point
        public void setPos(int value) {
        	position = value;
        }
        
        //Return the current position
        public int getPos() {
        	return position;
        }
        
        //Post: Return true if there are still elements left to pass over.
        public boolean hasNext() {
            return position < size();
        }
        
        //Move through the list
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = l.get(position);
            position++;
            setremoveOK(true);
            return result;
        }
        
        //Pre: removeOK must be true
        //Post: Remove the element currently held by the iterator.
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            size--;
            position--;
            removeOK = false;
        }
    }
}
