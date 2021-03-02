package domain.tasks_models.tasks;

import domain.tasks_models.exceptions.DateException;
import domain.tasks_models.enums.Priority;
import domain.tasks_models.enums.Repeats;
import domain.tasks_models.enums.TaskCategory;
import domain.tasks_models.enums.TaskType;

import java.io.Serializable;
import java.time.LocalDate;

public class RecurringTask extends TaskItem implements Serializable {
	
	private static final long serialVersionUID = 5L;
	
	private Repeats repeats;
	
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
	 * @param taskCategory   RecurringTask taskCategory
	 * @param taskType       RecurringTask taskType
	 * @param complete       RecurringTask complete
	 * @param expirationDate RecurringTask expirationDate
	 * @param repeats        RecurringTask repeats
	 */
	
	// Constructor
	public RecurringTask(String description, TaskCategory taskCategory, TaskType taskType, Priority priority, boolean complete, LocalDate expirationDate, Repeats repeats) {
		
		super(description, taskCategory, taskType, priority, complete, expirationDate);
		this.repeats = repeats;
	}
	
	//Methods
	public void createTask(String description, TaskCategory category, TaskType type, Priority priority, boolean complete, LocalDate expirationDate, Repeats repeats) {
		
		createTask(description, category, type, priority, complete, expirationDate);
		this.repeats = repeats;
	}
	
	public void editTask(String description, TaskCategory category, TaskType type, Priority priority, boolean complete, LocalDate expirationDate, Repeats repeats) {
		
		editTask(description, category, type, priority, complete, expirationDate);
		this.repeats = repeats;
	}
	
	// Method toString
	@Override
	public String toString() {
		
		
		final StringBuffer sb = new StringBuffer("\n");
		sb.append("Description: ").append(getDescription()).append(".\n");
		sb.append("Repeat: ").append(getRepeat()).append(".\n");
		sb.append("Priority: ").append(getPriority()).append(".\n");
		sb.append("Category: ").append(getTaskCategory()).append(".\n");
		try {
			sb.append("Expiration date: ").append(getExpirationDate()).append(".\n");
		} catch (DateException e) {
			sb.append(setExpirationDate("expired date")).append(".\n");
		}
		sb.append("Days left: ").append(getDaysLeft()).append(" days.\n");
		sb.append("Complete: ").append(isComplete()).append(".\n");
		return sb.toString();
	}
	
	/**
	 * @return RecurringTask repeat
	 */
	public Repeats getRepeat() {
		
		return repeats;
	}
	
	public void setRepeat(Repeats repeats) {
		
		this.repeats = repeats;
	}
}
