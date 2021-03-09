package domain.users_models.exceptions;

public class UserException extends Exception{

	final static public int NO_FIRST_NAME = 1;
	final static public int NO_LAST_NAME = 2;
	final static public int NO_USERNAME = 3;
	final static public int NO_PASSWORD = 4;
	final static public int SHORT_USERNAME = 5;
	final static public int BUSY_USERNAME = 6;
	private final int code;
	
	public UserException(int code) {
		
		this.code = code;
	}
	
	public int getCode() {
		
		return code;
	}
}
