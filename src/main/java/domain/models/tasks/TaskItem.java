package domain.models.tasks;

import domain.enums.TaskCategory;
import domain.enums.TaskType;

abstract public class TaskItem {
	
	//Fields
	private String description;
	private String date;
	private TaskCategory taskCategory;
	private TaskType taskType;
	private boolean complete;
	private String expirationDate;
	private static int numberOfTask = 0;
	
	/**
	 * Constructs an TaskItem with no specified parameters
	 */
	public TaskItem() {
		
		numberOfTask++;
	}
	
	/**
	 * Constructs an TaskItem of a given description, creationDate,
	 * taskCategory, taskType, complete, expirationDate
	 * @param description TaskItem description
	 * @param creationDate TaskItem creationDate
	 * @param taskCategory TaskItem taskCategory
	 * @param taskType TaskItem taskType
	 * @param complete TaskItem complete
	 * @param expirationDate TaskItem expirationDate
	 */
	public TaskItem(String description, String creationDate, TaskCategory taskCategory, TaskType taskType, boolean complete, String expirationDate) {
		
		this.description = description;
		this.date = creationDate;
		this.taskCategory = taskCategory;
		this.taskType = taskType;
		this.complete = complete;
		this.expirationDate = expirationDate;
		numberOfTask++;
	}
	
	//Getters and setters
	/**
	 * @return TaskItem description
	 */
	public String getDescription() {
		
		return description;
	}
	
	public void setDescription(String description) {
		
		this.description = description;
	}
	
	/**
	 * @return TaskItem creationDate
	 */
	public String getCreationDate() {
		
		return date;
	}
	
	public void setCreationDate(String date) {
		
		this.date = date;
	}
	
	/**
	 * @return TaskItem category
	 */
	public TaskCategory getTaskCategory() {
		
		return taskCategory;
	}
	
	public void setTaskCategory(TaskCategory taskCategory) {
		
		this.taskCategory = taskCategory;
	}
	
	/**
	 * @return TaskItem type
	 */
	public TaskType getTaskType() {
		
		return taskType;
	}
	
	public void setTaskType(TaskType taskType) {
		
		this.taskType = taskType;
	}
	
	/**
	 * @return TaskItem complete
	 */
	public boolean isComplete() {
		
		return complete;
	}
	
	public void setComplete(boolean complete) {
		
		this.complete = complete;
	}
	
	/**
	 * @return TaskItem expirationDate
	 */
	public String getExpirationDate() {
		
		return expirationDate;
	}
	
	public void setExpirationDate(String expirationDate) {
		
		this.expirationDate = expirationDate;
	}
	
	/**
	 * @return TaskItem number
	 */
	public static int getNumberOfTask() {
		
		return numberOfTask;
	}
}