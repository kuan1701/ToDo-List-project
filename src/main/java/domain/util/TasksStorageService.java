package domain.util;

import domain.interfaces.iTasksStorageService;
import domain.models.tasks.TaskItem;

import java.util.List;

public class TasksStorageService implements iTasksStorageService {
	
	private static final String STORAGE_FILENAME = "tasks.txt";
	
	@Override
	public void writeTasks(List<TaskItem> tasksList) {
		
		SerializationTaskService.serialize(tasksList, STORAGE_FILENAME);
		System.out.println("Tasks are saved.");
	}
	
	@Override
	public List<TaskItem> readTasks() {
		
		List<TaskItem> deserialized = (List<TaskItem>) SerializationTaskService.deserialize(STORAGE_FILENAME);
		
		System.out.println(deserialized.toString()
				.replace("[", "")
				.replace("]", "")
				.replace(",", ""));
		System.out.println("Tasks are loaded.");
		return deserialized;
	}
}
