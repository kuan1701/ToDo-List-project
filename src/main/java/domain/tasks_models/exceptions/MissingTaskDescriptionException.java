package domain.tasks_models.exceptions;

public class MissingTaskDescriptionException extends Exception{

	public MissingTaskDescriptionException(String message){
		
		super(message);
	}
}
