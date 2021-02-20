package domain.util;

import domain.Exception.MissingTaskDescriptionException;
import domain.enums.Priority;
import domain.enums.TaskCategory;
import domain.enums.TaskType;
import domain.models.tasks.TaskItem;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaskService {
	
	// Print task list
	public static void printTask(TaskItem taskItem) throws MissingTaskDescriptionException {
		
		if (taskItem.getDescription().equals("")){
			System.out.println(taskItem);
		} else {
			throw new MissingTaskDescriptionException("Write a description of task");
		}
	}
	
	//Stream API
	// Search by priority
	public static List<TaskItem> filterByPriority(List<TaskItem> taskItemList, Priority priority) {
		
		return taskItemList.stream()
				.filter(taskItem -> taskItem.getPriority().equals(priority))
				.collect(Collectors.toList());
	}
	
	// Search by category
	public static List<TaskItem> filterByCategory(List<TaskItem> taskItemList, TaskCategory taskCategory) {
		
		return taskItemList.stream()
				.filter(taskItem -> taskItem.getTaskCategory().equals(taskCategory))
				.collect(Collectors.toList());
	}
	
	// Search by type
	public static List<TaskItem> filterByType(List<TaskItem> taskItemList, TaskType taskType) {
		
		return taskItemList.stream()
				.filter(taskItem -> taskItem.getTaskType().equals(taskType))
				.collect(Collectors.toList());
	}
	
	// Remove duplicate tasks
	public static List<TaskItem> removeDuplicateTasks(List<TaskItem> taskItemList) {
		
		return taskItemList.stream()
				.distinct()
				.collect(Collectors.toList());
	}
	
	// Sorting tasks by category
	public static List<TaskItem> sortByCategory(List<TaskItem> taskItemList) {
		
		return taskItemList.stream()
				.sorted(Comparator.comparing(TaskItem :: getTaskCategory))
				.collect(Collectors.toList());
	}
	
	// Sorting tasks priority
	public static List<TaskItem> sortByPriority(List<TaskItem> taskItemList) {
		
		return taskItemList.stream()
				.sorted(Comparator.comparing(TaskItem :: getPriority))
				.collect(Collectors.toList());
	}
	
	// Sorting tasks type
	public static List<TaskItem> sortByType(List<TaskItem> taskItemList) {
		
		return taskItemList.stream()
				.sorted(Comparator.comparing(TaskItem :: getTaskType))
				.collect(Collectors.toList());
	}
	
	// Print task list
	private static int id = 1;
	public static void printTasksList(List<TaskItem> taskItemList) {
		
		taskItemList.removeIf(TaskItem :: isComplete);
		
		taskItemList.forEach((t) -> {
			
			int idOfTasks = id++;
			
			longException(t);
			
			if (t.isComplete()) {
				t.setTaskCategory(TaskCategory.FINISHED);
			}
			System.out.println("Task " + idOfTasks + "." + t);
		});
	}
	
	// Print list of all tasks
	private static int idAllTasks = 1;
	public static void printListOfAllTasks(List<TaskItem> taskItemList) {
		
		taskItemList.forEach((t) -> {
			
			int idOfTasks = idAllTasks++;
			
			longException(t);
			
			if (t.isComplete()) {
				t.setTaskCategory(TaskCategory.FINISHED);
			}
			System.out.println("Task " + idOfTasks + "." + t);
		});
	}
	
	// Method for displaying task description
	public static int numOfTaskDescription = 1;
	public static void showDescriptionOfTasks(List<TaskItem> taskItemList) {
		
		taskItemList.forEach((t) -> {
			
			int count = numOfTaskDescription++;
			Optional<String> descriptionOfTasks = Optional.of(t.getDescription());
			System.out.println(descriptionOfTasks.map(s -> ("Task " + count + ": " + s + ".")).toString()
					.replace("[", " ")
					.replace("]", " ")
					.replace("Optional", "")
			);
		});
	}
	
	// Method for checking the length of the task name
	public static int numOfTaskLength = 1;
	public static void taskNameLength(List<TaskItem> taskItemList) {
		
		taskItemList.forEach((t) -> {
			
			int count = numOfTaskLength++;
			boolean allMatch = taskItemList.stream()
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
}
