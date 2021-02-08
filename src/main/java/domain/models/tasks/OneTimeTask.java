package domain.models.tasks;


import domain.enums.TaskCategories;
import domain.enums.TaskTypes;
import domain.interfaces.iTaskService;

import java.util.Objects;

public class OneTimeTask extends TaskItem implements iTaskService, Comparable<OneTimeTask> {
	
	//Generate sequence numbers when creating a task
	public static int num = 1;
	private final int id = num++;
	
	//Constructors
	public OneTimeTask() {
	}
	
	public OneTimeTask(String description, String date, TaskCategories taskCategories, TaskTypes taskTypes, boolean complete, String expirationDate) {
		super(description, date, taskCategories, taskTypes, complete, expirationDate);

	}
	
	//Methods
	@Override
	public void createTask() {
		System.out.println("Task " + getId() + ".\n" +
							"Description: " + getDescription() + ".\n" +
							"Creation date: " + getDate() + ".\n" +
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
	
	//Method toString
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Task " + id);
		sb.append(". Description: ").append(getDescription());
		sb.append(". Creation date: ").append(getDate());
		sb.append(". Type: ").append(getTaskTypes());
		sb.append(". Category: ").append(getTaskCategories());
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
		
		int result = this.getTaskTypes().compareTo(obj.getTaskTypes());
		
		if (result == 0) {
			result = this.getTaskCategories().compareTo(obj.getTaskCategories());
		}
		return result;
	}
	
	//Getters and setters
	public int getId() {
		return id;
	}
}
