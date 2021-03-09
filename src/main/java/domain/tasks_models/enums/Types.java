package domain.tasks_models.enums;

public enum Types {
	
	DISPOSABLE("Disposable"),
	REUSABLE("Reusable");
	
	private String type;
	
	Types(String type) {
		
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
	
	public void setType(String type) {
		this.type = type;
	}
}
