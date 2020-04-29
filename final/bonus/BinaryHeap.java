/***********************************
* File name: BinaryHeap.java
* Author: Last name, first name
* Student ID: 
* EECS login ID: 
************************************/

public class BinaryHeap<AnyType extends Comparable<? super AnyType>>
{

    // Basic node stored in a heap
    private static class BinaryNode<AnyType>
    {
            // Constructors
        BinaryNode( AnyType theElement )
        {
            this( theElement, null, null, null );
        }

        BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt, BinaryNode<AnyType> pt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
	    parent   = pt;
        }

        AnyType element;            // The data in the node
        BinaryNode<AnyType> left;   // Left child
        BinaryNode<AnyType> right;  // Right child
        BinaryNode<AnyType> parent; // Parent
    }


      /** The tree root */
    private BinaryNode<AnyType> root;

      /** The number of items in the heap */
    private int size;

      /** You may define any other variables/attributes as you wish. */


    /**
     * Print the heap contents.
     */
    public void printTree( )
    {
        if( isEmpty( ) )
            System.out.print( "Empty tree" );
        else
            printTree( root );
	System.out.println();
    }


    /**
     * Internal method to print a subtree using inorder traversal.
     * @param t the node that roots the subtree.
     */
    private void printTree( BinaryNode<AnyType> t )
    {
        if( t != null )
        {
            printTree( t.left );
            printNode(t);
            printTree( t.right );
        }
    }
   

    /**
     * Internal method to print a node.
     * @param t the node to be printed.
     */
    private void printNode(BinaryNode<AnyType> t)
    {
	if (t!= null)
		System.out.print(t.element + " ");
    }


	/**************************************************************
 	* DO NOT ADD ANYTHING ABOVE THIS LINE EXCEPT YOUR STUDENT INFO
 	***************************************************************/

    /** 
     * You may define any other variables as you wish, 
     * for instance, the pointer to the last node 
     */

   	 // DO NOT CHANGE the method declarations.
 	 // Do not use global variables.
	 // You may add your own helper methods/subroutines to this file.

    /** 
     * Implement the CONSTRUCTOR(S)
     */
    public BinaryHeap( )
    {
        
	// COMPLETE THIS METHOD

    }


    /**
     * Test if the priority queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {

	// COMPLETE THIS METHOD
	return true;

    }


    /**
     * Insert into the priority queue, maintaining heap order.
     * @param x the item to insert.
     */
    public void insert( AnyType x )
    {
        
	// COMPLETE THIS METHOD

    }



    /**
     * Remove the smallest item from the priority queue.
     * @return the smallest item.  If the heap is empty, print an error 
     * message to the standard output and return null.
     */
    public AnyType deleteMin( )
    {

	// COMPLETE THIS METHOD
	return null;

    }

}  // end public class BinaryHeap
