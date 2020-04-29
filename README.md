# EECS 2011 - W20

> I have a prepared a cheat sheet for two topics of Fudamentals of Data Structures. Feel free to use it.

## Heaps (9.1)

A heap is a binary tree storing Key - Value pairs at it's nodes following

  1. **Heap - Order** that is for every `node` - >  `key(node) >= key(parent(node))`       [MIN HEAP]
  1. **Complete Binary Tree** - > nodes are filled from left to right.  

A heap storing `N` keys has a max height of `log(N)` and the smallest key is at e _root_ (the top of the tree).  

### Array-Based Implementation.

- **Iniatialization**  
For `N` keys we can create an array of size `N` where the root is at index `1` and for a node at index `i` the left child is at `2i` and right child is at `2i + 1`  

- **Insertion**  
This can be done by storing the newly inserted element `newKey` at the last possible position in the heap. *But this may vioalte the __Heap-Order__* , to restore the heap order property we need to perform  **Up-Heap Percolation**  
To perform _Up Heap Percolation_ we need to keep swapping `newKey` until `newKey > parent(newKey)`. A sample code could be  

  ```Java
  upheap(int newKey) {
    while (newKey > 1) { // continue until reaching root (or break statement)
      final int parent = parent(newKey);
      if (newKey > parent)
        break; // heap property verified
      swap(j, p);
      newKey = parent; // continue from the parent's location
    }
  }
  ```

- **Deletion**  
This can be done by removing the element at the root and placing the last element `lastKey` at the newly empty root position. *But this may vioalte the __Heap-Order__* , to restore the heap order property we need to perform  **Down-Heap Percolation**  
To perform _Down-Heap Percolation_ we keep on swapping the `lastKey` in the downward direction until `lastKey` is smaller than both the children below it.

  ```Java
  downheap(int lastKey) {
    while (hasLeft(lastKey)) { // continue to bottom (or break statement)
      final int leftIndex = left(lastKey);
      int smallChildIndex = leftIndex; // although right may be smaller
      if (hasRight(lastKey)) {
        final int rightIndex = right(lastKey);
        if (leftIndex > rightIndex)
          smallChildIndex = rightIndex; // right child is smaller
      }
      if (smallChildIndex >= lastKey)
        break; // heap property has been restored
      swap(lastKey, smallChildIndex);
      j = smallChildIndex; // continue at position of the child
    }
  }
  ```

  > Both **Up-Heap and Down-Heap Percolation** may have to travel the entire height of the heap which is `log(N)`, therfore they have a run time of **O(log(N))**

### Run Time

  | Operation (Array)   | Perfomance |
  |:-----------:|:----------:|
  | size        | O(1)       |
  | min (root)   | O(1)       |
  | Insertion (Up-Heap)| O(logN)    |
  | Deletion (Down-Heap)   | O(logN)    |

## Hash Tables (10.2)

### Hashing

Hashing is a technique used for performing insertions, deletions and searches in **O(1)** time.

### Hash Functions `h(k)` :star: DELETE

The main purpose of our hash function is to use the value of `h(k)` to map to an index in our bucket array of size N. Hash functions are comprised of  

- __Hash Code__  
    In simple words, it maps a key `k` to an integer value. The hash code assigned to the set of our keys must avoid collisions (overlapping) as much as possible. Generally Hash Code works well for keys of length less than number of bits of an Integer **32 Bits**.

  1. For base types - `byte , short, int and char` you can simply cast it to an integer value.
  1. For base types - `long and double` (64 bit data types). Split the 64 bit key into 2 equal components and then simply `ADD` or `XOR` them while ignoring overflow to generate a 32 bit hash code.  
  1. For base types - `String` the `XOR` method has **unwanted collisions**. Polynomial Accumulation is a good hash code which takes a constant value `a != 1` and evaluates a polynomial, good choices for the constant can be `a = 33, 37, 39 or 41`

- __Compression Function__  
  The hash code above usually generates an integer, the job of the compression function is to map the integer value to between `[0, N-1]`. **A good compression function is one that minimizes the number of collisions for a given set of distinct hash codes.**  

  1. **The Division Method** which maps an integer `i` to `i mod N` where `N` (Prime Number) is the size of the bucket array.  
  2. **The MAD Method** which maps an integer `i` to `(ai + b) mod N` where `a & b` are the non-negative constants and `N` is the size of array. _(AKA the Multiply and Divide Method)_

### Collision Handling :star2:   DELETE

Collisions occur when different elements (keys) are mapped to same the index in the bucket array.  

- **Seperate Chaining**  
    Lets each cell in the table point to a linked list of the entries in that specific index. _It is to easy to use but requires additional space._  
    This causes the run time to increase to `O(n/N)` where `n` is the number of elements in the array and `N` is the bucket sixe of the array.  
    This introduces an important concept called **Load Factor** it is equal to `n/N`. Hence the new run time is `O(Load Factor)`, so as to ensure `O(1)` run time, the `Load Factor <= 1` .
    > To  ensure best perfomance we should try to maintain `Load Factor <= 0.5` for open addressing and `Load Factor <= 0.9` for separate chaining.
  
- **Open Addressing**

  - **Linear Probing**  
      Linear probing handles the colliding item by placing it in the next available cell.  In Linear probing the cells have the three following values.  

      1. **NULL** - A brand new cell, never used.  
      1. **IN USE** - A cell currently filled with an element.
      1. **DEFUNCT** -  A cell which was previously used but currently unused.

      The cells are given such values as to prevent errors when performing `remove(), put() and get()` operations.  
      If the insertion cell is being used it searches for the next available cell using `A[(h(k) + i) mod N]` where `i` is the iterator.  
      It is not the best method as it produces _clustering_  

    - **Quadtric Probing**  
      Quadatric Probing is similar to _Linear Probing_ but implements a quadtricly increasing iterator such as `A[(h(k) + i^2) mod N]`  
      Neither is Quadtric Probing the ideal choice of probing as it produces its own form clustering known as _secondary clustering_  

  - **Double Hashing**  
    Double hashing is similar to _Linear Probing_ but implements a increasing iterator which is mutliplied to a secondary hash function `d(k)` such as `A[(h(k) + i*d(k)) mod N]`  
    The Secondary hash function `d(k)` cannot return 0 values and the table size `N` must be prime .  
    An example of `d(k)` can be  `d(k) = q - (k mod q)` where `q < N` and `q` is prime.  

### Run Time

  | Operation   | Perfomance |
  |:-----------:|:----------:|
  | Search      | O(1)       |
  | Insertion   | O(1)       |
  | Deletion    | O(1)       |
  > Hashing is a very powerfull data structure. _Use it wisely_
