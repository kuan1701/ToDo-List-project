package domain.enums;

public enum TaskTypes {
	
	DEFAULT("Default"),
	URGENTLY("Urgently"),
	IMPORTANT("Important");
	
	public String type;
	
	TaskTypes(String type) {
		
		this.type = type;
	}
	
	@Override
	public String toString() {
		
		return type;
	}
	
	public String getType() {
		
		return type;
	}
	
	public void setType(String type) {
		
		this.type = type;
	}
}
