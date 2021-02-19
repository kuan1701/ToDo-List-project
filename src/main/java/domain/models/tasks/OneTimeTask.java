package domain.models.tasks;

import domain.enums.Priority;
import domain.enums.TaskCategory;
import domain.enums.TaskType;

import java.time.LocalDate;

public class OneTimeTask extends TaskItem {
	
	/**
	 * Constructs an OneTimeTask with no specified parameters
	 */
	public OneTimeTask() {
	
	}
	
	/**
	 * Constructs an OneTimeTask of a given description, creationDate,
	 * taskCategory, taskType, complete, expirationDate
	 *
	 * @param description    OneTimeTask description
	 * @param taskCategory   OneTimeTask taskCategory
	 * @param taskType       OneTimeTask taskType
	 * @param complete       OneTimeTask complete
	 * @param expirationDate OneTimeTask expirationDate
	 */
	public OneTimeTask(String description, TaskCategory taskCategory, TaskType taskType, Priority priority, boolean complete, LocalDate expirationDate) {
		
		super(description, taskCategory, taskType, priority, complete, expirationDate);
	}
}
