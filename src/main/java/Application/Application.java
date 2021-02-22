package Application;

import domain.enums.Priority;
import domain.enums.Repeats;
import domain.enums.TaskCategory;
import domain.enums.TaskType;
import domain.models.tasks.OneTimeTask;
import domain.models.tasks.RecurringTask;
import domain.models.tasks.TaskItem;
import domain.models.users.User;
import domain.models.users.UserDataBase;
import domain.util.TaskService;

import java.time.LocalDate;

public class Application {
	
	public static void main(String[] args) {
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter the year");
//		int year = scanner.nextInt();
//		System.out.println("Enter the month");
//		int month = scanner.nextInt();
//		System.out.println("Enter the day");
//		int day = scanner.nextInt();
		
		// Create a one-time task
		OneTimeTask oneTimeTask1 = new OneTimeTask(
				"1buy",
				TaskCategory.SHOPPING,
				TaskType.DISPOSABLE,
				Priority.DEFAULT,
				false,
				LocalDate.of(2022, 1, 29));
		
		TaskItem oneTimeTask2 = new OneTimeTask(
				"",
				TaskCategory.SHOPPING,
				TaskType.DISPOSABLE,
				Priority.IMPORTANT,
				false,
				LocalDate.of(2022, 1, 29));
		
		OneTimeTask oneTimeTask3 = new OneTimeTask(
				"3buy cat food",
				TaskCategory.PERSONAL,
				TaskType.DISPOSABLE,
				Priority.IMPORTANT,
				false,
				LocalDate.of(2022, 1, 17));
		
		OneTimeTask oneTimeTask4 = new OneTimeTask(
				"",
				TaskCategory.HOUSEWORK,
				TaskType.DISPOSABLE,
				Priority.URGENTLY,
				false,
				LocalDate.of(2020, 1, 17));
		
		OneTimeTask oneTimeTask5 = new OneTimeTask(
				"1buy products",
				TaskCategory.HOUSEWORK,
				TaskType.DISPOSABLE,
				Priority.DEFAULT,
				false,
				LocalDate.of(2022, 1, 17));
		
		// Create a recurring task
		RecurringTask recurringTask1 = new RecurringTask(
				"1pay utility bills",
				TaskCategory.HOUSEWORK,
				TaskType.REUSABLE,
				Priority.IMPORTANT,
				false,
				LocalDate.of(2022, 1, 17),
				Repeats.ONCE_A_DAY);
		
		TaskItem recurringTask2 = new RecurringTask(
				"2go",
				//new Date(),
				TaskCategory.PERSONAL,
				TaskType.REUSABLE,
				Priority.URGENTLY,
				true,
				LocalDate.of(2022, 1, 17),
				Repeats.ONCE_A_MONTH);
		
		RecurringTask recurringTask3 = new RecurringTask(
				"3go to class",
				TaskCategory.WORK,
				TaskType.REUSABLE,
				Priority.DEFAULT,
				false,
				LocalDate.of(2022, 1, 17),
				Repeats.ONCE_A_WEEK);
		
		TaskService.addTask(oneTimeTask1);
		TaskService.addTask(oneTimeTask2);
		TaskService.addTask(oneTimeTask3);
		TaskService.addTask(oneTimeTask4);
		TaskService.addTask(oneTimeTask5);
		TaskService.addTask(recurringTask1);
		TaskService.addTask(recurringTask2);
		TaskService.addTask(recurringTask3);
		
		
		//Displaying tasks list
		// Displaying all and creating one-time tasks
		System.out.println("-------------------------------");
		System.out.println("    Tasks list of all tasks    ");
		System.out.println("-------------------------------");
		TaskService.printListOfAllTasks();
		
		// Displaying all and creating one-time tasks
		System.out.println("-------------------");
		System.out.println("    Tasks list     ");
		System.out.println("-------------------");
		TaskService.printTasksList();
		
		// Filter by priority
		System.out.println("--------------------------------");
		System.out.println("Filtering tasks list by priority");
		System.out.println("--------------------------------");
		TaskService.filterByPriority(Priority.IMPORTANT);
		
		// Filter by category
		System.out.println("--------------------------------");
		System.out.println("Filtering tasks list by category");
		System.out.println("--------------------------------");
		TaskService.filterByCategory(TaskCategory.SHOPPING);
		
		//Sorting tasks by category
		System.out.println("-------------------------");
		System.out.println("Sorting tasks by category");
		System.out.println("-------------------------");
		TaskService.sortByCategory();
		
		//Sorting tasks by priority
		System.out.println("-------------------------");
		System.out.println("Sorting tasks by priority");
		System.out.println("-------------------------");
		TaskService.sortByPriority();
		
		// Remove duplicate tasks
		System.out.println("------------------------");
		System.out.println("Removing duplicate tasks");
		System.out.println("------------------------");
		TaskService.removeDuplicateTasks();
		
		// Display only description
		System.out.println("--------------------");
		System.out.println("Description of tasks");
		System.out.println("--------------------");
		TaskService.showDescriptionOfTasks();
		
		// Checking the length of the task name
		System.out.println("------------------------------------");
		System.out.println("Checking the length of the task name");
		System.out.println("------------------------------------");
		TaskService.taskNameLength();
		
		
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
		
		UserDataBase.addUser(user);
		UserDataBase.addUser(admin);
		UserDataBase.printListOfUsers();
	}
}
