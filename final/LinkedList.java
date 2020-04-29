/***********************************
 * File name: LinkedList.java Author: Wadhwani, Vivek Student ID: 216699613
 * login ID: vivek121
 ************************************/

public class LinkedList {
	public class Node {
		private int data;
		private Node next;

		// Constructor
		public Node(int d) {
			data = d;
			next = null;
		} // end constructor Node
	} // end class Node

	private Node head; // head of linked list

	// Constructor
	public LinkedList() {
		head = null;
	} // end constructor LinkedList

	public void insert(int d) {
		Node p = new Node(d);
		if (head != null)
			p.next = head;
		head = p;
	} // end insert

	public void printList() {
		Node p = head;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		} // end while
		System.out.println();
	}

	/**************************************************************
	 * DO NOT ADD ANYTHING ABOVE THIS LINE EXCEPT YOUR STUDENT INFO
	 ***************************************************************/

	/*
	 * Returns the number of times integer k appears in the linked list. Returns 0
	 * if the linked list does not contain integer k or is empty. Add a brief
	 * description of how your algorithm works below.
	 */

	/*
	 * Brief description: ....................................
	 * 
	 */

	public int numOfTimes(int k) {
		// COMPLETE THIS METHOD.

		// DO NOT CHANGE the above method declaration.

		// You may define local variables inside this method. Do not use global
		// variables.

		// You may add your own helper methods/subroutines to this file.

		return numOfTimesHelper(k, head, 0); // replace this line with your code
	} // end numOfTimes

	public int numOfTimesHelper(int k, Node nextNode, int counter) {
		if (nextNode == null) {
			return counter;
		}

		if (nextNode.data == k) {
			counter++;
		}

		return numOfTimesHelper(k, nextNode.next, counter);
	}

} // end class LinkedList
