package entities.exceptions;

public class QuotesException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public QuotesException(String message) {
		super(message);
	}
}
