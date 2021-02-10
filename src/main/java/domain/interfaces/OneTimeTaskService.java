package domain.interfaces;

import domain.enums.TaskCategory;
import domain.enums.TaskType;
import domain.models.tasks.OneTimeTask;

import java.util.LinkedList;

public interface OneTimeTaskService {
	
	/**
	 * @param description
	 * @param creationDate
	 * @param category
	 * @param type
	 * @param complete
	 * @param expirationDate
	 */
	public void createTask(String description, String creationDate, TaskCategory category, TaskType type, boolean complete, String expirationDate);

	public void deleteTask(OneTimeTask oneTimeTask);

	
	/**
	 * @param description
	 * @param creationDate
	 * @param category
	 * @param type
	 * @param complete
	 * @param expirationDate
	 */
	public void editTask(String description, String creationDate, TaskCategory category, TaskType type, boolean complete, String expirationDate);
}
