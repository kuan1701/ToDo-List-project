package domain.enums;

import javax.print.DocFlavor;

public enum TaskCategories {
	DEFAULT("Default"),
	PERSONAL("Personal"),
	SHOPPING("Shopping"),
	WISHLIST("Wishlist"),
	WORK("Work"),
	FINISHED("Finished");
	
	public String category;
	
	TaskCategories(String category) {
		
		this.category = category;
	}
	
	@Override
	public String toString()
	{
		return category;
	}
	
	public String getCategory() {
		
		return category;
	}
	
	public void setCategory(String category) {
		
		this.category = category;
	}
}
