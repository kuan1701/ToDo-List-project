package Application;

import domain.enums.TaskCategory;
import domain.enums.TaskType;
import domain.models.tasks.OneTimeTask;
import domain.models.tasks.RecurringTask;
import domain.models.tasks.TaskItem;
import domain.models.users.User;

import java.util.Collections;

public class Application {
	
	public static void main(String[] args) {

		// Create a one-time task
		OneTimeTask oneTimeTask1 = new OneTimeTask(
				"1buy products",
				"02.02.2021 11:20",
				TaskCategory.SHOPPING,
				TaskType.IMPORTANT,
				false,
				"08.02.2021");
		
		TaskItem oneTimeTask2 = new OneTimeTask();
		oneTimeTask2.createTask("2buy cat food",
				"04.02.2021 16:48",
				TaskCategory.SHOPPING,
				TaskType.URGENTLY,
				false,
				"10.02.2021");
		
		OneTimeTask oneTimeTask3 = new OneTimeTask(
				"3buy cat food",
				"04.02.2021 16:48",
				TaskCategory.PERSONAL,
				TaskType.URGENTLY,
				false,
				"10.02.2021");
		
		// Create a recurring task
		RecurringTask recurringTask1 = new RecurringTask();
						recurringTask1.createTask(
						"1pay utility bills",
						"20.02.2021 14:38",
						TaskCategory.HOUSEWORK,
						TaskType.IMPORTANT,
						false,
						"25.02.2021",
						"every month"		);
		
		TaskItem recurringTask2 = new RecurringTask(
						"2go to the car diagnostics",
						"02.02.2021 13:27",
						TaskCategory.PERSONAL,
						TaskType.IMPORTANT,
						false,
						"20.02.2021",
						"every month");
		
		RecurringTask recurringTask3 = new RecurringTask(
						"go to class",
						"10.02.2021 23:14",
						TaskCategory.WORK,
						TaskType.IMPORTANT,
						false,
						"10.02.2021",
						"2 times a week");
		
		
		// Displaying all and creating one-time tasks
		System.out.println("------------------");
		System.out.println("One-time task list");
		System.out.println("------------------");
		
		// Delete the task
		oneTimeTask3.deleteTask(oneTimeTask3);
		
		// Change task parameters
		oneTimeTask1.editTask("do homework", "09/02/2021 22:36", TaskCategory.WORK, TaskType.DEFAULT, true, "11/02/2021");
		
		// List of one-time tasks
		Collections.sort(OneTimeTask.getOneTimeTaskList());
		//Assigns a sequential number to each task
		OneTimeTask.getIdOfOneTimeTask();
		
		// Displaying and creating all recurring tasks
		System.out.println("-------------------");
		System.out.println("Recurring task list");
		System.out.println("-------------------");
		
		// Delete the task
		recurringTask2.deleteTask(recurringTask2);
		
		// Change task parameters
		recurringTask3.editTask("learn java", "12.02.2021 15:36", TaskCategory.PERSONAL, TaskType.IMPORTANT, true, "15.04.2021", "everyday");
		
		// List of recurring tasks
		Collections.sort(RecurringTask.getRecurringTaskList());
		//Assigns a sequential number to each task
		RecurringTask.getIdOfRecurringTask();
		
		
		// Total numbers of tasks
//		System.out.println("---------------------------");
//		System.out.println("In total, you have " + TaskItem.getNumberOfTask() + " tasks.");
//		System.out.println("---------------------------\n");
		
		
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
