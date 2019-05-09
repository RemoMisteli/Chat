package ch.remo.chat.exception;

public class UserNotValidException extends Exception {
	private static final long serialVersionUID = 6579484290583576511L;

	public UserNotValidException(String message) {
		super(message);
	}
}
