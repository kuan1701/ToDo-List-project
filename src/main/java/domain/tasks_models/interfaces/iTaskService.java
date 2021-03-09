package domain.tasks_models.interfaces;

import domain.tasks_models.enums.Categories;
import domain.tasks_models.enums.Priority;
import domain.tasks_models.enums.Types;

import java.time.LocalDate;

public interface iTaskService {
	
	/**
	 * @param description
	 * @param category
	 * @param type
	 * @param priority
	 * @param complete
	 * @param expirationDate
	 */
	public void createTask(String description, Categories category, Types type, Priority priority, boolean complete, LocalDate expirationDate);
	
	/**
	 * @param description
	 * @param category
	 * @param type
	 * @param priority
	 * @param complete
	 * @param expirationDate
	 */
	public void editTask(String description, Categories category, Types type, Priority priority, boolean complete, LocalDate expirationDate);
}
