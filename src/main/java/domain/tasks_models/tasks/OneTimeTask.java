package domain.tasks_models.tasks;

import domain.tasks_models.enums.Categories;
import domain.tasks_models.enums.Priority;
import domain.tasks_models.enums.Types;

import java.io.Serializable;
import java.time.LocalDate;

public class OneTimeTask extends TaskItem implements Serializable {
	
	private static final long serialVersionUID = 5L;
	
	/**
	 * Constructs an OneTimeTask with no specified parameters
	 */
	public OneTimeTask() {
	
	}
	
	/**
	 * Constructs an OneTimeTask of a given description, creationDate,
	 * categories, types, complete, expirationDate
	 *
	 * @param description    OneTimeTask description
	 * @param categories   OneTimeTask categories
	 * @param types       OneTimeTask types
	 * @param complete       OneTimeTask complete
	 * @param expirationDate OneTimeTask expirationDate
	 */
	public OneTimeTask(String description, Categories categories, Types types, Priority priority, boolean complete, LocalDate expirationDate) {
		
		super(description, categories, types, priority, complete, expirationDate);
	}
}
