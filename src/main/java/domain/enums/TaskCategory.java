package domain.enums;

public enum TaskCategory {
	PERSONAL("Personal"),
	HOUSEWORK("Housework"),
	SHOPPING("Shopping"),
	WORK("Work"),
	WISHLIST("Wishlist"),
	DEFAULT("Default"),
	FINISHED("Finished");
	
	public String category;
	
	/**
	 * Constructs an TaskCategory of a given category
	 * @param category TaskCategory category
	 */
	TaskCategory(String category) {
		
		this.category = category;
	}
	
	/**
	 * @return category of the task
	 */
	@Override
	public String toString()
	{
		return category;
	}
	
	/**
	 * @return Task category
	 */
	public String getCategory() {
		
		return category;
	}

}
