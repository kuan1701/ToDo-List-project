package domain.interfaces;

import domain.models.tasks.TaskItem;

import java.util.List;

public interface iTasksStorageService {

	void writeTasks(List<TaskItem> tasksList);
	
	List<TaskItem> readTasks();
}
