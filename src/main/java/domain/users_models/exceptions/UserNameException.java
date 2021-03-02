package domain.users_models.exceptions;

public class UserNameException extends Exception{

	final static public int SHORT_LOGIN = 1;
	final static public int LONG_LOGIN = 2;
	
	private final int code;
	
	public UserNameException(int code){
		
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
}
