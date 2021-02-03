package domain.models;


import domain.enums.TaskCategories;
import domain.enums.TaskTypes;
import domain.interfaces.iTaskService;

import java.util.Date;

public class OneTimeTask extends TaskItem implements iTaskService {
	
	//Constructors
	public OneTimeTask() {
	}
	
	public OneTimeTask(String name, String id, Date date, TaskCategories taskCategories, TaskTypes taskTypes, boolean complete, String expirationDate) {
		super(name, id, date, taskCategories, taskTypes, complete, expirationDate);
	}
	
	//Methods
	@Override
	public OneTimeTask createTask() {
		System.out.println(getId()+ ".\n" +
							"Name: " + getName() + ".\n" +
							"Date: " + new Date() + ".\n" +
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
