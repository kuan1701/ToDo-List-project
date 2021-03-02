package domain.tasks_models.enums;

public enum Repeats {

	ONCE_A_DAY("Once a day"),
	ONCE_A_WEEK("Once a week"),
	ONCE_A_MONTH("Once a month"),
	ONCE_OF_YEAR("Once of year"),
	OTHER("Other");
	
	public String repeats;
	
	/**
	 * Constructs an Repeats of a given type of repeats
	 * @param repeats TaskRepeats repeats
	 */
	Repeats(String repeats) {
		this.repeats = repeats;
	}
	
	public String getRepeats() {
		return repeats;
	}
	
	/**
	 * @return repeats of the task
	 */
	@Override
	public String toString() {
		
		return repeats;
	}
	
	public void setRepeats(String repeats) {
		
		this.repeats = repeats;
	}
}
