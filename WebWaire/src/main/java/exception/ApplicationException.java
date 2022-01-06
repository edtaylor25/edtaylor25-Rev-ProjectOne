package exception;

public class ApplicationException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	public ApplicationException(String msg) {
		this.msg = msg;
	}
	
	public String getMessage() {
		return this.msg;
	}
}
