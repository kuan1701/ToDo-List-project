package domain.users;

public class BuildUser<T extends User> {
	private T id;
	
	public BuildUser(T id) {
		this.id = id;
	}
	
	public BuildUser(User.Builder withUserName, String id) {
	}
	
	public void show(){
		
		System.out.println(id);
	}
}
