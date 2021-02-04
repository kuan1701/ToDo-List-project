package domain.models;

public class User<T>{
	
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private T id;
	
	//Constructors
	public User(String firstName, String lastName, String userName, String password, T id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.id = id;
	}
	
	public User() {
	}
	
	//Getters and setters
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public T getId() {
		return id;
	}
	
	public void setId(T id) {
		this.id = id;
	}
	
	//Using "Builder Pattern"
	public static class Builder<T> {
		private User<T> newUser;
		
		public Builder() {
			newUser = new User<>();
		}
		
		//Methods
		public Builder<T> withFirstName(String firstName) {
			newUser.firstName = firstName;
			return this;
		}
		
		public Builder<T> withLastName(String lastName) {
			newUser.lastName = lastName;
			return this;
		}
		
		public Builder<T> withUserName(String userName) {
			newUser.userName = userName;
			return this;
		}
		
		public Builder<T> withPassword(String password) {
			newUser.password = password;
			return this;
		}
		
		public Builder<T> withID(T id) {
			newUser.id = id;
			return this;
		}
		
		public User<T> build() {
			return newUser;
		}
	}
}
