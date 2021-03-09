package domain.tasks_models.tasks;

import domain.tasks_models.enums.Types;
import domain.tasks_models.exceptions.DateException;
import domain.tasks_models.enums.Priority;
import domain.tasks_models.enums.Repeats;
import domain.tasks_models.enums.Categories;

import java.io.Serializable;
import java.time.LocalDate;

public class RecurringTask extends TaskItem implements Serializable {
	
	private static final long serialVersionUID = 5L;
	
	private Repeats repeats;
	
	/**
	 * Constructs an RecurringTask with no specified parameters
	 */
	public RecurringTask() {
	
	}
	
	/**
	 * Constructs an RecurringTask of a given description, creationDate,
	 * categories, types, complete, expirationDate, count
	 *
	 * @param description    RecurringTask description
	 * @param categories   RecurringTask categories
	 * @param types       RecurringTask types
	 * @param complete       RecurringTask complete
	 * @param expirationDate RecurringTask expirationDate
	 * @param repeats        RecurringTask repeats
	 */
	
	// Constructor
	public RecurringTask(String description, Categories categories, Types types, Priority priority, boolean complete, LocalDate expirationDate, Repeats repeats) {
		
		super(description, categories, types, priority, complete, expirationDate);
		this.repeats = repeats;
	}
	
	//Methods
	public void createTask(String description, Categories category, Types type, Priority priority, boolean complete, LocalDate expirationDate, Repeats repeats) {
		
		createTask(description, category, type, priority, complete, expirationDate);
		this.repeats = repeats;
	}
	
	public void editTask(String description, Categories category, Types type, Priority priority, boolean complete, LocalDate expirationDate, Repeats repeats) {
		
		editTask(description, category, type, priority, complete, expirationDate);
		this.repeats = repeats;
	}
	
	// Method toString
	@Override
	public String toString() {
		
		
		final StringBuffer sb = new StringBuffer("\n");
		sb.append("Description: ").append(getDescription()).append(".\n");
		sb.append("Repeat: ").append(getRepeat()).append(".\n");
		sb.append("Priority: ").append(getPriority()).append(".\n");
		sb.append("Category: ").append(getCategories()).append(".\n");
		try {
			sb.append("Expiration date: ").append(getExpirationDate()).append(".\n");
		} catch (DateException e) {
			sb.append(setExpirationDate("expired date")).append(".\n");
		}
		sb.append("Days left: ").append(getDaysLeft()).append(" days.\n");
		sb.append("Complete: ").append(isComplete()).append(".\n");
		return sb.toString();
	}
	
	/**
	 * @return RecurringTask repeat
	 */
	public Repeats getRepeat() {
		
		return repeats;
	}
	
	public void setRepeat(Repeats repeats) {
		
		this.repeats = repeats;
	}
}
