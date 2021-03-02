package domain.tasks_models.util;

import domain.tasks_models.exceptions.MissingTaskDescriptionException;
import domain.tasks_models.enums.Priority;
import domain.tasks_models.enums.TaskCategory;
import domain.tasks_models.enums.TaskType;
import domain.tasks_models.tasks.TaskItem;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class TaskService {
	
	private static List<TaskItem> tasksList = new LinkedList<TaskItem>();
	
	public TaskService() {
	}
	
	// add task
	public static void addTask(TaskItem taskItem) {
		boolean taskExists = tasksList.stream()
				.anyMatch(task -> task.getDescription().equals(taskItem.getDescription()) &&
						task.getTaskCategory().equals(taskItem.getTaskCategory()) &&
						task.getTaskType().equals(taskItem.getTaskType()));
		
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
	public static void printTask(TaskItem taskItem) throws MissingTaskDescriptionException {
		
		if (taskItem.getDescription().equals("")) {
			System.out.println(taskItem);
		} else {
			throw new MissingTaskDescriptionException("Write a description of task");
		}
	}
	
	// Print task list
	private static int id = 1;
	
	public static void printTasksList() {
		
		tasksList.removeIf(TaskItem :: isComplete);
		
		tasksList.forEach((t) -> {
			
			int idOfTasks = id++;
			longException(t);
			finishedTask(t);
			System.out.println("Task " + idOfTasks + "." + t);
		});
	}
	
	// Print list of all tasks
	private static int idAllTasks = 1;
	
	public static void printListOfAllTasks() {
		
		tasksList.forEach((t) -> {
			
			int idOfTasks = idAllTasks++;
			longException(t);
			finishedTask(t);
			System.out.println("Task " + idOfTasks + "." + t);
		});
	}
	
	//finished task
	private static void finishedTask(TaskItem t) {
		if (t.isComplete()) {
			t.setTaskCategory(TaskCategory.FINISHED);
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
	public static void filterByCategory(TaskCategory taskCategory) {
		
		tasksList.stream()
				.filter(taskItem -> taskItem.getTaskCategory().equals(taskCategory))
				.forEach(System.out :: println);
	}
	
	// Search by type
	public static void filterByType(TaskType taskType) {
		
		tasksList.stream()
				.filter(taskItem -> taskItem.getTaskType().equals(taskType))
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
				.sorted(Comparator.comparing(TaskItem :: getTaskCategory))
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
				.sorted(Comparator.comparing(TaskItem :: getTaskType))
				.forEach(System.out :: println);
	}
	
	// Method for displaying task description
	public static int numOfTaskDescription = 1;
	
	public static void showDescriptionOfTasks() {
		
		tasksList.forEach((t) -> {
			
			int count = numOfTaskDescription++;
			Optional<String> descriptionOfTasks = Optional.of(t.getDescription());
			System.out.println(descriptionOfTasks.map(s -> ("Task " + count + ": " + s + ".")).toString()
					.replace("[", "")
					.replace("]", "")
					.replace("Optional", "")
			);
		});
	}
	
	// Method for checking the length of the task name
	public static int numOfTaskLength = 1;
	
	public static void taskNameLength() {
		
		tasksList.forEach((t) -> {
			
			int count = numOfTaskLength++;
			boolean allMatch = tasksList.stream()
					.allMatch(word -> (t.getDescription()).length() > 5);
			System.out.println(" Task " + count + ": " + allMatch + ".");
		});
	}
	
	// longException(t)
	private static void longException(TaskItem t) {
		if (t.getDescription().equals("")) {
			try {
				throw new MissingTaskDescriptionException("Write a description of task");
			} catch (MissingTaskDescriptionException e) {
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
