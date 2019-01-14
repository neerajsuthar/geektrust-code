/**
 * 
 */
package geektrust.problems.exception;

/**
 * This is a Application Generic Exception
 * 
 * @author Neeraj Suthar
 *
 */
public class LengaburuException extends Exception {
	
	public LengaburuException() {
		super();
	}

	public LengaburuException(String message) {
		super("Some Exception Occured : " + message);
	}
	
	public LengaburuException(Exception exception) {
		super("Some Exception Occured with these details: " + 
				"\nClass: " + exception.getClass().getSimpleName() +
				"\nCause: " + exception.getMessage());
	}
}
