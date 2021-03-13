package domain.tasks_models.enums;

public enum Categories {
	
	DEFAULT("Default"),
	PERSONAL("Personal"),
	HOUSEWORK("Housework"),
	SHOPPING("Shopping"),
	WORK("Work"),
	WISHLIST("Wishlist"),
	FINISHED("Finished");
	
	public String category;
	
	/**
	 * Constructs an Categories of a given category
	 * @param category Categories category
	 */
	Categories(String category) {
		
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
