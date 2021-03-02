package domain.tasks_models.interfaces;

import domain.tasks_models.tasks.TaskItem;

import java.util.List;

public interface iTasksStorageService {

	void writeTasks(List<TaskItem> tasksList);
	
	List<TaskItem> readTasks();
}
