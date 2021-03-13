package domain.tasks_models.exceptions;

public class TasksExceptions extends Exception{
	
	final static public int NO_DESCRIPTION = 1;
	final static public int  DATE_EXPIRED = 2;
	
	private final int code;
	
	public TasksExceptions(int code) {
		
		this.code = code;
	}
	
	public int getCode() {
		
		return code;
	}
}
