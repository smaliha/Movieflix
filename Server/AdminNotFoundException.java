package saniya.egenProject.exception;

public class AdminNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminNotFoundException(String message)
	{
		super(message);
	}
	
	public AdminNotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}

	
}
