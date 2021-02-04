package domain.models;

import domain.enums.TaskCategories;
import domain.enums.TaskTypes;
import domain.interfaces.iTaskService;

import java.util.Date;

abstract public class TaskItem implements iTaskService {
	
	//Fields
	private String name;
	private String id;
	private Date date;
	private TaskCategories taskCategories;
	private TaskTypes taskTypes;
	private boolean complete;
	private String expirationDate;
	
	//Constructors
	
	public TaskItem() {
	}
	
	public TaskItem(String name, String id, Date date, TaskCategories taskCategories, TaskTypes taskTypes, boolean complete, String expirationDate) {
		this.name = name;
		this.id = id;
		this.date = date;
		this.taskCategories = taskCategories;
		this.taskTypes = taskTypes;
		this.complete = complete;
		this.expirationDate = expirationDate;
	}
	
//Getters and setters
	
	
	public String getName() {
		
		return name;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public String getId() {
		
		return id;
	}
	
	public void setId(String id) {
		
		this.id = id;
	}
	
	public Date getDate() {
		
		return date;
	}
	
	public void setDate(Date date) {
		
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
}