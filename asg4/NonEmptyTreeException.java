
/**
 * Runtime exception thrown when one tries to perform operation top or pop on an
 * empty stack.
 */

public class NonEmptyTreeException extends RuntimeException {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public NonEmptyTreeException(String err) {
    super(err);
  }
}
