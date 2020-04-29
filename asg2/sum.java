package asg2;
/***********************************
* CSE2011 - Assignment 2 
************************************/


public class sum {


    /*
     * EXHAUSTIVE ALGORITHM
     * Returns true if array A contains two elements whose sum is k.
     * Returns false otherwise.
     * n is the number of elements A contains.
     *
     * The running time of your algorithm is O(N^2).
     * You may add a brief explanation here if you wish.
     */
    
    public static boolean sum_exh( int[] A, int n, int k )
    {
       // COMPLETE THIS METHOD.
    
       // You may define local variables inside this method.
    
       // You may add your own methods/subroutines to this file.
       for (int i=0; i<n; i++){
           for (int j=0; j<n; j++){
               if (A[i]!=A[j] && A[i]+A[j]==k && A[i]<=k && A[j]<=k)
                   return true;
           }
       }
       return false;
    
    }  // end sum_exh
    
    
    
    
    
    /*
     * RECURSIVE ALGORITHM
     * Returns true if array A contains two elements whose sum is k.
     * Returns false otherwise.
     * n is the number of elements A contains.
     *
     * The running time of your algorithm is O(N).
     * You may add a brief explanation here if you wish.
     */
    
    public static boolean sum_rec( int[] A, int n, int k )
    {
       // COMPLETE THIS METHOD.
    
       // You may define local variables inside this method.
    
       // You may add your own methods/subroutines to this file.
        return sum_rec_helper(A, n, k, 0, n-1);
    }  // end sum_rec
    
    public static boolean sum_rec_helper(int[] A, int n, int k, int left, int right)
    {   
        int sum = A[left] + A[right];
        if (left==right)
            return false;
        else if (sum>k)
            return sum_rec_helper(A, n, k, left, right-1);
        else if (sum<k)
            return sum_rec_helper(A, n, k, left+1, right);
        else if (sum==k)
            return true;
        return false;
    }


} // end class
    
