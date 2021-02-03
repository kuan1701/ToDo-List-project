package Application;

import domain.enums.TaskCategories;
import domain.enums.TaskTypes;
import domain.models.OneTimeTask;
import domain.models.RecurringTask;
import domain.models.TaskItem;
import domain.users.BuildUser;
import domain.users.User;

import java.util.ArrayList;
import java.util.Date;


public class Application {
	
	public static void main(String[] args) {

		//Create a one-time task
		TaskItem oneTimeTask = new OneTimeTask("buy products", "1", new Date(), TaskCategories.DEFAULT, TaskTypes.DEFAULT, false, "05.02.2021");
		
		//Create
		TaskItem recurringTask = new RecurringTask("pay for service", "1", new Date(), TaskCategories.PERSONAL, TaskTypes.IMPORTANT, false, "02.03.2021", "every month");
		
		
		System.out.println("One-time task list");
		ArrayList<TaskItem> oneTimeTasksList = new ArrayList<>();
		
		oneTimeTasksList.add(oneTimeTask);
		(oneTimeTasksList.get(0)).createTask();
		
		System.out.println("Recurring task list");
		ArrayList<TaskItem> recurringTasksList = new ArrayList<>();
		
		recurringTasksList.add(recurringTask);
		(recurringTasksList.get(0)).createTask();
		
		System.out.println("User");
		User firstUser = new User.Builder()
				.withFirstName("Kuan")
				.withLastName("Chin")
				.withUserName("kuan1701")
				.withPassword("17011993")
				.build();
		
		System.out.println(firstUser);
		
		BuildUser<User> A = new BuildUser<>(new User.Builder()
				.withFirstName("Kuan")
				.withLastName("Chin")
				.withPassword("17011993")
				.withUserName("kuan1701"), "id 3232432");

	}
}
