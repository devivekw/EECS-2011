
/***********************************
* File name: BinaryTreeMain.java
************************************/

import java.util.Scanner;

public class BinaryTreeMain {
	public static final int STOPVALUE = -999;

	public static void main(String[] args) {
		BinaryTree myTree = new BinaryTree();
		int k;
		Scanner input = new Scanner(System.in);

		// Get input from user to build a binary tree
		// k = input.nextInt();

		// while (k != STOPVALUE) {
		// myTree.insert(k);
		// k = input.nextInt();
		// }

		for (int i = -12; i < 16; i++) {
			myTree.insert(i);
		}

		if (myTree.hasZero())
			System.out.println("Yes");
		else
			System.out.println("No");
	} // end main
} // end class BinaryTreeMain