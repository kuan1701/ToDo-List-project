package domain.models.tasks;

import domain.enums.TaskCategory;
import domain.enums.TaskType;
import domain.interfaces.iTaskService;

import java.util.LinkedList;

public class OneTimeTask extends TaskItem implements iTaskService {
	
	// Generate sequence numbers when creating a task
	private static int numOfOneTimeTask = 1;
	
	// Create a list of one-time task
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
	
	// Methods
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
	
	// Method toString
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
	
	/**
	 * @return A list of OneTimeTask
	 */
	public static LinkedList<OneTimeTask> getOneTimeTaskList() {
		
		return oneTimeTaskList;
	}
	
	// Method for assigns a sequential number to each task
	public static void getIdOfOneTimeTask() {
		
		for (TaskItem oTT : OneTimeTask.getOneTimeTaskList()) {
			
			int idOfOneTimeTask = numOfOneTimeTask++;
			System.out.println("Task " + idOfOneTimeTask + "." + oTT);
		}
	}
}
