package domain.interfaces;

import domain.enums.TaskCategory;
import domain.enums.TaskType;
import domain.models.tasks.TaskItem;

public interface iTaskService {
	
	/**
	 * @param description
	 * @param creationDate
	 * @param category
	 * @param type
	 * @param complete
	 * @param expirationDate
	 */
	public void createTask(String description, String creationDate, TaskCategory category, TaskType type, boolean complete, String expirationDate);
	
	/**
	 * @param taskItem
	 */
	public void deleteTask(TaskItem taskItem);
	
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
