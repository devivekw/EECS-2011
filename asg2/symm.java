package asg2;
import java.util.Arrays;
/***********************************
* CSE2011 - Assignment 2
* File name: symm.java
************************************/


public class symm
{
/* 
 * Returns true if array A is symmetric.
 * Returns false otherwise.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O(N).
 * You may add a brief explanation here if you wish.
 */

public static boolean symmetric( final int[] A, final int n)
{
    // COMPLETE THIS METHOD.

    // You may define local variables inside this method.

    // You may add your own methods/subroutines to this file.

    if (n<=1)
        return true;        
    else if (n == 2){
        if (A[0]==A[1])
            return true;
        else
            return false;
    }
    
    else{
        if (A[0]==A[n-1]){
            return symmetric(Arrays.copyOfRange(A, 1, n-1), Arrays.copyOfRange(A, 1, n-1).length);
        }
        else
            return false;
    }
}  


}  // end class

