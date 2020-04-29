package asg2;
import java.util.Arrays;
/***********************************
* CSE2011 - Assignment 2
* File name: kthsmall.java
* Author: Wadhwani, Vivek
* Email: vivek121@my.yorku.ca
* CSE number: 216699613
************************************/




public class kthsmallest {

    public static final int MaxSize = 500;
    
    /*
     * Return the value of the kth smallest element of array A.
     * n is the number of elements A contains, and k <= n.
     * The running time of your algorithm must be O(n).
     *
     */
    
    //kth smallest
    public static int find_kth_smallest(int[] A, int n, int k) {
        return helper(A, n, k, A[n - 1]);
    }  // end find_kth_smallest

    // kth smallest recursive helper
    public static int helper(int[] A, int len, int k, int p) {
        int i = -1;

        for (int j = 0; j < len; j++) {
            if (A[j] < p) {
                i++;
                swappingElements(A, i, j);
            }
        }
        swappingElements(A, len - 1, ++i);

        int indexPos = getIndex(A, p, len);

        // if k less than index of pivot check the left array
        if (k < indexPos + 1) {
            int[] tempArray = Arrays.copyOfRange(A, 0, indexPos);
            return helper(tempArray, tempArray.length, k, tempArray[tempArray.length - 1]);
        } 

        // if k greater than index of pivot check the right array
        else if (k > indexPos + 1) {
            int[] tempArray = Arrays.copyOfRange(A, indexPos + 1, len);
            return helper(tempArray, tempArray.length, k - (indexPos + 1), tempArray[tempArray.length - 1]);
        }

        // base case
        else {
            return A[indexPos];
        }
        
    }

    //swap A[a] and A[b] in A
    public static void swappingElements(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
        
    //get index of pivot in an array A of distinct integers
    public static int getIndex(int[]A, int pivot, int len){
        for (int i = 0; i < len ; i++){
            if (A[i] == pivot)
                return i;
        }
        return -1;
    }
    
} // end class
    
    