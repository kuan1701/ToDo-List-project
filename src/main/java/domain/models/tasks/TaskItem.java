package domain.models.tasks;

import domain.enums.TaskCategories;
import domain.enums.TaskTypes;
import domain.interfaces.iTaskService;

import java.util.Date;

abstract public class TaskItem implements iTaskService {
	
	//Fields
	private String description;
	private String date;
	private TaskCategories taskCategories;
	private TaskTypes taskTypes;
	private boolean complete;
	private String expirationDate;
	private static int numberOfTask = 0;
	
	//Constructors
	public TaskItem() {
	}
	
	public TaskItem(String description, String date, TaskCategories taskCategories, TaskTypes taskTypes, boolean complete, String expirationDate) {
		this.description = description;
		this.date = date;
		this.taskCategories = taskCategories;
		this.taskTypes = taskTypes;
		this.complete = complete;
		this.expirationDate = expirationDate;
		numberOfTask++;
	}
	
//Getters and setters
	public String getDescription() {
		
		return description;
	}
	
	public void setDescription(String description) {
		
		this.description = description;
	}
	
	public String getDate() {
		
		return date;
	}
	
	public void setDate(String date) {
		
		this.date = date;
	}
	
	public TaskCategories getTaskCategories() {
		
		return taskCategories;
	}
	
	public void setTaskCategories(TaskCategories taskCategories) {
		
		this.taskCategories = taskCategories;
	}
	
	public TaskTypes getTaskTypes() {
		
		return taskTypes;
	}
	
	public void setTaskTypes(TaskTypes taskTypes) {
		
		this.taskTypes = taskTypes;
	}
	
	public boolean isComplete() {
		
		return complete;
	}
	
	public void setComplete(boolean complete) {
		
		this.complete = complete;
	}
	
	public String getExpirationDate() {
		
		return expirationDate;
	}
	
	public void setExpirationDate(String expirationDate) {
		
		this.expirationDate = expirationDate;
	}
	
	public int getNumberOfTask() {
		return numberOfTask;
	}
}