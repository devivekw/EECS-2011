
/***********************************
* File name: RearrangeMain.java
************************************/

import java.util.Scanner;

public class RearrangeMain {

   public static final int MAXSIZE = 500;
   public static final int STOPVALUE = -999;

   public static void main(String[] args) {
      int[] A;
      int k, i;
      A = new int[MAXSIZE];

      Scanner input = new Scanner(System.in);

      // Get integers from the user one by one.
      // Stop getting input when seeing STOPVALUE.
      // STOPVALUE is a special value to indicate the end of the input stream.
      // Do not store STOPVALUE in the array.

      // i = 0;
      // k = input.nextInt( );
      // while ( k != STOPVALUE )
      // {
      // A[ i++ ] = k;
      // k = input.nextInt( );
      // }
      // At this point, i is the number of elements in A.

      int[] myArray = { -1, -2, -3, -4, -5, 0, -6 };
      // { -1, 1, 3, 4, 5, -2, 3, -5, 9 };

      Rearrange.rearrangeArray(myArray, myArray.length);

      // Display the array for output
      for (k = 0; k < myArray.length; k++)
         System.out.print(myArray[k] + " ");
      System.out.println();
      input.close();
   } // end main

} // end class
