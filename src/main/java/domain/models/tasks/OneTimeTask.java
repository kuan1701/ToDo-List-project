package domain.models.tasks;

import domain.enums.TaskCategory;
import domain.enums.TaskType;
import domain.interfaces.iTaskService;

import java.util.LinkedList;
import java.util.Objects;

public class OneTimeTask extends TaskItem implements iTaskService, Comparable<OneTimeTask> {
	
	//Generate sequence numbers when creating a task
	private static int numOfOneTimeTask = 1;

	//Assign a serial number to a task for further comparison
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
	public void createTask(String description, String creationDate, TaskCategory category, TaskType type, boolean complete, String expirationDate) {
		
		setDescription(description);
		setCreationDate(creationDate);
		setTaskCategory(category);
		setTaskType(type);
		setComplete(complete);
		setExpirationDate(expirationDate);
	}
	
	@Override
	public void deleteTask(TaskItem taskItem) {
		oneTimeTaskList.remove(taskItem);
	}
	
	@Override
	public void editTask(String description, String creationDate, TaskCategory category, TaskType type, boolean complete, String expirationDate) {
		
		setDescription(description);
		setCreationDate(creationDate);
		setTaskCategory(category);
		setTaskType(type);
		setComplete(complete);
		setExpirationDate(expirationDate);
	}
	
	
	//Method toString
	@Override
	public String toString() {
		
		final StringBuffer sb = new StringBuffer("\n");
		sb.append("Description: ").append(getDescription()).append(".\n");
		sb.append("Creation date: ").append(getCreationDate()).append(".\n");
		sb.append("Type: ").append(getTaskType()).append(".\n");
		sb.append("Category: ").append(getTaskCategory()).append(".\n");
		sb.append("Expiration date: ").append(getExpirationDate()).append(".\n");
		sb.append("Complete: ").append(isComplete()).append(".\n");
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
	 * @return A list of oneTimeTask
	 */
	public static LinkedList<OneTimeTask> getTasks() {
		
		return new LinkedList<OneTimeTask>(oneTimeTaskList);
	}
	
	/**
	 * @return OneTimeTask ID
	 */
	public int getId() {
		
		return id;
	}
	
	//Method for assigns a sequential number to each task
	public static void getIdOfOneTimeTask() {
		
		for (TaskItem oTT : OneTimeTask.getTasks()) {
			
			int idOfOneTimeTask = numOfOneTimeTask++;
			System.out.println("Task " + idOfOneTimeTask + "." + oTT);
		}
	}
}
