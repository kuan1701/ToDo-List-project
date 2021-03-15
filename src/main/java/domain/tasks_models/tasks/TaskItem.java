package domain.tasks_models.tasks;

import domain.tasks_models.enums.Categories;
import domain.tasks_models.enums.Priority;
import domain.tasks_models.enums.Types;
import domain.tasks_models.interfaces.iTaskService;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

abstract public class TaskItem implements iTaskService, Serializable {
	
	// Fields
	private static final long serialVersionUID = 5L;
	private String description;
	private Categories categories;
	private Types types;
	private Priority priority;
	private boolean complete = true;
	private int id;
	private static int countId = 0;
	
	private LocalDate currentDate = LocalDate.now();
	private LocalDate expirationDateOfTask;
	private long daysLeft;
	
	
	/**
	 * Constructs an TaskItem with no specified parameters
	 */
	public TaskItem() {
	}
	
	/**
	 * Constructs an TaskItem of a given description,
	 * categories, types, complete, expirationDate
	 *
	 * @param description          TaskItem description
	 * @param categories         TaskItem categories
	 * @param types             TaskItem types
	 * @param priority             TaskItem priority
	 * @param complete             TaskItem complete
	 * @param expirationDateOfTask TaskItem expirationDate
	 */
	public TaskItem(String description, Categories categories, Types types, Priority priority, boolean complete, LocalDate expirationDateOfTask) {
		
		this.description = description;
		this.categories = categories;
		this.types = types;
		this.priority = priority;
		this.complete = complete;
		this.expirationDateOfTask = expirationDateOfTask;
		
		countId++;
		this.id = countId;
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
//	@Override
//	public int compareTo(TaskItem taskItem) {
//
//		int result;
//
//		System.out.println("If you want sort by type, press 1, if by category, press 2, if by type, press 3. If you don't want to sort tasks, press any key.");
//		String scan = scanner.nextLine();
//
//		switch (scan) {
//			case "1":
//				result = this.getTypes().compareTo(taskItem.getTypes());
//				if (result == 0) {
//					result = this.getCategories().compareTo(taskItem.getCategories());
//				}
//				break;
//
//			case "2":
//				result = this.getCategories().compareTo(taskItem.getCategories());
//				if (result == 0) {
//					result = this.getTypes().compareTo(taskItem.getTypes());
//				}
//				break;
//
//			case "3":
//				result = this.getPriority().compareTo(taskItem.getPriority());
//				if (result == 0) {
//					result = this.getTypes().compareTo(taskItem.getTypes());
//				}
//				break;
//
//			default:
//				result = 0;
//				break;
//		}
//		return result;
//	}
	
	// Create method
	@Override
	public void createTask(String description, Categories category, Types type, Priority priority, boolean complete, LocalDate expirationDateOfTask) {
		
		setDescription(description);
		setCategories(category);
		setTypes(type);
		setPriority(priority);
		setComplete(complete);
		setExpirationDateOfTask(expirationDateOfTask);
	}
	
	// Edit method
	@Override
	public void editTask(String description, Categories category, Types type, Priority priority, boolean complete, LocalDate expirationDateOfTask) {
		
		setDescription(description);
		setCategories(category);
		setTypes(type);
		setPriority(priority);
		setComplete(complete);
		setExpirationDateOfTask(expirationDateOfTask);
	}
	
	// toString method
	@Override
	public String toString() {
		
		final StringBuffer sb = new StringBuffer("Task ").append(getId()).append(".\n");
		sb.append("Description: ").append(getDescription()).append(".\n");
		sb.append("Priority: ").append(getPriority()).append(".\n");
		sb.append("Category: ").append(getCategories()).append(".\n");
		sb.append("Expiration date: ").append(getExpirationDate()).append(".\n");
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
	public String getCurrentDate() {
		
		return currentDate.format(DateTimeFormatter.ofPattern("d MMM yyyy"));
	}
	
	/**
	 * @return TaskItem expirationDate
	 */
	
	public String getExpirationDate() {
		
		return expirationDateOfTask.format(DateTimeFormatter.ofPattern("d MMM yyyy"));
	}
	
	public String setExpirationDate(String expirationDate) {
		
		return expirationDate;
	}
	
	public void setCurrent(LocalDate currentDate) {
		
		this.currentDate = currentDate;
	}
	
	public LocalDate getExpirationDateOfTask() {
		
		return expirationDateOfTask;
	}
	
	public void setExpirationDateOfTask(LocalDate expirationDateOfTask) {
		
		this.expirationDateOfTask = expirationDateOfTask;
	}
	
	/**
	 * @return TaskItem category
	 */
	public Categories getCategories() {
		
		return categories;
	}
	
	public void setCategories(Categories categories) {
		
		this.categories = categories;
	}
	
	/**
	 * @return TaskItem type
	 */
	public Types getTypes() {
		
		return types;
	}
	
	public void setTypes(Types types) {
		
		this.types = types;
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
		
		daysLeft = ChronoUnit.DAYS.between(currentDate, expirationDateOfTask);
		
		if (daysLeft < 0) {
			daysLeft = 0;
		}
		return daysLeft;
	}
	
	public void setDaysLeft(long daysLeft) {
		
		this.daysLeft = daysLeft;
	}
	
	/**
	 * @return TaskItem id
	 */
	public int getId() {
		
		return id;
	}
	
	public void setId(int id) {
		
		this.id = id;
	}
}