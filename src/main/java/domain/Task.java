package domain;

abstract public class Task {
	
	private String name;
	private int date;
	private String type;
	private String category;
	private String priority;
	private String description;
	private boolean state;
	private int deadline;
	
	//Constructors
	
	public Task(String name, int date, String type, String category, String priority, String description, boolean state, int deadline) {
		this.name = name;
		this.date = date;
		this.type = type;
		this.category = category;
		this.priority = priority;
		this.description = description;
		this.state = state;
		this.deadline = deadline;
	}
	
	
	//Methods
	
	
	
	//Getters and setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getDate() {
		return date;
	}
	
	public void setDate(int date) {
		this.date = date;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getPriority() {
		return priority;
	}
	
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
	
	public int getDeadline() {
		return deadline;
	}
	
	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
