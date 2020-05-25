/*
 * Group 1: Jacob Patton, Kevin Akers, Milan Gurung, Yudong Lin
 * CS211
 * 5/24/2020
 * 
 * Utilized in Group Assignment #2.
 * This is the list interface. It defines the methods that must appear in classes that implement it.
 * No changes have been made to this class aside from this header.
*/

// Generic interface for a List of E objects.

public interface List<E> extends Iterable<E> {
    public int size();
    public E get(int index);
    public int indexOf(E value);
    public boolean isEmpty();
    public boolean contains(E value);
    public void add(E value);
    public void add(int index, E value);
    public void addAll(List<E> other);
    public void remove(int index);
    public void set(int index, E value);
    public void clear();
}
