package domain.models.tasks;

import domain.enums.TaskCategories;
import domain.enums.TaskTypes;
import domain.interfaces.iTaskService;

import java.util.Objects;

public class RecurringTask extends TaskItem implements iTaskService, Comparable<RecurringTask> {
	
	private String count;
	
	//Generate sequence numbers when creating a task
	public static int num = 1;
	private final int id = num++;
	
	//Constructors
	public RecurringTask() {
	}
	
	public RecurringTask(String description, String date, TaskCategories taskCategories, TaskTypes taskTypes, boolean complete, String expirationDate, String count) {
		super(description, date, taskCategories, taskTypes, complete, expirationDate);
		this.count = count;
	}
	
	//Methods
	@Override
	public void createTask() {
		
		System.out.println("Task " + getId() + ".\n" +
							"Name: " + getDescription() + ".\n" +
							"Creation date: " + getDate() + ".\n" +
							"Repeat: " + getCount() + ".\n" +
							"Type: " + getTaskTypes() + ".\n" +
							"Category: " + getTaskCategories() + ".\n" +
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
	//Comparing tasks by type by category
	@Override
	public int compareTo(RecurringTask obj) {
		
		int result = this.getTaskTypes().compareTo(obj.getTaskTypes());
		
		if (result == 0) {
			result = this.getTaskCategories().compareTo(obj.getTaskCategories());
		}
		return result;
	}
	
	//Method toString
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Task " + id);
		sb.append(". Description: ").append(getDescription());
		sb.append(". Creation date: ").append(getDate());
		sb.append(". Repeat: ").append(getCount());
		sb.append(". Type: ").append(getTaskTypes());
		sb.append(". Category: ").append(getTaskCategories());
		sb.append(". Expiration date: ").append(getExpirationDate());
		sb.append(". Complete: ").append(isComplete());
		sb.append('.');
		return sb.toString();
	}
	//Getters and setters
	
	public int getId() {
		
		return id;
	}
	
	public String getCount() {
		
		return count;
	}
	
	public void setCount(String count) {
		
		this.count = count;
	}
}
