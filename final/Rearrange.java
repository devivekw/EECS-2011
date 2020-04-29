/***********************************
 * File name: Rearrange.java Author: Wadhwani, Vivek Student ID: 216699613 EECS
 * login ID: vivek121
 ************************************/

public class Rearrange {

   /**************************************************************
    * DO NOT ADD ANYTHING ABOVE THIS LINE EXCEPT YOUR STUDENT INFO
    ***************************************************************/

   /*
    * Rearrange the array so that all the negative numbers appear before all the
    * non-negative numbers. n is the number of elements A contains.
    *
    * The running time of your algorithm must O( n ). Add a brief description of
    * how your algorithm works below.
    */

   /*
    * Brief description: ....................................
    * 
    */

   public static void rearrangeArray(int[] A, int n) {
      // COMPLETE THIS METHOD.

      // DO NOT CHANGE the above method declaration.

      // You may define local variables inside this method. Do not use global
      // variables.

      // You may add your own helper methods/subroutines to this file.

      rearrangeArrayHelper(A, n, -1, 0);
   } // end rearrangeArray

   static void rearrangeArrayHelper(int[] A, int n, int negativeIndex, int iterator) {
      if (iterator < n) {
         if (A[iterator] < 0) {
            negativeIndex++;
            int temp = A[iterator];
            A[iterator] = A[negativeIndex];
            A[negativeIndex] = temp;
         }
         iterator++;
         rearrangeArrayHelper(A, n, negativeIndex, iterator);
      }

   }

} // end class
