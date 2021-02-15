package domain.interfaces;

import domain.enums.Priority;
import domain.enums.TaskCategory;
import domain.enums.TaskType;
import domain.models.tasks.TaskItem;

import java.util.LinkedList;
import java.util.List;

public interface iTaskService {
	
	/**
	 * @param description
	 * @param creationDate
	 * @param category
	 * @param type
	 * @param priority
	 * @param complete
	 * @param expirationDate
	 */
	public void createTask(String description, String creationDate, TaskCategory category, TaskType type, Priority priority, boolean complete, String expirationDate);
	
	/**
	 * @param description
	 * @param creationDate
	 * @param category
	 * @param type
	 * @param priority
	 * @param complete
	 * @param expirationDate
	 */
	public void editTask(String description, String creationDate, TaskCategory category, TaskType type, Priority priority, boolean complete, String expirationDate);
}
