/**
 * Runtime exceptions thrown when attempting to access the root of an empty
 * tree.
 */
class EmptyTreeException extends RuntimeException {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public EmptyTreeException(String err) {
    super(err);
  }
}
