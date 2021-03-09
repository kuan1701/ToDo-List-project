package domain.tasks_models.enums;

public enum Priority {
	
	DEFAULT("Default"),
	URGENTLY("Urgently"),
	IMPORTANT("Important");
	
	public String priority;
	
	/**
	 * Constructs an Categories of a given priority
	 * @param priority Categories priority
	 */
	Priority(String priority) {
		
		this.priority = priority;
	}
	
	/**
	 * @return priority of the task
	 */
	@Override
	public String toString() {
		
		return priority;
	}
	
	/**
	 * @return Task priority
	 */
	public String getPriority() {
		
		return priority;
	}
}
