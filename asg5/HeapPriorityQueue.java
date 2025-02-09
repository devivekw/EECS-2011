/***********************************

************************************/

/* LAST UPDATED: MARCH 28, 2016, 1:15PM */

/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 */

import java.util.ArrayList;
import java.util.Comparator;

/**
 * An implementation of a priority queue using an array-based heap.
 *
 */
public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
  private static final int Entry = 0;
  /** primary collection of priority queue entries */
  protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

  /**
   * Creates an empty priority queue based on the natural ordering of its keys.
   */
  public HeapPriorityQueue() {
    super();
    // Entry<K,V> zeroPos = new Entry<>(0, 0);
    heap.add(Entry(0, 0)); // add to the end of the list
  }

  private Entry<K, V> Entry(final int i, final int j) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * Creates an empty priority queue using the given comparator to order keys.
   * 
   * @param comp comparator defining the order of keys in the priority queue
   */
  public HeapPriorityQueue(final Comparator<K> comp) {
    super(comp);
  }

  /**
   * Creates a priority queue initialized with the respective key-value pairs. The
   * two arrays given will be paired element-by-element. They are presumed to have
   * the same length. (If not, entries will be created only up to the length of
   * the shorter of the arrays)
   * 
   * @param keys   an array of the initial keys for the priority queue
   * @param values an array of the initial values for the priority queue
   */
  public HeapPriorityQueue(final K[] keys, final V[] values) {
    super();
    for (int j = 0; j < Math.min(keys.length, values.length); j++)
      heap.add(new PQEntry<>(keys[j], values[j]));
    heapify();
  }

  // protected utilities
  protected int parent(final int j) {
    return (j) / 2;
  } // truncating division

  protected int left(final int j) {
    return 2 * j;
  }

  protected int right(final int j) {
    return 2 * j + 1;
  }

  protected boolean hasLeft(final int j) {
    return left(j) < heap.size();
  }

  protected boolean hasRight(final int j) {
    return right(j) < heap.size();
  }

  /** Exchanges the entries at indices i and j of the array list. */
  protected void swap(final int i, final int j) {
    final Entry<K, V> temp = heap.get(i);
    heap.set(i, heap.get(j));
    heap.set(j, temp);
  }

  /**
   * Moves the entry at index j higher, if necessary, to restore the heap
   * property.
   */
  protected void upheap(int j) {
    while (j > 1) { // continue until reaching root (or break statement)
      final int p = parent(j);
      if (compare(heap.get(j), heap.get(p)) >= 1)
        break; // heap property verified
      swap(j, p);
      j = p; // continue from the parent's location
    }
  }

  /**
   * Moves the entry at index j lower, if necessary, to restore the heap property.
   */
  protected void downheap(int j) {
    while (hasLeft(j)) { // continue to bottom (or break statement)
      final int leftIndex = left(j);
      int smallChildIndex = leftIndex; // although right may be smaller
      if (hasRight(j)) {
        final int rightIndex = right(j);
        if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0)
          smallChildIndex = rightIndex; // right child is smaller
      }
      if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0)
        break; // heap property has been restored
      swap(j, smallChildIndex);
      j = smallChildIndex; // continue at position of the child
    }
  }

  /** Performs a bottom-up construction of the heap in linear time. */
  protected void heapify() {
    final int startIndex = parent(size()); // start at PARENT of last entry
    for (int j = startIndex; j >= 1; j--) // loop until processing the root
      downheap(j);
  }

  // public methods

  /**
   * Returns the number of items in the priority queue.
   * 
   * @return number of items
   */
  @Override
  public int size() {
    return heap.size() - 1;
  }

  /**
   * Returns (but does not remove) an entry with minimal key.
   * 
   * @return entry having a minimal key (or null if empty)
   */
  @Override
  public Entry<K, V> min() {
    if (heap.isEmpty())
      return null;
    return heap.get(1);
  }

  /**
   * Inserts a key-value pair and return the entry created.
   * 
   * @param key   the key of the new entry
   * @param value the associated value of the new entry
   * @return the entry storing the new key-value pair
   * @throws IllegalArgumentException if the key is unacceptable for this queue
   */
  @Override
  public Entry<K, V> insert(final K key, final V value) throws IllegalArgumentException {
    checkKey(key); // auxiliary key-checking method (could throw exception)
    final Entry<K, V> newest = new PQEntry<>(key, value);
    heap.add(newest); // add to the end of the list
    upheapRec(heap.size() - 1); // upheap newly added entry
    return newest;
  }

  /**
   * Removes and returns an entry with minimal key.
   * 
   * @return the removed entry (or null if empty)
   */
  @Override
  public Entry<K, V> removeMin() {
    if (heap.isEmpty())
      return null;
    final Entry<K, V> answer = heap.get(1);
    swap(1, heap.size() - 1); // put minimum item at the end
    heap.remove(heap.size() - 1); // and remove it from the list;
    downheapRec(1); // then fix new root
    return answer;
  }

  /** Used for debugging purposes only */
  private void sanityCheck() {
    for (int j = 1; j < heap.size(); j++) {
      final int left = left(j);
      final int right = right(j);
      if (left < heap.size() && compare(heap.get(left), heap.get(j)) < 0)
        System.out.println("Invalid left child relationship");
      if (right < heap.size() && compare(heap.get(right), heap.get(j)) < 0)
        System.out.println("Invalid right child relationship");
    }
  }

  /** Used to print heap */
  public void printHeap() {
    for (int i = 1; i < heap.size(); i++)
      System.out.print(heap.get(i).getKey() + "  ");
    System.out.println();
  }

  // ***************************************
  // DO NOT MODIFY THE CODE ABOVE THIS LINE.
  // ADD YOUR CODE BELOW THIS LINE.
  //
  // ***************************************

  /**
   * Moves the entry at index j higher, if necessary, to restore the heap
   * property. Use recursion. Do NOT use any kind of loop. Running time: O(logn)
   */
  protected void upheapRec(final int j) {

    // COMPLETE THIS METHOD

    // Use recursion. Do NOT use any kind of loop.

    if (j > 1) {
      final int p = parent(j);
      if (compare(heap.get(j), heap.get(p)) < 1) {
        swap(j, p);
        upheapRec(p);
      }
    }

  } // end upheapRec

  /**
   * Moves the entry at index j lower, if necessary, to restore the heap property.
   * Use recursion. Do NOT use any kind of loop. Running time: O(logn)
   */
  protected void downheapRec(final int j) {

    // COMPLETE THIS METHOD

    // Use recursion. Do NOT use any kind of loop.
    if (hasLeft(j)) {
      final int leftIndex = left(j);
      int smallChildIndex = leftIndex;
      if (hasRight(j)) {
        final int rightIndex = right(j);
        if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0) {
          smallChildIndex = rightIndex;
        }
      }
      if (compare(heap.get(smallChildIndex), heap.get(j)) < 0) {
        swap(smallChildIndex, j);
        downheapRec(smallChildIndex);
      }
    }

  } // end downheapRec

  /**
   * Update a key and restore the heap property if necessary. Running time: O(n)
   * Input: key "currentKey" Action: search for "currentKey"; change "currentKey"
   * to a new value "newKey"; then restore the heap property if necessary. Output:
   * returns the array index of the entry having the key "newKey". If "currentKey"
   * was not found, return -1. Note: You may use loops in this method.
   */
  public int updateKey(final K currentKey, final K newKey) {

    // COMPLETE THIS METHOD

    // You may use loops in this method.
    // for (int i = 1; i < heap.size(); i++) {
    // if (heap.get(i).getKey().equals(currentKey)) {
    // PQEntry<K, V> tmp = new PQEntry<K, V>(heap.get(i).getKey(),
    // heap.get(i).getValue());
    // tmp.setKey(newKey);
    // heap.set(i, tmp);
    // upheapRec(i);
    // downheapRec(i);
    // return heap.size() - i - 1;
    // }
    // }

    for (int j = 1; j < heap.size(); j++) {
      K jkey = heap.get(j).getKey();
      V jvalue = heap.get(j).getValue();
      if (jkey.equals(currentKey)) {
        PQEntry<K, V> tempEntry = new PQEntry<K, V>(jkey, jvalue);
        tempEntry.setKey(newKey);
        upheapRec(j);
        downheapRec(j);
        return heap.size() - j - 1;
      }
    }

    return (-1); // replace this line with your code

  } // end updateKey

} // class HeapPriorityQueue
