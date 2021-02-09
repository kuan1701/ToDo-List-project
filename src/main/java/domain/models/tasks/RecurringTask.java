package domain.models.tasks;

import domain.enums.TaskCategory;
import domain.enums.TaskType;
import domain.interfaces.iTaskService;

import java.util.LinkedList;
import java.util.Objects;

public class RecurringTask extends TaskItem implements iTaskService, Comparable<RecurringTask> {
	
	private String count;
	
	//Generate sequence numbers when creating a task
	public static int num = 1;
	private final int id = num++;
	
	//Create a list of recurring task
	private static final LinkedList<RecurringTask> recurringTaskList = new LinkedList<RecurringTask>();
	
	/**
	 * Constructs an RecurringTask with no specified parameters
	 */
	public RecurringTask() {
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
	public void createTask() {
		
		System.out.println(	"Description: " + getDescription() + ".\n" +
							"Creation date: " + getCreationDate() + ".\n" +
							"Repeat: " + getCount() + ".\n" +
							"Type: " + getTaskType() + ".\n" +
							"Category: " + getTaskCategory() + ".\n" +
							"Expiration date: " + getExpirationDate() + ".\n" +
							"Complete: " + isComplete() + ".\n");
	}
	
	@Override
	public void deleteTask() {
	
	}
	
	@Override
	public void editTask() {
	
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
		
		final StringBuffer sb = new StringBuffer();
		sb.append(" Description: ").append(getDescription());
		sb.append(". Creation date: ").append(getCreationDate());
		sb.append(". Repeat: ").append(getCount());
		sb.append(". Type: ").append(getTaskType());
		sb.append(". Category: ").append(getTaskCategory());
		sb.append(". Expiration date: ").append(getExpirationDate());
		sb.append(". Complete: ").append(isComplete());
		sb.append('.');
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
	 * @return A list of Recurring that have a quantity > 0
	 */
	public static LinkedList<RecurringTask> getTasks() {
		
		LinkedList<RecurringTask> tasks = new LinkedList<RecurringTask>();
		
		for(RecurringTask task : recurringTaskList) {
			
			if(task.getId() > 0)
				tasks.add(task);
		}
		return tasks;
	}
	
	public void setCount(String count) {
		
		this.count = count;
	}
}
