package domain.models.tasks;

import domain.enums.TaskCategory;
import domain.enums.TaskType;
import domain.interfaces.iTaskService;

import java.util.LinkedList;
import java.util.Objects;

public class OneTimeTask extends TaskItem implements iTaskService, Comparable<OneTimeTask> {
	
	//Generate sequence numbers when creating a task
	public static int num = 1;
	private final int id = num++;
	
	//Create a list of one-time task
	private static final LinkedList<OneTimeTask> oneTimeTaskList = new LinkedList<OneTimeTask>();
	
	/**
	 * Constructs an OneTimeTask with no specified parameters
	 */
	public OneTimeTask() {
		oneTimeTaskList.add(this);
	}
	
	/**
	 * Constructs an OneTimeTask of a given description, creationDate,
	 * taskCategory, taskType, complete, expirationDate
	 * @param description OneTimeTask description
	 * @param creationDate OneTimeTask creationDate
	 * @param taskCategory OneTimeTask taskCategory
	 * @param taskType OneTimeTask taskType
	 * @param complete OneTimeTask complete
	 * @param expirationDate OneTimeTask expirationDate
	 */
	public OneTimeTask(String description, String creationDate, TaskCategory taskCategory, TaskType taskType, boolean complete, String expirationDate) {
		super(description, creationDate, taskCategory, taskType, complete, expirationDate);
		oneTimeTaskList.add(this);
	}
	
	//Methods
	@Override
	public void createTask() {
		System.out.println(	"Description: " + getDescription() + ".\n" +
							"Creation date: " + getCreationDate() + ".\n" +
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
	
	//Method toString
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer();
		sb.append(" Description: ").append(getDescription());
		sb.append(". Creation date: ").append(getCreationDate());
		sb.append(". Type: ").append(getTaskType());
		sb.append(". Category: ").append(getTaskCategory());
		sb.append(". Expiration date: ").append(getExpirationDate());
		sb.append(". Complete: ").append(isComplete());
		sb.append('.');
		return sb.toString();
	}
	
	//Method equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof OneTimeTask)) return false;
		OneTimeTask that = (OneTimeTask) obj;
		return getId() == that.getId();
	}
	
	//Method hashCode
	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
	
	//Method compareTo
	@Override
	public int compareTo(OneTimeTask obj) {
		
			int result = this.getTaskType().compareTo(obj.getTaskType());
		if (result == 0) {
			result = this.getTaskCategory().compareTo(obj.getTaskCategory());
		}
		return result;
	}
	
	/**
	 * @return A list of OneTimeTask
	 */
	public static LinkedList<OneTimeTask> getOneTimeTaskList() {
		return oneTimeTaskList;
	}
	
	/**
	 * @return A list of oneTimeTask that have a quantity > 0
	 */
	public static LinkedList<OneTimeTask> getTasks() {
		
		LinkedList<OneTimeTask> tasks = new LinkedList<OneTimeTask>();
		
		for(OneTimeTask task : oneTimeTaskList) {
			if(task.getId() > 0)
				tasks.add(task);
		}
		return tasks;
	}
	
	/**
	 * @return OneTimeTask ID
	 */
	public int getId() {
		return id;
	}
}
