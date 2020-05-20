// Class ArrayList<E> can be used to store a list of values of type E.

import java.util.*;

public class ArrayList<E> extends AbstractList<E>{
    private E[] elementData; // list of values

    public static final int DEFAULT_CAPACITY = 100;

    // pre : capacity >= 0 (throws IllegalArgumentException if not)
    // post: constructs an empty list with the given capacity
    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        elementData = (E[]) new Object[capacity];
        setSize(0);
    }

    // post: constructs an empty list of default capacity
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the value at the given index in the list
    public E get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (size() == 0) {
            return "[]";
        } else {
            String result = "[" + elementData[0];
            for (int i = 1; i < size(); i++) {
                result += ", " + elementData[i];
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(E value) {
        for (int i = 0; i < size(); i++) {
            if (elementData[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    // post: returns true if the given value is contained in the list,
    //       false otherwise
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }
    
    // pre : 0 <= index <= size() (throws IndexOutOfBoundsException if not)
    // post: inserts the given value at the given index, shifting subsequent
    //       values right
    public void add(int index, E value) {
    	addChecker(index,value);
        ensureCapacity(size() + 1);
        for (int i = size(); i >= index + 1; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size() - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[size() - 1] = null;
        setSize(size()-1);
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: replaces the value at the given index with the given value
    public void set(int index, E value) {
        checkIndex(index);
        elementData[index] = value;
    }

    // post: list is empty
    public void clear() {
        for (int i = 0; i < size(); i++) {
            elementData[i] = null;
        }
        super.clear();
    }

    // post: returns an iterator for this list
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    // post: ensures that the underlying array has the given capacity; if not,
    //       the size is doubled (or more if given capacity is even larger)
    public void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newCapacity = elementData.length * 2 + 1;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    private class ArrayListIterator extends AbstractIterator {
        private int position;           // current position within the list
        
        // post: constructs an iterator for the given list
        public ArrayListIterator() {
            position = 0;
            setremoveOK(false);
        }

        // post: returns true if there are more elements left, false otherwise
        public boolean hasNext() {
            return position < size();
        }

        // pre : hasNext() (throws NoSuchElementException if not)
        // post: returns the next element in the iteration
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = elementData[position];
            position++;
            setremoveOK(true);
            return result;
        }

        // pre : next() has been called without a call on remove (throws
        //       IllegalStateException if not)
        // post: removes the last element returned by the iterator
        public void remove() {
            super.remove();
            ArrayList.this.remove(position - 1);
            position--;
        }
    }
}
