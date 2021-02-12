package domain.models.users;

import domain.interfaces.iUserService;

import java.util.LinkedList;

public class User<T> implements iUserService {
	
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private T id;
	
	//Assigning a serial number to the user
	private static int numOfUsers = 1;
	
	private static final LinkedList<User> usersList = new LinkedList<User>();
	
	/**
	 * Constructs an User of a given firstName, lastName, userName, password, id
	 * @param firstName User firstName
	 * @param lastName User lastName
	 * @param userName User userName
	 * @param password User password
	 * @param id User id
	 */
	public User(String firstName, String lastName, String userName, String password, T id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.id = id;
		usersList.add(this);
	}
	
	/**
	 * Constructs an RecurringTask with no specified parameters
	 */
	public User() {
		usersList.add(this);
	}
	
	//Using "Builder Pattern"
	public static class Builder<T> {
		private final User<T> newUser;
		
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
	
	//Methods
	@Override
	public void showInfo() {
		
		System.out.println( "Username: " + userName + ".\n" +
							"First name: " + firstName + ".\n" +
							"Last name: " + lastName + ".\n" +
							"Password: " + password + ".\n" +
							"ID: " + id + '.');
	}
	
	@Override
	public void editAccount(String firstName, String lastName, String userName, String password) {
		
		setFirstName(firstName);
		setLastName(lastName);
		setUserName(userName);
		setPassword(password);
	}
	
	@Override
	public void deleteAccount(User user) {
		usersList.remove(user);
	}
	
	@Override
	public String toString() {
		
		return  "Username: " + userName + ".\n" +
				"First name: " + firstName + ".\n" +
				"Last name: " + lastName + ".\n" +
				"Password: " + password + ".\n" +
				"ID: " + id + '.';
	}
	
	/**
	 * @return User firstName
	 */
	public String getFirstName() {
		
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
	}
	
	/**
	 * @return User lastName
	 */
	public String getLastName() {
		
		return lastName;
	}
	
	public void setLastName(String lastName) {
		
		this.lastName = lastName;
	}
	
	/**
	 * @return User userName
	 */
	public String getUserName() {
		
		return userName;
	}
	
	public void setUserName(String userName) {
		
		this.userName = userName;
	}
	
	/**
	 * @return User password
	 */
	public String getPassword() {
		
		return password;
	}
	
	public void setPassword(String password) {
		
		this.password = password;
	}
	
	/**
	 * @return User ID
	 */
	public T getId() {
		
		return id;
	}
	
	public void setId(T id) {
		
		this.id = id;
	}
	
	//Display a list of users
	public static void getListOfUsers() {
		
		for (User user : usersList) {
			int currentUserNum = numOfUsers++;
			System.out.println("User " + currentUserNum + ".\n" + user + "\n");
		}
	}
}
