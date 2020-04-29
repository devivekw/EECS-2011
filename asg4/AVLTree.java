/***********************************

************************************/

/** Implementation of an AVL tree. */
public class AVLTree extends BinarySearchTree implements Dictionary {

  public AVLTree(final Comparator c) {
    super(c);
  }

  public AVLTree() {
    super();
  }

  /** Nested class for the nodes of an AVL tree. */
  protected static class AVLNode extends BTNode {

    protected int height; // we add a height field to a BTNode

    /** Preferred constructor */
    AVLNode(final Object element, final BTPosition parent, final BTPosition left, final BTPosition right) {
      super(element, parent, left, right);
      height = 0;
      if (left != null)
        height = Math.max(height, 1 + ((AVLNode) left).getHeight());
      if (right != null)
        height = Math.max(height, 1 + ((AVLNode) right).getHeight());
    } // we assume that the parent will revise its height if needed

    public void setHeight(final int h) {
      height = h;
    }

    public int getHeight() {
      return height;
    }
  }

  /**
   * Print the content of the tree root.
   */
  public void printRoot() {
    System.out.println("printRoot: " + value(left(root())).toString() + " " + value(root()).toString() + " "
        + value(right(root())).toString());
  }

  /**
   * Print the the tree using preorder traversal.
   */
  public void preorderPrint(final Position v) {
    if (isInternal(v))
      System.out.print(value(v).toString() + " ");
    if (hasLeft(v))
      preorderPrint(left(v));
    if (hasRight(v))
      preorderPrint(right(v));
  }

  /** Creates a new binary search tree node (overrides super's version). */
  protected BTPosition createNode(final Object element, final BTPosition parent, final BTPosition left,
      final BTPosition right) {
    return new AVLNode(element, parent, left, right); // now use AVL nodes
  }

  /** Returns the height of a node (call back to an AVLNode). */
  protected int height(final Position p) {
    return ((AVLNode) p).getHeight();
  }

  /** Sets the height of an internal node (call back to an AVLNode). */
  protected void setHeight(final Position p) { // called only if p is internal
    ((AVLNode) p).setHeight(1 + Math.max(height(left(p)), height(right(p))));
  }

  /** Returns whether a node has balance factor between -1 and 1. */
  protected boolean isBalanced(final Position p) {
    final int bf = height(left(p)) - height(right(p));
    return ((-1 <= bf) && (bf <= 1));
  }

  /**
   * Returns a child of p with height no smaller than that of the other child
   */
  protected Position tallerChild(final Position p) {
    if (height(left(p)) > height(right(p)))
      return left(p);
    else if (height(left(p)) < height(right(p)))
      return right(p);
    // equal height children - break tie using parent's type
    if (isRoot(p))
      return left(p);
    if (p == left(parent(p)))
      return left(p);
    else
      return right(p);
  }

  /**
   * Insert a new element into the AVL tree.
   */
  public Entry insert(final Object k, final Object v) throws InvalidKeyException {
    final Entry toReturn = super.insert(k, v); // calls our new createNode method
    rebalance(actionPos); // rebalance up from the insertion position
    return toReturn;
  }

  /**
   * Remove an element from the AVL tree.
   */
  public Entry remove(final Entry ent) throws InvalidEntryException {
    final Entry toReturn = super.remove(ent);
    if (toReturn != null) // we actually removed something
      rebalance(actionPos); // rebalance up the tree
    return toReturn;
  }

  /**
   * Rebalance method called by insert and remove. Traverses the path from zPos to
   * the root. For each node encountered, we recompute its height and perform a
   * trinode restructuring if it's unbalanced.
   */
  protected void rebalance(Position zPos) {
    if (isInternal(zPos))
      setHeight(zPos);
    while (!isRoot(zPos)) { // traverse up the tree towards the root
      zPos = parent(zPos);
      setHeight(zPos);
      if (!isBalanced(zPos)) {
        // Perform a trinode restructuring starting from zPos's tallest grandchild
        final Position xPos = tallerChild(tallerChild(zPos));
        zPos = restructure(xPos); // tri-node restructure
        setHeight(left(zPos)); // recompute heights
        setHeight(right(zPos));
        setHeight(zPos);
      }
    }
  }

  // ***************************************
  // DO NOT MODIFY THE CODE ABOVE THIS LINE.
  // ADD YOUR CODE BELOW THIS LINE.
  //
  // ***************************************

  /**
   * Perform a trinode restructuring starting from x, z's tallest grandchild.
   * Input: xPos, position of (pointer to) x Output: position of (pointer to) the
   * new root of the subtree that was restructured.
   */
  protected Position restructure(final Position xPos) {

    // COMPLETE THIS METHOD

    // You may add your own method(s) to this file.

    if (xPos == (root()))
      return xPos;

    Position yPos = parent(xPos);
    if (yPos == (root()))
      return yPos;

    Position zPos = parent(yPos);
    BTPosition topPosition;

    if (root() == (zPos))
      topPosition = null;
    else
      topPosition = (BTPosition) parent(zPos);

    // Temporary positions of x, y and z
    BTPosition aPosition, bPosition, cPosition;
    // Sub trees of x, y and z
    BTPosition subTree1, subTree2, subTree3, subTree4;

    if ((right(yPos) == (xPos) && right(zPos) == (yPos)) || left(zPos) == yPos && left(yPos) == xPos) {
      if (right(yPos) == (xPos) && right(zPos) == (yPos)) {
        aPosition = (BTPosition) zPos;
        bPosition = (BTPosition) yPos;
        cPosition = (BTPosition) xPos;

        subTree1 = (BTPosition) left(aPosition);
        subTree2 = (BTPosition) left(bPosition);
        subTree3 = (BTPosition) left(cPosition);
        subTree4 = (BTPosition) right(cPosition);

        // Replace the subtree rooted at z with a new subtree rooted at b.
        if (topPosition != (null) && topPosition.getRight() == aPosition) {
          topPosition.setRight(bPosition);
        } else if (topPosition != (null) && topPosition.getLeft() == (aPosition)) {
          topPosition.setLeft(bPosition);
        }

      } else {
        aPosition = (BTPosition) xPos;
        bPosition = (BTPosition) yPos;
        cPosition = (BTPosition) zPos;

        subTree1 = (BTPosition) left(aPosition);
        subTree2 = (BTPosition) right(aPosition);
        subTree3 = (BTPosition) right(bPosition);
        subTree4 = (BTPosition) right(cPosition);

        // Replace the subtree rooted at z with a new subtree rooted at b.
        if (topPosition != (null) && topPosition.getRight() == cPosition) {
          topPosition.setRight(bPosition);
        } else if (topPosition != (null) && topPosition.getLeft() == (cPosition)) {
          topPosition.setLeft(bPosition);
        }
      }
    }

    else {
      if (right(zPos) == yPos && left(yPos) == xPos) {
        aPosition = (BTPosition) zPos;
        bPosition = (BTPosition) xPos;
        cPosition = (BTPosition) yPos;

        subTree1 = (BTPosition) left(aPosition);
        subTree2 = (BTPosition) left(bPosition);
        subTree3 = (BTPosition) right(bPosition);
        subTree4 = (BTPosition) right(cPosition);

        // Setting paret if parent exists
        if (topPosition != (null) && topPosition.getRight() == aPosition) {
          topPosition.setRight(bPosition);
        } else if (topPosition != (null) && topPosition.getLeft() == (aPosition)) {
          topPosition.setLeft(bPosition);
        }
      } else {
        aPosition = (BTPosition) yPos;
        bPosition = (BTPosition) xPos;
        cPosition = (BTPosition) zPos;

        subTree1 = (BTPosition) left(aPosition);
        subTree2 = (BTPosition) left(bPosition);
        subTree3 = (BTPosition) right(bPosition);
        subTree4 = (BTPosition) right(cPosition);

        // Setting paret if parent exists
        if (topPosition != (null) && topPosition.getRight() == cPosition) {
          topPosition.setRight(bPosition);
        } else if (topPosition != (null) && topPosition.getLeft() == (cPosition)) {
          topPosition.setLeft(bPosition);
        }
      }
    }
    // Common code for both instances

    bPosition.setParent(topPosition);
    if (topPosition == null)
      root = (Position) bPosition;

    // Let a be the left child of b and let T1 and T2 be the left and right subtrees
    // of a, respectively.
    bPosition.setLeft(aPosition);
    aPosition.setParent(bPosition);

    aPosition.setLeft(subTree1);
    subTree1.setParent(aPosition);
    aPosition.setRight(subTree2);
    subTree2.setParent(aPosition);

    // Let c be the right child of b and let T3 and T4 be the left and right
    // subtrees of c, respectively.
    bPosition.setRight(cPosition);
    cPosition.setParent(bPosition);

    cPosition.setLeft(subTree3);
    subTree3.setParent(cPosition);
    cPosition.setRight(subTree4);
    subTree4.setParent(cPosition);

    return ((Position) bPosition); // replace this line with your code

  } // restructure

} // end AVLTree class
