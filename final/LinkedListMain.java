
/***********************************
* File name: LinkedListMain.java
************************************/

import java.util.Scanner;

public class LinkedListMain {
	public static final int STOPVALUE = -999;

	public static void main(String[] args) {
		LinkedList myList = new LinkedList();

		myList.insert(1);
		myList.insert(2);
		myList.insert(3);
		myList.insert(4);
		myList.insert(5);
		myList.insert(2);

		// Get integer k from user
		// k = input.nextInt();
		int k = 89;
		int num = myList.numOfTimes(k);
		System.out.print(k + " appears " + num + " time(s).");
		System.out.println();

	} // end main
} // end class LinkedListMain