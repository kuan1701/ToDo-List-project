package Application;

import domain.enums.Priority;
import domain.enums.TaskCategory;
import domain.enums.TaskType;
import domain.models.tasks.OneTimeTask;
import domain.models.tasks.RecurringTask;
import domain.models.tasks.TaskItem;
import domain.models.users.User;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Application {
	
	public static void main(String[] args) {
		
		// Create a one-time task
		OneTimeTask oneTimeTask1 = new OneTimeTask(
				"1buy products",
				"02.02.2021 11:20",
				TaskCategory.SHOPPING,
				TaskType.DISPOSABLE,
				Priority.DEFAULT,
				false,
				"08.02.2021");
		
		TaskItem oneTimeTask2 = new OneTimeTask(
				"2buy cat food",
				"04.02.2021 16:48",
				TaskCategory.SHOPPING,
				TaskType.DISPOSABLE,
				Priority.IMPORTANT,
				false,
				"10.02.2021");
		
		OneTimeTask oneTimeTask3 = new OneTimeTask(
				"3buy cat food",
				"04.02.2021 16:48",
				TaskCategory.PERSONAL,
				TaskType.DISPOSABLE,
				Priority.IMPORTANT,
				false,
				"10.02.2021");
		
		OneTimeTask oneTimeTask4 = new OneTimeTask(
				"4buy cat food",
				"04.02.2021 16:48",
				TaskCategory.HOUSEWORK,
				TaskType.DISPOSABLE,
				Priority.URGENTLY,
				false,
				"10.02.2021");
		
		// Create a recurring task
		RecurringTask recurringTask1 = new RecurringTask(
				"1pay utility bills",
				"20.02.2021 14:38",
				TaskCategory.HOUSEWORK,
				TaskType.REUSABLE,
				Priority.IMPORTANT,
				false,
				"25.02.2021",
				"every month");
		
		TaskItem recurringTask2 = new RecurringTask(
				"2go to the car diagnostics",
				"02.02.2021 13:27",
				TaskCategory.PERSONAL,
				TaskType.REUSABLE,
				Priority.URGENTLY,
				false,
				"20.02.2021",
				"every month");
		
		RecurringTask recurringTask3 = new RecurringTask(
				"3go to class",
				"10.02.2021 23:14",
				TaskCategory.WORK,
				TaskType.REUSABLE,
				Priority.DEFAULT,
				false,
				"10.02.2021",
				"2 times a week");
		
		// Displaying all and creating one-time tasks
		System.out.println("-------------------");
		System.out.println("    Tasks list     ");
		System.out.println("-------------------");
		
		List<TaskItem> tasksList = new LinkedList<TaskItem>();
		tasksList.add(oneTimeTask1);
		tasksList.add(oneTimeTask2);
		tasksList.add(oneTimeTask3);
		tasksList.add(oneTimeTask4);
		tasksList.add(recurringTask1);
		tasksList.add(recurringTask2);
		tasksList.add(recurringTask3);
		
		//Displaying tasks list
		//TaskItem.printTasksList(tasksList);
		
		// Filter
		//List<TaskItem> important = TaskItem.filterTaskItem(tasksList, Priority.IMPORTANT);
		//TaskItem.printTasksList(important);
		
		//Sorting tasks
		List<TaskItem> category = TaskItem.sortTaskItem(tasksList);
		TaskItem.printTasksList(category);
		
		
		
		// Displaying and creating users
		System.out.println("-------------------");
		System.out.println("       Users       ");
		System.out.println("-------------------");
		
		User<String> user = new User.Builder<String>()
				.withFirstName("Kuan")
				.withLastName("Chin")
				.withUserName("kuan1701")
				.withPassword("17011993")
				.withID("id1701")
				.build();
		user.editAccount("Kot", "Tiger", "tiger2014", "23554");
		
		User<Integer> admin = new User.Builder<Integer>()
				.withFirstName("Kuan")
				.withLastName("Chin")
				.withUserName("Admin")
				.withPassword("123456")
				.withID(1234567)
				.build();
		User.getListOfUsers();
	}
}
