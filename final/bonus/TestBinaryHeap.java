/***********************************
* File name: TestBinaryHeap.java
************************************/

public class TestBinaryHeap
{

    // Test program
    public static void main( String [ ] args )
    {
        BinaryHeap<Integer> t = new BinaryHeap<Integer>( );

	t.insert( Integer.valueOf( 100 )); 
	
	t.insert( Integer.valueOf( 200 ));	

	t.insert( Integer.valueOf( 50 ));	

	t.insert( Integer.valueOf( 300 ));	

	t.insert( Integer.valueOf( 400 ));	

	t.insert( Integer.valueOf( 20 ));	

	t.insert( Integer.valueOf( 10 ));	

	t.insert( Integer.valueOf( 150 ));	

	t.printTree( );

	for ( int i = 0; i < 8; i++ )
	{
        if (!t.isEmpty())
			System.out.println(t.deleteMin( ));
	}

	t.printTree( );

	// You should run more test cases of your own.
    }

}

