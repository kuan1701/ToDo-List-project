package domain.models.tasks;

import domain.Exception.DateException;
import domain.enums.Priority;
import domain.enums.TaskCategory;
import domain.enums.TaskType;
import domain.interfaces.iTaskService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

abstract public class TaskItem implements iTaskService, Comparable<TaskItem> {
	
	Scanner scanner = new Scanner(System.in);
//
//	int year = scanner.nextInt();
//	int month = scanner.nextInt();
//	int day = scanner.nextInt();
	
	// Fields
	private String description;
	private TaskCategory taskCategory;
	private TaskType taskType;
	private Priority priority;
	private boolean complete = true;
	
	private LocalDate creationDateOfTask;
	private LocalDate expirationDateOfTask;
	private long daysLeft;
	
	
	/**
	 * Constructs an TaskItem with no specified parameters
	 */
	public TaskItem() {
	}
	
	/**
	 * Constructs an TaskItem of a given description,
	 * taskCategory, taskType, complete, expirationDate
	 *
	 * @param description          TaskItem description
	 * @param taskCategory         TaskItem taskCategory
	 * @param taskType             TaskItem taskType
	 * @param priority             TaskItem priority
	 * @param complete             TaskItem complete
	 * @param expirationDateOfTask TaskItem expirationDate
	 */
	public TaskItem(String description, TaskCategory taskCategory, TaskType taskType, Priority priority, boolean complete, LocalDate expirationDateOfTask) {
		
		this.description = description;
		this.taskCategory = taskCategory;
		this.taskType = taskType;
		this.priority = priority;
		this.complete = complete;
		this.expirationDateOfTask = expirationDateOfTask;
	}
	
	// METHODS
	// Method equals
	@Override
	public boolean equals(Object that) {
		if (this == that) return true;
		if (!(that instanceof TaskItem)) return false;
		TaskItem taskItem = (TaskItem) that;
		return description.equals(taskItem.description);
		
	}
	
	// Method hashCode
	@Override
	public int hashCode() {
		
		return Objects.hash(description);
	}
	
	// Method compareTo
	@Override
	public int compareTo(TaskItem taskItem) {
		
		int result;
		
		System.out.println("If you want sort by type, press 1, if by category, press 2, if by type, press 3. If you don't want to sort tasks, press any key.");
		String scan = scanner.nextLine();
		
		switch (scan) {
			case "1":
				result = this.getTaskType().compareTo(taskItem.getTaskType());
				if (result == 0) {
					result = this.getTaskCategory().compareTo(taskItem.getTaskCategory());
				}
				break;
			
			case "2":
				result = this.getTaskCategory().compareTo(taskItem.getTaskCategory());
				if (result == 0) {
					result = this.getTaskType().compareTo(taskItem.getTaskType());
				}
				break;
			
			case "3":
				result = this.getPriority().compareTo(taskItem.getPriority());
				if (result == 0) {
					result = this.getTaskType().compareTo(taskItem.getTaskType());
				}
				break;
			
			default:
				result = 0;
				break;
		}
		return result;
	}
	
	// Create method
	@Override
	public void createTask(String description, TaskCategory category, TaskType type, Priority priority, boolean complete, LocalDate expirationDateOfTask) {
		
		setDescription(description);
		setTaskCategory(category);
		setTaskType(type);
		setPriority(priority);
		setComplete(complete);
		setExpirationDateOfTask(expirationDateOfTask);
	}
	
	// Edit method
	@Override
	public void editTask(String description, TaskCategory category, TaskType type, Priority priority, boolean complete, LocalDate expirationDateOfTask) {
		
		setDescription(description);
		setTaskCategory(category);
		setTaskType(type);
		setPriority(priority);
		setComplete(complete);
		setExpirationDateOfTask(expirationDateOfTask);
	}
	
	// toString method
	@Override
	public String toString() {
		
		final StringBuffer sb = new StringBuffer("\n");
		sb.append("Description: ").append(getDescription()).append(".\n");
		sb.append("Creation date: ").append(getCreationDate()).append(".\n");
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
		
		creationDateOfTask = LocalDate.now();
		return creationDateOfTask.format(DateTimeFormatter.ofPattern("d MMM yyyy"));
	}
	
	/**
	 * @return TaskItem expirationDate
	 */
	
	public String getExpirationDate() throws DateException{
		
		daysLeft = ChronoUnit.DAYS.between(creationDateOfTask, expirationDateOfTask);
		
		if (daysLeft >= 0){
			return expirationDateOfTask.format(DateTimeFormatter.ofPattern("d MMM yyyy"));
		} else {
			throw new DateException("expired date");
		}
	}
	
	public String setExpirationDate(String expirationDate) {
		
		return expirationDate;
	}
	
	public void setCreationDateOfTask(LocalDate creationDateOfTask) {
		
		this.creationDateOfTask = creationDateOfTask;
	}
	
	public void setExpirationDateOfTask(LocalDate expirationDateOfTask) {
		this.expirationDateOfTask = expirationDateOfTask;
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
	 * @return TaskItem priority
	 */
	public Priority getPriority() {
		
		return priority;
	}
	
	public void setPriority(Priority priority) {
		
		this.priority = priority;
	}
	
	/**
	 * @return TaskItem days left
	 */
	public long getDaysLeft(){
		
		daysLeft = ChronoUnit.DAYS.between(creationDateOfTask, expirationDateOfTask);
		
		if (daysLeft < 0) {
			daysLeft = 0;
		}
		return daysLeft;
	}
	
	public void setDaysLeft(long daysLeft) {
		
		this.daysLeft = daysLeft;
	}
}