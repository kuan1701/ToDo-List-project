package domain.tasks_models.tasks;

import domain.tasks_models.enums.Priority;
import domain.tasks_models.enums.TaskCategory;
import domain.tasks_models.enums.TaskType;

import java.io.Serializable;
import java.time.LocalDate;

public class OneTimeTask extends TaskItem implements Serializable {
	
	private static final long serialVersionUID = 5L;
	
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
