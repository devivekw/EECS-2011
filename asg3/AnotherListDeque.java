import asg3.DNode;
import asg3.EmptyDequeException;

/***********************************
 * EECS2011 - Assignment 3 File name: AnotherListDeque.java Author: Wadhwani,
 * Vivek Email: vivek121@my.yorku.ca EECS username: vivek121
 ************************************/

public class AnotherListDeque {

  protected DNode head, tail; // head and tail contain actual data (int)

  protected int size; // number of elements

  public AnotherListDeque() // constructor: initialize an empty deque
  {
    head = tail = null;
    size = 0;
  }

  /**
   * Display the content of the deque
   *
   */
  public void printDeque() {

    for (DNode p = head; p != null; p = p.getNext())
      System.out.print(p.getElement() + " ");

    System.out.println();

  }

  // ***************************************
  // DO NOT MODIFY THE CODE ABOVE THIS LINE.
  // ADD YOUR CODE BELOW THIS LINE.
  //
  // ***************************************

  /**
   * Returns the number of items in this collection.
   * 
   * @return the number of items in this collection.
   */
  public int size() {
    // COMPLETE THIS METHOD

    return size;// replace this line with your code
  }

  /**
   * Returns true if this collection is empty.
   * 
   * @return true if this collection is empty.
   */
  public boolean isEmpty() {
    // COMPLETE THIS METHOD

    return head == null || tail == null; // replace this line with your code
  }

  /**
   * Returns the first element of the deque
   * 
   */
  public int getFirst() throws EmptyDequeException {
    // COMPLETE THIS METHOD

    if (isEmpty())
      throw new EmptyDequeException("Empty Deck!");

    return head.getElement(); // replace this line with your code
  }

  /**
   * Returns the last element of the deque
   * 
   */
  public int getLast() throws EmptyDequeException {
    // COMPLETE THIS METHOD
    if (isEmpty())
      throw new EmptyDequeException("Empty Deck!");

    return tail.getElement();
  }

  /**
   * Inserts e at the beginning (as the first element) of the deque
   * 
   */
  public void insertFirst(int e) {
    // COMPLETE THIS METHOD

    DNode newNode = new DNode(e, null, head);

    if (isEmpty()) {
      tail = newNode;
    } else {
      head.setPrev(newNode);
    }

    head = newNode;
    size++;
  }

  /**
   * Inserts e at the end (as the last element) of the deque
   * 
   */
  public void insertLast(int e) {
    // COMPLETE THIS METHOD
    DNode newNode = new DNode(e, tail, null);

    if (isEmpty()) {
      head = newNode;
    } else {
      tail.setNext(newNode);
    }

    tail = newNode;
    size++;
  }

  /**
   * Removes and returns the first element of the deque
   * 
   */
  public int removeFirst() throws EmptyDequeException {
    // COMPLETE THIS METHOD
    if (isEmpty())
      throw new EmptyDequeException("Empty Deck!");

    if (head.getNext() == null) {
      tail = null;
    } else {
      head.getNext().setPrev(null);
    }
    int remove = head.getElement();
    head = head.getNext();
    return remove; // replace this line with your code
  }

  /**
   * Removes and returns the last element of the deque
   * 
   */
  public int removeLast() throws EmptyDequeException {
    // COMPLETE THIS METHOD

    if (isEmpty())
      throw new EmptyDequeException("Empty Deck!");

    if (tail.getPrev() == null) {
      head = null;
    } else {
      tail.getPrev().setNext(null);
    }

    int remove = tail.getElement();
    tail = tail.getPrev();
    return remove; // replace this line with your code
  }

} // end class
