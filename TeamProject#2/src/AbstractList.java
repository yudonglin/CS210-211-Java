import java.util.Iterator;

public abstract class AbstractList<E> implements List<E> {
	private int size;
	
	// post: returns the current number of elements in the list
	public int size() {
	   return size;
	}
	
	// post: returns true if list is empty, false otherwise
	public boolean isEmpty() {
        return size == 0;
    }
	
	//test, remove later
	public void setSize(int value) {
		size = value;
	}
	public void clear() {
		size = 0;
	}
	
	protected void checkIndex(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
	}
	
	// post: appends all values in the given list to the end of this list
    public void addAll(List<E> other) {
        for (E value: other) {
            add(value);
        }
    }
    
	// post: appends the given value to the end of the list
	public void add(E value) {
	    add(size, value);
	}
    
	public void addChecker(int index, E value) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        size++;
	}
    
	public abstract class AbstractIterator implements Iterator<E> {
        private boolean removeOK;  // whether it's okay to remove now
        // post: constructs an iterator for the given list
        public void setremoveOK(boolean situation) {
            removeOK = situation;
        }
        // pre : next() has been called without a call on remove (i.e., at most
        //       one call per call on next)
        // post: removes the last element returned by the iterator
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            setSize(size()-1);
            removeOK = false;
        }
    }
}
