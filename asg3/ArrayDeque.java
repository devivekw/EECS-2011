package asg3;

import java.io.FileNotFoundException;

/***********************************

 ************************************/

public class ArrayDeque {
	public static final int INIT_CAPACITY = 8; // initial array capacity
	protected int capacity; // current capacity of the array
	protected int front; // index of the front element
	protected int rear; // index of the rear element
	protected int[] A; // array deque

	public ArrayDeque() // constructor method
	{
		A = new int[INIT_CAPACITY];
		capacity = INIT_CAPACITY;
		front = rear = 0;
	}

	/**
	 * Display the content of the deque
	 * 
	 */
	public void printDeque() {
		for (int i = front; i != rear; i = (i + 1) % capacity)
			System.out.print(A[i] + " ");

		System.out.println();
	}

	/**
	 * Display the content of the whole array
	 *
	 */
	public void printArray() {
		for (int i = 0; i < capacity; i++)
			System.out.print(A[i] + " ");

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

		// Hint: size can be computed from capacity, front and rear.

		return (capacity - front + rear) % capacity; // replace this line with your code
	}

	/**
	 * Returns true if this collection is empty.
	 * 
	 * @return true if this collection is empty.
	 */
	public boolean isEmpty() {
		// COMPLETE THIS METHOD

		return front == rear; // replace this line with your code
	}

	/**
	 * Returns the first element of the deque
	 * 
	 */
	public int getFirst() throws EmptyDequeException {
		// COMPLETE THIS METHOD
		if (isEmpty())
			throw new EmptyDequeException("Empty Deque");

		return A[front]; // replace this line with your code
	}

	/**
	 * Returns the last element of the deque
	 * 
	 */
	public int getLast() throws EmptyDequeException {
		// COMPLETE THIS METHOD
		if (isEmpty())
			throw new EmptyDequeException("empty deque");

		return A[(rear - 1 + capacity) % capacity]; // replace this line with your code
	}

	/**
	 * Inserts e at the beginning (as the first element) of the deque
	 * 
	 */
	public void insertFirst(final int e) {
		// COMPLETE THIS METHOD
		if (size() + 1 == capacity) {
			int[] tempArray = new int[2 * capacity];

			for (int i = 0; i <= rear; i++)
				tempArray[i] = A[i];

			for (int i = capacity + front; i < tempArray.length; i++)
				tempArray[i] = A[i - capacity];

			front = capacity + front;
			capacity *= 2;
			A = tempArray;
		}

		// normal entry
		if (isEmpty()) {
			front = 0;
			rear = 1;
		} else {
			front = (front - 1 + capacity) % capacity;
		}

		A[front] = e;
	}

	/**
	 * Inserts e at the end (as the last element) of the deque
	 * 
	 */
	public void insertLast(final int e) {
		// COMPLETE THIS METHOD
		if (size() + 1 == capacity) {
			// double the array
			int[] tempArray = new int[2 * capacity];

			for (int i = 0; i <= rear; i++)
				tempArray[i] = A[i];

			for (int i = capacity + front; i < tempArray.length; i++)
				tempArray[i] = A[i - capacity];

			front = capacity + front;
			capacity *= 2;
			A = tempArray;
		}

		if (isEmpty()) {
			A[front] = e;
			rear = 1;
		} else {
			A[rear] = e;
			rear = (rear + capacity + 1) % capacity;
		}
	}

	/**
	 * Removes and returns the first element of the deque
	 * 
	 */
	public int removeFirst() throws EmptyDequeException {
		// COMPLETE THIS METHOD
		if (isEmpty())
			throw new EmptyDequeException("Empty Deck!");

		// half the array
		if (size() <= capacity / 4 && size() >= 4) {
			int[] tempArray = new int[capacity / 2];

			for (int i = 0; i <= rear; i++)
				tempArray[i] = A[i];

			for (int i = front - tempArray.length; i < tempArray.length; i++)
				tempArray[i] = A[i + tempArray.length];

			front = front - tempArray.length;
			capacity /= 2;
			A = tempArray;
		}

		final int result = A[front];
		A[front] = 0;
		front = (front + capacity + 1) % capacity;
		return result;

	}

	/**
	 * Removes and returns the last element of the deque
	 * 
	 */
	public int removeLast() throws EmptyDequeException {
		// COMPLETE THIS METHOD
		if (isEmpty())
			throw new EmptyDequeException("Empty Deck!");

		final int result = A[(rear - 1 + capacity) % capacity];
		A[(rear - 1 + capacity) % capacity] = 0;
		rear = (rear - 1 + capacity) % capacity;
		return result;

	}

} // end class
