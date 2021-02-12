package domain.models.tasks;

import domain.enums.TaskCategory;
import domain.enums.TaskType;


import java.util.LinkedList;

public class RecurringTask extends TaskItem {
	
	private String repeat;
	
	// Generate sequence numbers when creating a task
	private static int numOfRecurringTask = 1;
	
	// Create a list of recurring task
	private static final LinkedList<RecurringTask> recurringTaskList = new LinkedList<RecurringTask>();
	
	/**
	 * Constructs an RecurringTask with no specified parameters
	 */
	public RecurringTask() {
		
		recurringTaskList.add(this);;
	}
	
	/**
	 * Constructs an RecurringTask of a given description, creationDate,
	 * taskCategory, taskType, complete, expirationDate, count
	 * @param description RecurringTask description
	 * @param creationDate RecurringTask creationDate
	 * @param taskCategory RecurringTask taskCategory
	 * @param taskType RecurringTask taskType
	 * @param complete RecurringTask complete
	 * @param expirationDate RecurringTask expirationDate
	 * @param repeat RecurringTask count
	 */
	public RecurringTask(String description, String creationDate, TaskCategory taskCategory, TaskType taskType, boolean complete, String expirationDate, String repeat) {
		super(description, creationDate, taskCategory, taskType, complete, expirationDate);
		this.repeat = repeat;
		recurringTaskList.add(this);
	}
	
	//Methods
	public void createTask(String description, String creationDate, TaskCategory category, TaskType type, boolean complete, String expirationDate, String repeat) {
		
		createTask(description, creationDate, category, type, complete, expirationDate);
		this.repeat = repeat;
	}
	
	public void deleteTask(TaskItem taskItem) {
		
		recurringTaskList.remove(taskItem);
	}
	
	public void editTask(String description, String creationDate, TaskCategory category, TaskType type, boolean complete, String expirationDate, String repeat) {
		
		editTask(description, creationDate, category, type, complete, expirationDate);
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
		sb.append("Category: ").append(getTaskCategory()).append(".\n");
		sb.append("Expiration date: ").append(getExpirationDate()).append(".\n");
		sb.append("Complete: ").append(isComplete()).append(".\n");
		return sb.toString();
	}
	
	/**
	 * @return A list of RecurringTask for sort
	 */
	public static LinkedList<RecurringTask> sortRecurringTaskList() {
		
		return recurringTaskList;
	}
	
	// Displaying the Recurring task list
	public static void getRecurringTaskList() {
		
		for (TaskItem rT : RecurringTask.recurringTaskList) {
			
			int idOfRecurringTask = numOfRecurringTask++;
			System.out.println("Task " + idOfRecurringTask + "." + rT);
		}
	}
	
	/**
	 * @return RecurringTask repeat
	 */
	public String getRepeat() {
		
		return repeat   ;
	}
	
	public void setRepeat(String repeat) {
		
		this.repeat = repeat   ;
	}
}
