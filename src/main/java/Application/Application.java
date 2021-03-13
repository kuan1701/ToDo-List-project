package Application;

import domain.tasks_models.enums.Categories;
import domain.tasks_models.enums.Priority;
import domain.tasks_models.enums.Repeats;
import domain.tasks_models.enums.Types;
import domain.tasks_models.exceptions.TasksExceptions;
import domain.tasks_models.interfaces.iTasksStorageService;
import domain.tasks_models.tasks.OneTimeTask;
import domain.tasks_models.tasks.RecurringTask;
import domain.tasks_models.tasks.TaskItem;
import domain.tasks_models.util.TaskService;
import domain.tasks_models.util.TasksStorageService;

import java.io.*;
import java.time.LocalDate;

public class Application {
	
	private static final String FILENAME = "D:\\ToDo-List-project\\src\\main\\java\\resources\\tasks.txt";
	private static final iTasksStorageService iTasksStorageService = new TasksStorageService();
	
	public static void main(String[] args) throws IOException, TasksExceptions {
		
		OneTimeTask oneTimeTask1 = new OneTimeTask(
				"1buy",
				Categories.SHOPPING,
				Types.DISPOSABLE,
				Priority.DEFAULT,
				false,
				LocalDate.of(2022, 1, 29));
		
		TaskItem oneTimeTask2 = new OneTimeTask(
				"",
				Categories.SHOPPING,
				Types.DISPOSABLE,
				Priority.IMPORTANT,
				false,
				LocalDate.of(2022, 1, 29));
		
		OneTimeTask oneTimeTask3 = new OneTimeTask(
				"3buy cat food",
				Categories.PERSONAL,
				Types.DISPOSABLE,
				Priority.IMPORTANT,
				false,
				LocalDate.of(2022, 1, 17));
		
		OneTimeTask oneTimeTask4 = new OneTimeTask(
				"",
				Categories.HOUSEWORK,
				Types.DISPOSABLE,
				Priority.URGENTLY,
				false,
				LocalDate.of(2020, 1, 17));
		
		OneTimeTask oneTimeTask5 = new OneTimeTask(
				"1buy products",
				Categories.HOUSEWORK,
				Types.DISPOSABLE,
				Priority.DEFAULT,
				false,
				LocalDate.of(2022, 1, 17));
		
		// Create a recurring task
		RecurringTask recurringTask1 = new RecurringTask(
				"1pay utility bills",
				Categories.HOUSEWORK,
				Types.REUSABLE,
				Priority.IMPORTANT,
				false,
				LocalDate.of(2022, 1, 17),
				Repeats.ONCE_A_DAY);
		
		TaskItem recurringTask2 = new RecurringTask(
				"2go",
				//new Date(),
				Categories.PERSONAL,
				Types.REUSABLE,
				Priority.URGENTLY,
				true,
				LocalDate.of(2022, 1, 17),
				Repeats.ONCE_A_MONTH);
		
		RecurringTask recurringTask3 = new RecurringTask(
				"3go to class",
				Categories.WORK,
				Types.REUSABLE,
				Priority.DEFAULT,
				false,
				LocalDate.of(2022, 1, 17),
				Repeats.ONCE_A_WEEK);
		
		RecurringTask recurringTask4 = new RecurringTask(
				"learn Java",
				Categories.WORK,
				Types.REUSABLE,
				Priority.DEFAULT,
				false,
				LocalDate.of(2021, 9, 17),
				Repeats.ONCE_A_WEEK);
		
		RecurringTask recurringTask5 = new RecurringTask(
				"learn dart",
				Categories.WORK,
				Types.REUSABLE,
				Priority.DEFAULT,
				false,
				LocalDate.of(2021, 9, 17),
				Repeats.ONCE_A_WEEK);
		
		TaskService.addTask(oneTimeTask1);
		TaskService.addTask(oneTimeTask2);
		TaskService.addTask(oneTimeTask3);
		TaskService.addTask(oneTimeTask4);
		TaskService.addTask(oneTimeTask5);
		TaskService.addTask(recurringTask1);
		TaskService.addTask(recurringTask2);
		TaskService.addTask(recurringTask3);
		TaskService.addTask(recurringTask4);
		TaskService.addTask(recurringTask5);
	
		//SerializationTaskService.serialize(TaskService.getTasks(), FILENAME);
		
		// Save tasks
		iTasksStorageService.writeTasks(TaskService.getTasks());
		
		// Read tasks
		iTasksStorageService.readTasks();
		
		
//		//Displaying tasks list
//		// Displaying all and creating one-time tasks
//		System.out.println("-------------------------------");
//		System.out.println("    Tasks list of all tasks    ");
//		System.out.println("-------------------------------");
//		TaskService.printListOfAllTasks();
//
//		// Displaying all and creating one-time tasks
//		System.out.println("-------------------");
//		System.out.println("    Tasks list     ");
//		System.out.println("-------------------");
//		TaskService.printTasksList();
//
//		// Filter by priority
//		System.out.println("--------------------------------");
//		System.out.println("Filtering tasks list by priority");
//		System.out.println("--------------------------------");
//		TaskService.filterByPriority(Priority.IMPORTANT);
//
//		// Filter by category
//		System.out.println("--------------------------------");
//		System.out.println("Filtering tasks list by category");
//		System.out.println("--------------------------------");
//		TaskService.filterByCategory(Categories.SHOPPING);
//
//		//Sorting tasks by category
//		System.out.println("-------------------------");
//		System.out.println("Sorting tasks by category");
//		System.out.println("-------------------------");
//		TaskService.sortByCategory();
//
//		//Sorting tasks by priority
//		System.out.println("-------------------------");
//		System.out.println("Sorting tasks by priority");
//		System.out.println("-------------------------");
//		TaskService.sortByPriority();
//
//		// Remove duplicate tasks
//		System.out.println("------------------------");
//		System.out.println("Removing duplicate tasks");
//		System.out.println("------------------------");
//		TaskService.removeDuplicateTasks();
//
//		// Display only description
//		System.out.println("--------------------");
//		System.out.println("Description of tasks");
//		System.out.println("--------------------");
//		TaskService.showDescriptionOfTasks();
//
//		// Checking the length of the task name
//		System.out.println("------------------------------------");
//		System.out.println("Checking the length of the task name");
//		System.out.println("------------------------------------");
//		TaskService.taskNameLength();
	}
}
