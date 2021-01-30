package domain;

public class ReccuringTask extends Task{

	private int numberOfRepetitions;
	
	//Constructors
	public ReccuringTask(String name, int date, String type, String category, String priority, String description, boolean state, int deadline, int numberOfRepetitions) {
		super(name, date, type, category, priority, description, state, deadline);
		this.numberOfRepetitions = numberOfRepetitions;
	}
	
	
}
