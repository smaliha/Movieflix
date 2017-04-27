package saniya.egenProject.exception;

public class AdminAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminAlreadyExistsException(String message)
	{
		super(message);
	}
	
	public AdminAlreadyExistsException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
