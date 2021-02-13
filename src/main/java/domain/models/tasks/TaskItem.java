package domain.models.tasks;

import domain.enums.TaskCategory;
import domain.enums.TaskType;
import domain.interfaces.iTaskService;

import java.util.Objects;
import java.util.Scanner;

abstract public class TaskItem implements iTaskService, Comparable<TaskItem> {
	
	Scanner scanner = new Scanner(System.in);
	
	// Fields
	private String description;
	private String date;
	private TaskCategory taskCategory;
	private TaskType taskType;
	private boolean complete;
	private String expirationDate;
	//private static int numberOfTask = 0;
	
	/**
	 * Constructs an TaskItem with no specified parameters
	 */
	public TaskItem() {
		
		//numberOfTask++;
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
		//numberOfTask++;
	}
	
	// METHODS
	// Method equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof TaskItem)) return false;
		TaskItem taskItem = (TaskItem) obj;
		return Objects.equals(getDescription(), taskItem.getDescription()) &&
				getTaskCategory() == taskItem.getTaskCategory() &&
				getTaskType() == taskItem.getTaskType();
	}
	
	// Method hashCode
	@Override
	public int hashCode() {
		
		return Objects.hash(getDescription(), getTaskCategory(), getTaskType());
	}
	
	// Method compareTo
	@Override
	public int compareTo(TaskItem obj) {
		
		System.out.println("If you want to sort tasks press 1, if not press any key.");
		String step1 = scanner.nextLine();
		
		int result;
		
		if (step1.equals("1")) {
			
			System.out.println("If you want sort by type, press 1, if by category, press 2. If you don't want to sort tasks, press any key.");
			String scan = scanner.nextLine();
			
			if (scan.equals("1")) {
				
				result = this.getTaskType().compareTo(obj.getTaskType());
			} else if (scan.equals("2")) {
				result = this.getTaskCategory().compareTo(obj.getTaskCategory());
			} else {
				result = 0;
			}
		} else {
			
			result = 0;
		}
		
		return result;
	}
	
	// Create method
	@Override
	public void createTask(String description, String creationDate, TaskCategory category, TaskType type, boolean complete, String expirationDate) {
		
		setDescription(description);
		setCreationDate(creationDate);
		setTaskCategory(category);
		setTaskType(type);
		setComplete(complete);
		setExpirationDate(expirationDate);
	}
	
	// Delete method
	@Override
	public void deleteTask(TaskItem taskItem) {
	
	}
	
	// Edit method
	@Override
	public void editTask(String description, String creationDate, TaskCategory category, TaskType type, boolean complete, String expirationDate) {
		
		setDescription(description);
		setCreationDate(creationDate);
		setTaskCategory(category);
		setTaskType(type);
		setComplete(complete);
		setExpirationDate(expirationDate);
	}
	
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
	
	// Getters and setters
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
//	public static int getNumberOfTask() {
//
//		return numberOfTask;
//	}
}