package domain.models.tasks;

import domain.enums.TaskCategory;
import domain.enums.TaskType;
import domain.interfaces.OneTimeTaskService;
import domain.interfaces.RecurringTaskService;

import java.util.LinkedList;
import java.util.Objects;

public class RecurringTask extends TaskItem implements RecurringTaskService, Comparable<RecurringTask> {
	
	private String count;
	
	//Generate sequence numbers when creating a task
	private static int numOfRecurringTask = 1;
	
	
	//Assign a serial number to a task for further comparison
	public static int num = 1;
	private final int id = num++;
	
	//Create a list of recurring task
	private static final LinkedList<RecurringTask> recurringTaskList = new LinkedList<RecurringTask>();
	
	/**
	 * Constructs an RecurringTask with no specified parameters
	 */
	public RecurringTask() {
		recurringTaskList.add(this);
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
	 * @param count RecurringTask count
	 */
	public RecurringTask(String description, String creationDate, TaskCategory taskCategory, TaskType taskType, boolean complete, String expirationDate, String count) {
		super(description, creationDate, taskCategory, taskType, complete, expirationDate);
		this.count = count;
		recurringTaskList.add(this);
	}
	
	//Methods
	
	
	@Override
	public void createTask(String description, String creationDate, TaskCategory category, TaskType type, boolean complete, String expirationDate, String count) {
		
		setDescription(description);
		setCreationDate(creationDate);
		setTaskCategory(category);
		setTaskType(type);
		setComplete(complete);
		setExpirationDate(expirationDate);
		setCount(count);
	}
	
	@Override
	public void deleteTask(RecurringTask recurringTask) {
		recurringTaskList.remove(recurringTask);
	}
	
	@Override
	public void editTask(String description, String creationDate, TaskCategory category, TaskType type, boolean complete, String expirationDate, String count) {
		
		setDescription(description);
		setCreationDate(creationDate);
		setTaskCategory(category);
		setTaskType(type);
		setComplete(complete);
		setExpirationDate(expirationDate);
		setCount(count);
	}
	
	//Method equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof RecurringTask)) return false;
		RecurringTask that = (RecurringTask) obj;
		return getId() == that.getId() &&
				Objects.equals(getCount(), that.getCount());
	}
	
	//Method hashCode
	@Override
	public int hashCode() {
		return Objects.hash(getCount(), getId());
	}
	
	//Method compareTo
	//Comparing tasks by type and by category
	@Override
	public int compareTo(RecurringTask obj) {
		
		int result = this.getTaskType().compareTo(obj.getTaskType());
		
		if (result == 0) {
			result = this.getTaskCategory().compareTo(obj.getTaskCategory());
		}
		return result;
	}
	
	//Method toString
	@Override
	public String toString() {
		
		final StringBuffer sb = new StringBuffer("\n");
		sb.append("Description: ").append(getDescription()).append(".\n");
		sb.append("Creation date: ").append(getCreationDate()).append(".\n");
		sb.append("Repeat: ").append(getCount()).append(".\n");
		sb.append("Type: ").append(getTaskType()).append(".\n");
		sb.append("Category: ").append(getTaskCategory()).append(".\n");
		sb.append("Expiration date: ").append(getExpirationDate()).append(".\n");
		sb.append("Complete: ").append(isComplete()).append(".\n");
		return sb.toString();
	}

	/**
	 * @return RecurringTask ID
	 */
	public int getId() {
		
		return id;
	}
	
	/**
	 * @return RecurringTask count
	 */
	public String getCount() {
		
		return count;
	}
	
	/**
	 * @return A list of RecurringTask
	 */
	public static LinkedList<RecurringTask> getRecurringTaskList() {
		return recurringTaskList;
	}
	
	/**
	 * @return A list of Recurring task
	 */
	public static LinkedList<RecurringTask> getTasks() {
		
		return new LinkedList<RecurringTask>(recurringTaskList);
	}
	
	public void setCount(String count) {
		
		this.count = count;
	}
	
	//Method for assigns a sequential number to each task
	public static void getIdOfRecurringTask() {
		
		for (TaskItem oTT : RecurringTask.getTasks()) {
			
			int idOfRecurringTask = numOfRecurringTask++;
			System.out.println("Task " + idOfRecurringTask + "." + oTT);
		}
	}
}
