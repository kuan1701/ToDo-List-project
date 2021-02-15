package domain.enums;

public enum Priority {
	
	URGENTLY("Urgently"),
	IMPORTANT("Important"),
	DEFAULT("Default");
	
	public String priority;
	
	/**
	 * Constructs an TaskCategory of a given priority
	 * @param priority TaskCategory priority
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
