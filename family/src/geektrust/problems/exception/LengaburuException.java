/**
 * 
 */
package geektrust.problems.exception;

/**
 * This is a Application Generic Exception. As and when the complexity of the application increases,
 * the exceptional handling world be required and specific exceptions needs to be thrown.
 * 
 * @author Neeraj Suthar
 *
 */
public class LengaburuException extends Exception {

	private static final long serialVersionUID = 6568819005215460715L;

	/**
	 * Exception without arguments
	 */
	public LengaburuException() {
		super();
	}

	/**
	 * Exception to be thrown when the message is present.
	 * 
	 * @param message
	 */
	public LengaburuException(String message) {
		super("Some Exception Occured : " + message);
	}

	/**
	 * Exception to be thrown when the exception object is present.
	 * 
	 * @param exception
	 */
	public LengaburuException(Exception exception) {
		super("Some Exception Occured with these details: " + 
				"\nClass: " + exception.getClass().getSimpleName() +
				"\nCause: " + exception.getMessage());
	}
}
