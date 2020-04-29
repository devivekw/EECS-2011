package asg3;

/***********************************

 ************************************/

public class ListDeque {

    protected DNode header, trailer; // dummy nodes

    protected int size; // number of elements

    public ListDeque() // constructor: initialize an empty deque
    {
        header = new DNode(0, null, null);
        trailer = new DNode(0, null, null);
        header.setNext(trailer); // make header point to trailer
        trailer.setPrev(header); // make trailer point to header
        size = 0;
    }

    /**
     * Display the content of the deque
     *
     */
    public void printDeque() {
        for (DNode p = header.getNext(); p != trailer; p = p.getNext())
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

        return size; // replace this line with your code
    }

    /**
     * Returns true if this collection is empty.
     * 
     * @return true if this collection is empty.
     */
    public boolean isEmpty() {
        // COMPLETE THIS METHOD

        return (size == 0); // replace this line with your code
    }

    /**
     * Returns the first element of the deque
     * 
     */
    public int getFirst() throws EmptyDequeException {
        // COMPLETE THIS METHOD
        if (isEmpty())
            throw new EmptyDequeException("Empty Deque");

        return header.getNext().getElement(); // replace this line with your code
    }

    /**
     * Returns the last element of the deque
     * 
     */
    public int getLast() throws EmptyDequeException {
        // COMPLETE THIS METHOD
        if (isEmpty())
            throw new EmptyDequeException("Empty Deque");

        return trailer.getPrev().getElement(); // replace this line with your code
    }

    /**
     * Inserts e at the beginning (as the first element) of the deque
     * 
     */
    public void insertFirst(final int e) {
        // COMPLETE THIS METHOD
        DNode newFirst = new DNode(e, header, header.getNext());
        header.getNext().setPrev(newFirst);
        header.setNext(newFirst);
        size++;
    }

    /**
     * Inserts e at the end (as the last element) of the deque
     * 
     */
    public void insertLast(final int e) {
        // COMPLETE THIS METHOD
        DNode newLast = new DNode(e, trailer.getPrev(), trailer);
        trailer.getPrev().setNext(newLast);
        trailer.setPrev(newLast);
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

        DNode remove = header.getNext();
        header.setNext(remove.getNext());
        remove.getNext().setPrev(header);
        size--;
        return remove.getElement(); // replace this line with your code
    }

    /**
     * Removes and returns the last element of the deque
     * 
     */
    public int removeLast() throws EmptyDequeException {
        // COMPLETE THIS METHOD
        DNode remove = trailer.getPrev();
        trailer.setPrev(remove.getPrev());
        remove.getPrev().setNext(trailer);
        size--;
        return remove.getElement(); // replace this line with your code
    }

} // end class
