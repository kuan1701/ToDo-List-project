package Application;

import domain.enums.TaskCategories;
import domain.enums.TaskTypes;
import domain.models.*;

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
		
		User<String> user = new User.Builder<String>()
				.withFirstName("Kuan")
				.withLastName("Chin")
				.withUserName("kuan1701")
				.withPassword("17011993")
				.withID("id1701")
				.build();
		
		user.setId("id1601");
		System.out.println(user.getId());
		
		User<Integer> admin = new User.Builder<Integer>()
				.withUserName("Admin")
				.withPassword("123456")
				.withID(1234567)
				.build();
		System.out.println(admin.getId());
		
	}
}
