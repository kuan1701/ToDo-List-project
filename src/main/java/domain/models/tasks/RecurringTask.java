package domain.models.tasks;

import domain.enums.Priority;
import domain.enums.TaskCategory;
import domain.enums.TaskType;

public class RecurringTask extends TaskItem {
	
	private String repeat;
	
	/**
	 * Constructs an RecurringTask with no specified parameters
	 */
	public RecurringTask() {
	
	}
	
	/**
	 * Constructs an RecurringTask of a given description, creationDate,
	 * taskCategory, taskType, complete, expirationDate, count
	 *
	 * @param description    RecurringTask description
	 * @param creationDate   RecurringTask creationDate
	 * @param taskCategory   RecurringTask taskCategory
	 * @param taskType       RecurringTask taskType
	 * @param complete       RecurringTask complete
	 * @param expirationDate RecurringTask expirationDate
	 * @param repeat         RecurringTask count
	 */
	
	// Constructor
	public RecurringTask(String description, String creationDate, TaskCategory taskCategory, TaskType taskType, Priority priority, boolean complete, String expirationDate, String repeat) {
		
		super(description, creationDate, taskCategory, taskType, priority, complete, expirationDate);
		this.repeat = repeat;
	}
	
	//Methods
	public void createTask(String description, String creationDate, TaskCategory category, TaskType type, Priority priority, boolean complete, String expirationDate, String repeat) {
		
		createTask(description, creationDate, category, type, priority, complete, expirationDate);
		this.repeat = repeat;
	}
	
	public void editTask(String description, String creationDate, TaskCategory category, TaskType type, Priority priority, boolean complete, String expirationDate, String repeat) {
		
		editTask(description, creationDate, category, type, priority, complete, expirationDate);
		this.repeat = repeat;
	}
	
	// Method toString
	@Override
	public String toString() {
		
		final StringBuffer sb = new StringBuffer("\n");
		sb.append("Description: ").append(getDescription()).append(".\n");
		sb.append("Creation date: ").append(getCreationDate()).append(".\n");
		sb.append("Repeat: ").append(getRepeat()).append(".\n");
		sb.append("Type: ").append(getTaskType()).append(".\n");
		sb.append("Priority: ").append(getPriority()).append(".\n");
		sb.append("Category: ").append(getTaskCategory()).append(".\n");
		sb.append("Expiration date: ").append(getExpirationDate()).append(".\n");
		sb.append("Complete: ").append(isComplete()).append(".\n");
		return sb.toString();
	}
	
	/**
	 * @return RecurringTask repeat
	 */
	public String getRepeat() {
		
		return repeat;
	}
	
	public void setRepeat(String repeat) {
		
		this.repeat = repeat;
	}
}
