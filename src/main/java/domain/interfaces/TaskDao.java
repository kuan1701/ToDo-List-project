package domain.interfaces;

import domain.models.TaskItem;

import java.util.List;

public interface TaskDao {
	/**
	 * @return A list of TaskItems
	 */
	public List<TaskItem> readTaskItems();
	
	/**
	 * @param taskItem
	 * @return whether the taskItem was persisted.
	 */
	public TaskItem createTaskItem(TaskItem taskItem);
	
	/**
	 * @param id
	 * @return the TaskItem
	 */
	public TaskItem readTaskItem(String id);
	
	/**
	 * @param id
	 * @return the TaskItem
	 */
	public TaskItem updateTaskItem(String id, boolean isComplete);
	
	/**
	 * @param id
	 * @return whether the delete was successful.
	 */
	public boolean deleteTaskItem(String id);
	
}
