package asg2;
/***********************************
* CSE2011 - Assignment 2 
************************************/

public class match {

    /*
     * EXHAUSTIVE ALGORITHM
     * Returns index i if array A contains an element A[i] such that A[i] = i.
     * If there exist many of such elements, return the index of any one of them.
     * Returns -1 if there exists no element A[i] such that A[i] == i.
     * n is the number of elements A contains.
     *
     * The running time of your algorithm is O(N).
     * You may add a brief explanation here if you wish.
     */
    
    
    public static int match_exh( int[] A, int n ) 
    {
    
       // COMPLETE THIS METHOD.
    
       // You may define local variables inside this method.
    
       // You may add your own methods/subroutines to this file.
        for (int i=0; i<n; i++){
            if (A[i]==i)
                return i;
        }
        return -1;
        
    } // end match_exh
    
    
    
    
    /*
     * DIVIDE-AND-CONQUER ALGORITHM
     * Returns index i if array A contains an element A[i] such that A[i] = i.
     * If there exist many of such elements, return the index of any one of them.
     * Returns -1 if there exists no element A[i] such that A[i] == i.
     * n is the number of elements A contains.
     *
     * The running time of your algorithm is O(logN).
     * The running time of your algorithm is O(  ).
     * You may add a brief explanation here if you wish.
     */
    
    public static int match_dac( int[] A, int n )
    {
    
       // COMPLETE THIS METHOD.
    
       // You may define local variables inside this method.
    
       // You may add your own methods/subroutines to this file.
        
        return match_dac_helper(A, n, 0, n-1);
    }  // end match_dac
    
    public static int match_dac_helper(int[] A, int n, int left, int right){
         int mid = (left+right)/2;
         if (A[mid]==mid)
            return mid;

         else if (A[mid]<mid  && mid+1<=right)
            return match_dac_helper(A, n, mid+1, right);

         else if (A[mid]>mid && left<=mid-1)
            return match_dac_helper(A, n, left,mid-1);
        
         else
            return -1;
    }



} // end class
