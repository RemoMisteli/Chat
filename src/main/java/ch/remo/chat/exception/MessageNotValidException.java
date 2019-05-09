package ch.remo.chat.exception;

public class MessageNotValidException extends Exception{

	private static final long serialVersionUID = 2420461508129083156L;

	public MessageNotValidException(String message) {
		super(message);
	}
}

