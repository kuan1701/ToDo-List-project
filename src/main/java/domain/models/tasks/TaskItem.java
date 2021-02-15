package domain.models.tasks;

import domain.enums.Priority;
import domain.enums.TaskCategory;
import domain.enums.TaskType;
import domain.interfaces.iTaskService;

import java.util.*;
import java.util.stream.Collectors;

abstract public class TaskItem implements iTaskService, Comparable<TaskItem> {
	
	Scanner scanner = new Scanner(System.in);
	
	// Fields
	private String description;
	private String date;
	private TaskCategory taskCategory;
	private TaskType taskType;
	private Priority priority;
	private boolean complete;
	private String expirationDate;
	private static int id = 1;
	
	/**
	 * Constructs an TaskItem with no specified parameters
	 */
	public TaskItem() {
	
	}
	
	/**
	 * Constructs an TaskItem of a given description, creationDate,
	 * taskCategory, taskType, complete, expirationDate
	 *
	 * @param description    TaskItem description
	 * @param creationDate   TaskItem creationDate
	 * @param taskCategory   TaskItem taskCategory
	 * @param taskType       TaskItem taskType
	 * @param priority       TaskItem priority
	 * @param complete       TaskItem complete
	 * @param expirationDate TaskItem expirationDate
	 */
	public TaskItem(String description, String creationDate, TaskCategory taskCategory, TaskType taskType, Priority priority, boolean complete, String expirationDate) {
		
		this.description = description;
		this.date = creationDate;
		this.taskCategory = taskCategory;
		this.taskType = taskType;
		this.priority = priority;
		this.complete = complete;
		this.expirationDate = expirationDate;
		
	}
	
	// METHODS
	// Method equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof TaskItem)) return false;
		TaskItem taskItem = (TaskItem) obj;
		return getDescription().equals(taskItem.getDescription());
	}
	
	// Method hashCode
	@Override
	public int hashCode() {
		
		return Objects.hash(getDescription());
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
	public void createTask(String description, String creationDate, TaskCategory category, TaskType type, Priority priority, boolean complete, String expirationDate) {
		
		setDescription(description);
		setCreationDate(creationDate);
		setTaskCategory(category);
		setTaskType(type);
		setPriority(priority);
		setComplete(complete);
		setExpirationDate(expirationDate);
	}
	
	// Edit method
	@Override
	public void editTask(String description, String creationDate, TaskCategory category, TaskType type, Priority priority, boolean complete, String expirationDate) {
		
		setDescription(description);
		setCreationDate(creationDate);
		setTaskCategory(category);
		setTaskType(type);
		setPriority(priority);
		setComplete(complete);
		setExpirationDate(expirationDate);
	}
	
	// toString method
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("\n");
		sb.append("Description: ").append(getDescription()).append(".\n");
		sb.append("Creation date: ").append(getCreationDate()).append(".\n");
		sb.append("Type: ").append(getTaskType()).append(".\n");
		sb.append("Category: ").append(getTaskCategory()).append(".\n");
		sb.append("Priority: ").append(getPriority()).append(".\n");
		sb.append("Expiration date: ").append(getExpirationDate()).append(".\n");
		sb.append("Complete: ").append(isComplete()).append(".\n");
		return sb.toString();
	}
	
	// Print task list
	public static void printTask(TaskItem taskItem) {
		
		System.out.println(taskItem);
	}
	
	//Stream API
	// Search by priority
	public static List<TaskItem> filterByPriority(List<TaskItem> taskItemList, Priority priority) {
		
		return taskItemList.stream()
				.filter(taskItem -> taskItem.getPriority().equals(priority))
				.collect(Collectors.toList());
	}
	
	// Search by category
	public static List<TaskItem> filterByCategory(List<TaskItem> taskItemList, TaskCategory taskCategory) {
		
		return taskItemList.stream()
				.filter(taskItem -> taskItem.getTaskCategory().equals(taskCategory))
				.collect(Collectors.toList());
	}
	
	// Search by type
	public static List<TaskItem> filterByType(List<TaskItem> taskItemList, TaskType taskType) {
		
		return taskItemList.stream()
				.filter(taskItem -> taskItem.getTaskType().equals(taskType))
				.collect(Collectors.toList());
	}
	
	// Remove duplicate tasks
	public static List<TaskItem> removeDuplicateTasks(List<TaskItem> taskItemList) {
		
		return taskItemList.stream()
				.distinct()
				.collect(Collectors.toList());
	}
	
	// Sorting tasks by category
	public static List<TaskItem> sortByCategory(List<TaskItem> taskItemList) {
		
		return taskItemList.stream()
				.sorted(Comparator.comparing(TaskItem :: getTaskCategory))
				.collect(Collectors.toList());
	}
	
	// Sorting tasks priority
	public static List<TaskItem> sortByPriority(List<TaskItem> taskItemList) {
		
		return taskItemList.stream()
				.sorted(Comparator.comparing(TaskItem :: getPriority))
				.collect(Collectors.toList());
	}
	
	// Sorting tasks type
	public static List<TaskItem> sortByType(List<TaskItem> taskItemList) {
		
		return taskItemList.stream()
				.sorted(Comparator.comparing(TaskItem :: getTaskType))
				.collect(Collectors.toList());
	}
	
	// Print task list
	public static void printTasksList(List<TaskItem> taskItemList) {
		
		taskItemList.forEach((t) -> {
			int idOfTasks = id++;
			System.out.println("Task " + idOfTasks + "." + t);
		});
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
	 * @return TaskItem priority
	 */
	public Priority getPriority() {
		return priority;
	}
	
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	
	// Method for displaying task description
	public static int num = 1;
	public static void showDescriptionOfTasks(List<TaskItem> taskItemList) {
		
		taskItemList.forEach((t) -> {
			
			int count = num++;
			Optional<String> descriptionOfTasks = Optional.of(t.getDescription());
			System.out.println(descriptionOfTasks.map(s -> ("Task " + count + ": " + s + ".")).toString()
					.replace("[", " ")
					.replace("]", " ")
					.replace("Optional", "")
			);
		});
	}
	
	// Method for checking the length of the task name
	public static int num2 = 1;
	public static void taskNameLength(List<TaskItem> taskItemList) {
		
		taskItemList.forEach((t) -> {
			
			int count = num2++;
			boolean allMatch = taskItemList.stream()
					.allMatch(word -> (t.getDescription()).length() > 5);
			System.out.println(" Task " + count + ": " + allMatch + ".");
		});
		
		
	}
}