package asg3;

public class ArrayMain {

	public static void main(final String[] args) {
		final ArrayDeque q = new ArrayDeque();
		System.out.println("Insert first 120");
		q.insertFirst(120);
		System.out.println("Insert first 15");
		q.insertFirst(15);
		q.printDeque();
		q.printArray();
		System.out.println("first =" + q.getFirst());
		System.out.println("last =" + q.getLast());
		q.insertLast(401);
		System.out.println("Insert last 401");
		q.printDeque();
		q.printArray();
		q.insertLast(65);
		System.out.println("Insert last 65");
		q.insertLast(37);
		System.out.println("Insert last 37");
		q.printDeque();
		q.printArray();
		System.out.println("first = " + q.getFirst());
		System.out.println("last = " + q.getLast());
		System.out.println("remove first = " + q.removeFirst());
		q.printDeque();
		q.printArray();
		System.out.println("remove last = " + q.removeLast());
		System.out.println("remove last = " + q.removeLast());
		q.printDeque();
		q.printArray();
		System.out.println("remove first = " + q.removeFirst());
		System.out.println("remove first = " + q.removeFirst());
		// q is now empty.

		int i, k;
		for (i = 1; i <= 100; i++) {
			q.insertFirst(i);
		}
		System.out.println(q.capacity);
		q.printDeque(); // 100 elements in q

		for (i = 1; i <= 99; i++) {
			k = q.removeFirst();
			// System.out.println(q.capacity);
		}
		q.printArray();
		q.printDeque(); // one element left
		// q.printArray();
	}
}
