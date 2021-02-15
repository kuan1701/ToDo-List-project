package domain.models.tasks;

import java.util.List;

public class StreamAPI extends TaskItem{
	
	private static int id = 1;
	
	public static void printTasksList(List<TaskItem> taskItemList) {
		taskItemList.forEach((t) -> {
			int idOfTasks = id++;
			System.out.println("Task " + idOfTasks + "." + t);
		});
	}
}
