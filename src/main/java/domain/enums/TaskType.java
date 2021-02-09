package domain.enums;

public enum TaskType {
	
	URGENTLY("Urgently"),
	IMPORTANT("Important"),
	DEFAULT("Default");
	
	public String type;
	
	/**
	 * Constructs an TaskCategory of a given type
	 * @param type TaskCategory type
	 */
	TaskType(String type) {
		
		this.type = type;
	}
	
	/**
	 * @return type of the task
	 */
	@Override
	public String toString() {
		
		return type;
	}
	
	/**
	 * @return Task type
	 */
	public String getType() {
		
		return type;
	}
}
