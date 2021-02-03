package domain.models;

import domain.enums.TaskCategories;
import domain.enums.TaskTypes;
import domain.interfaces.iTaskService;

import java.util.Date;

public class RecurringTask extends TaskItem implements iTaskService {
	
	private String count;
	
	//Constructors
	public RecurringTask() {
	}
	
	public RecurringTask(String name, String id, Date date, TaskCategories taskCategories, TaskTypes taskTypes, boolean complete, String expirationDate, String count) {
		super(name, id, date, taskCategories, taskTypes, complete, expirationDate);
		this.count = count;
	}
	
	public String getCount() {
		return count;
	}
	
	public void setCount(String count) {
		this.count = count;
	}
	
	//Methods
	@Override
	public RecurringTask createTask() {
		
		System.out.println(getId()+ ".\n" +
							"Name: " + getName() + ".\n" +
							"Date: " + new Date() + ".\n" +
							"Repeat: " + getCount() + ".\n" +
							"Type: " + getTaskTypes() + ".\n" +
							"Category: " + getTaskCategories() + ".\n" +
							"Expiration date: " + getExpirationDate() + ".\n" +
							"Complete: " + isComplete() + ".\n");
		return null;
	}
	
	@Override
	public void deleteTask() {
	
	}
	
	@Override
	public void editTask() {
	
	}
}
