import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class AbstractList<E> implements List<E> {
	private int size;
	private AbstractList<E> l = this; //store the list itself
	
	// post: returns the current number of elements in the list
	public int size() {
	   return size;
	}
	
	// post: returns true if list is empty, false otherwise
	public boolean isEmpty() {
        return size == 0;
    }
	
	public void clear() {
		size = 0;
	}
	
	public void checkIndex(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
	}
	
	public void set(int index, E value) {
	    checkIndex(index);
	    l.remove(index);
	    l.add(index, value);
	}
	
	// post: appends all values in the given list to the end of this list
    public void addAll(List<E> other) {
    	Iterator<E> itr = other.iterator();
        while(itr.hasNext()) {
        	l.add(itr.next());
        }
    }
    
	// post: appends the given value to the end of the list
	public void add(E value) {
	    l.add(size, value);
	}
    
	public void addChecker(int index, E value) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        size++;
	}
	
    // post: returns true if the given value is contained in the list,
    //       false otherwise
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }
	
	// post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(E value) {
    	if (size == 0) {
			return -1;
		} else {
			int index = 0;
			Iterator<E> itr = l.iterator();
			while (itr.hasNext()) {
				if(value.equals(itr.next())) {
					return index;
				}else {
					index++;
				}
			}
			return -1;
		}
    }
    
    //
    public void remove(int index) {
        checkIndex(index);
        size--;
    }
	
	public String toString() {
		if (size == 0) {
			return "[]";
		} else {
			Iterator<E> itr = l.iterator();
			while (itr.hasNext()) {
				E first = itr.next();
				String result = "[" + first;
				for (int i = 1; i < size; i++) {
					E next = itr.next();
					result += ", " + next;
					}
				result += "]";
				return result;
			}
		}
		return null;
	}
	
	public void iteratorTester() { //This method is just to demonstrate that the iterator works. Delete later.
		Iterator<E> itr = l.iterator();
		while (itr.hasNext()) {
			System.out.println("Iterator: " + itr.next());
		}
	}
    
	public abstract class AbstractIterator implements Iterator<E> {
		private int position; 
        private boolean removeOK;
        
        public void setremoveOK(boolean situation) {
            removeOK = situation;
        }
        
        public void setPos(int value) {
        	position = value;
        }
        
        public int getPos() {
        	return position;
        }
        
        // post: returns true if there are more elements left, false otherwise
        public boolean hasNext() {
            return position < size();
        }
        
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = l.get(position);
            position++;
            setremoveOK(true);
            return result;
        }
        
        // pre : next() has been called without a call on remove (i.e., at most
        //       one call per call on next)
        // post: removes the last element returned by the iterator
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
