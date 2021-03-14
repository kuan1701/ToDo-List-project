package domain.tasks_models.util;

import domain.tasks_models.exceptions.TasksExceptions;
import domain.tasks_models.enums.Priority;
import domain.tasks_models.enums.Categories;
import domain.tasks_models.enums.Types;
import domain.tasks_models.tasks.OneTimeTask;
import domain.tasks_models.tasks.TaskItem;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class TaskService {
	
	private static List<TaskItem> tasksList = new LinkedList<TaskItem>();
	
	public TaskService() {
	}
	
	// create one-time task
	public static void createOneTimeTask() {
		
		OneTimeTask oneTimeTask = new OneTimeTask();
	}
	
	
	// add task
	public static void addTask(TaskItem taskItem) {
		
		boolean taskExists = tasksList.stream()
				.anyMatch(task -> task.getDescription().equals(taskItem.getDescription()) &&
						task.getCategories().equals(taskItem.getCategories()) &&
						task.getTypes().equals(taskItem.getTypes()));
		
		if (!taskExists) {
			tasksList.add(taskItem);
		}
	}
	
	// delete task
	public static void deleteTask(String description) {
		tasksList.stream()
				.filter(task -> task.getDescription().equals(description))
				.findFirst()
				.ifPresent(tasksList :: remove);
	}
	
	// Print task list
	public static void printTask(TaskItem taskItem) throws TasksExceptions {
		
		if (taskItem.getDescription().equals("")) {
			System.out.println(taskItem);
		} else {
			throw new TasksExceptions(TasksExceptions.NO_DESCRIPTION);
		}
	}
	
	// Print task list
	public static void printTasksList() {
		
		tasksList.removeIf(TaskItem :: isComplete);
		
		tasksList.forEach((t) -> {
			noDescriptionException(t);
			finishedTask(t);
			System.out.println(t);
		});
	}
	
	// Print list of all tasks
	public static void printListOfAllTasks() {
		
		tasksList.forEach((t) -> {
			noDescriptionException(t);
			finishedTask(t);
			System.out.println(t);
		});
	}
	
	//finished task
	private static void finishedTask(TaskItem t) {
		if (t.isComplete()) {
			t.setCategories(Categories.FINISHED);
		}
	}
	
	//Stream API
	// Search by priority
	public static void filterByPriority(Priority priority) {
		
		tasksList.stream()
				.filter(task -> task.getPriority().equals(priority))
				.forEach(System.out :: println);
	}
	
	// Search by category
	public static void filterByCategory(Categories categories) {
		
		tasksList.stream()
				.filter(taskItem -> taskItem.getCategories().equals(categories))
				.forEach(System.out :: println);
	}
	
	// Search by type
	public static void filterByType(Types types) {
		
		tasksList.stream()
				.filter(taskItem -> taskItem.getTypes().equals(types))
				.forEach(System.out :: println);
	}
	
	// Remove duplicate tasks
	public static void removeDuplicateTasks() {
		
		tasksList.stream()
				.distinct()
				.forEach(System.out :: println);
	}
	
	// Sorting tasks by category
	public static void sortByCategory() {
		
		tasksList.stream()
				.sorted(Comparator.comparing(TaskItem :: getCategories))
				.forEach(System.out :: println);
	}
	
	// Sorting tasks priority
	public static void sortByPriority() {
		
		tasksList.stream()
				.sorted(Comparator.comparing(TaskItem :: getPriority))
				.forEach(System.out :: println);
		
	}
	
	// Sorting tasks type
	public static void sortByType() {
		
		tasksList.stream()
				.sorted(Comparator.comparing(TaskItem :: getTypes))
				.forEach(System.out :: println);
	}
	
	// Method for displaying task description
	public static int numOfTaskDescription = 1;
	
	public static void showDescriptionOfTasks() {
		
		tasksList.forEach((t) -> {
			Optional<String> descriptionOfTasks = Optional.of(t.getDescription());
			System.out.println(descriptionOfTasks.toString()
					.replace("[", "")
					.replace("]", "")
					.replace("Optional", "")
			);
		});
	}
	
	// Method for checking the length of the task name
	public static void taskNameLength() {
		
		tasksList.forEach((t) -> {
			boolean allMatch = tasksList.stream()
					.allMatch(word -> (t.getDescription()).length() > 5);
			System.out.println(allMatch);
		});
	}
	
	// longException(t)
	private static void noDescriptionException(TaskItem t) {
		if (t.getDescription().equals("")) {
			try {
				throw new TasksExceptions(TasksExceptions.NO_DESCRIPTION);
			} catch (TasksExceptions e) {
				t.setDescription("no description");
			}
		}
	}
	
	public static List<TaskItem> getTasks() {
		
		return tasksList;
	}
	
	public static void setTasks(List<TaskItem> tasksList) {
		
		TaskService.tasksList = tasksList;
	}
}
