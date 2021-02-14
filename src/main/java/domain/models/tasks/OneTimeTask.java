package domain.models.tasks;

import domain.enums.TaskCategory;
import domain.enums.TaskType;

import java.util.LinkedList;
import java.util.stream.Stream;

public class OneTimeTask extends TaskItem {
	
	// Generate sequence numbers when creating a task
	private static int numOfOneTimeTask = 1;
	
	// Create a list of one-time task
	private static final LinkedList<TaskItem> oneTimeTaskList = new LinkedList<TaskItem>();
	
	Stream oTTStream = oneTimeTaskList.stream();
	
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
	public void deleteTask(TaskItem taskItem) {
		
		oneTimeTaskList.remove(taskItem);
	}
	
	/**
	 * @return A list of OneTimeTask for sort
	 */
	public static LinkedList<TaskItem> sortOneTimeTaskList() {
		
		return oneTimeTaskList;
	}
	
	// Displaying the One-time task list
	public static void getOneTimeTaskList() {
		
		for (TaskItem oTT : oneTimeTaskList) {
			
			int idOfOneTimeTask = numOfOneTimeTask++;
			System.out.println("Task " + idOfOneTimeTask + "." + oTT);
		}
	}
}
