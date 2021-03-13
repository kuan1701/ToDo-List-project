package domain.tasks_models.util;

import domain.tasks_models.interfaces.iTasksStorageService;
import domain.tasks_models.tasks.TaskItem;

import java.util.List;

public class TasksStorageService implements iTasksStorageService {
	
	private static int numOfTasks = 1;
	private static final String STORAGE_FILENAME = "D:\\ToDo-List-project\\src\\main\\java\\resources\\tasks.txt";
	
	@Override
	public void writeTasks(List<TaskItem> tasksList) {
		
		SerializationTaskService.serialize(tasksList, STORAGE_FILENAME);
		System.out.println("Tasks are saved.");
	}
	
	@Override
	public List<TaskItem> readTasks() {
		
		List<TaskItem> deserialized = (List<TaskItem>) SerializationTaskService.deserialize(STORAGE_FILENAME);
		
		deserialized.forEach((t) -> {
			int currentTaskNum = numOfTasks++;
			System.out.println("Task " + currentTaskNum + "." + t );
		});
		
		return deserialized;
	}
}
