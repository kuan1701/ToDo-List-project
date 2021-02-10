package domain.interfaces;

import domain.enums.TaskCategory;
import domain.enums.TaskType;
import domain.models.tasks.RecurringTask;

public interface RecurringTaskService {
	
	/**
	 * @param description
	 * @param creationDate
	 * @param category
	 * @param type
	 * @param complete
	 * @param expirationDate
	 * @param count
	 */
	public void createTask(String description, String creationDate, TaskCategory category, TaskType type, boolean complete, String expirationDate, String count);
	
	public void deleteTask(RecurringTask recurringTask);
	
	
	/**
	 * @param description
	 * @param creationDate
	 * @param category
	 * @param type
	 * @param complete
	 * @param expirationDate
	 * @param count
	 */
	public void editTask(String description, String creationDate, TaskCategory category, TaskType type, boolean complete, String expirationDate, String count);
	
}
