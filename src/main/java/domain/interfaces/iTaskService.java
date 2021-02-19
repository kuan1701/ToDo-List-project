package domain.interfaces;

import domain.enums.Priority;
import domain.enums.TaskCategory;
import domain.enums.TaskType;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public interface iTaskService {
	
	/**
	 * @param description
	 * @param category
	 * @param type
	 * @param priority
	 * @param complete
	 * @param expirationDate
	 */
	public void createTask(String description, TaskCategory category, TaskType type, Priority priority, boolean complete, LocalDate expirationDate);
	
	/**
	 * @param description
	 * @param category
	 * @param type
	 * @param priority
	 * @param complete
	 * @param expirationDate
	 */
	public void editTask(String description, TaskCategory category, TaskType type, Priority priority, boolean complete, LocalDate expirationDate);
}
