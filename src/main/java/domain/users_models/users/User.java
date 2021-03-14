package domain.users_models.users;

import domain.users_models.exceptions.UserException;
import domain.users_models.interfaces.iUserService;
import domain.users_models.util.UserDataBase;

import javax.swing.*;
import java.io.Serializable;
import java.util.Objects;

public class User<T> implements iUserService, Comparable<User>, Serializable {
	
	private static final long serialVersionUID = 7L;
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private T id;
	
	private static int countUser = 0;
	
	/**
	 * Constructs an User of a given firstName, lastName, username, password, id
	 *
	 * @param firstName User firstName
	 * @param lastName  User lastName
	 * @param username  User username
	 * @param password  User password
	 * @param id        User id
	 */
	public User(String firstName, String lastName, String username, String password, T id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.id = id;
	}
	
	/**
	 * Constructs an RecurringTask with no specified parameters
	 */
	public User() {
	}
	
	//Using "Builder Pattern"
	public static class Builder<T> extends User<Object> {
		private final User<T> newUser;
		private final int userNum;
		
		public Builder() {
			
			newUser = new User<>();
			countUser++;
			this.userNum = countUser;
		}
		
		//Methods
		public Builder<T> withFirstName(String firstName) throws UserException {
			if (firstName.length() == 0) {
				throw new UserException(UserException.NO_FIRST_NAME);
			}
			newUser.firstName = firstName;
			return this;
		}
		
		public Builder<T> withLastName(String lastName) throws UserException{
			if (lastName.length() == 0) {
				throw new UserException(UserException.NO_LAST_NAME);
			}
			newUser.lastName = lastName;
			return this;
		}
		
		public Builder<T> withUsername(String username) throws UserException{
			
			if (username.length() == 0) {
				throw new UserException(UserException.NO_USERNAME);
			}
			else if (username.length() < 4) {
				throw  new UserException(UserException.SHORT_USERNAME);
			}
			else if (UserDataBase.getUsers().stream()
					.anyMatch(userDB -> userDB.getUsername().equals(username))){
				throw new UserException(UserException.BUSY_USERNAME);
			}
			newUser.username = username;
			return this;
		}
		
		public Builder<T> withPassword(String password) throws UserException{
			if (password.length() == 0) {
				throw new UserException(UserException.NO_PASSWORD);
			}
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
		
		// exit method
		private void exitProgram() {
			if (newUser.username == null) {
				System.exit(0);
			}
		}
	}
	
	
	//Methods
	@Override
	public void showInfo() {
		
		System.out.println("User " + countUser +
				"Username: " + getUsername() + ".\n" +
				"First name: " + getFirstName() + ".\n" +
				"Last name: " + getLastName() + ".\n" +
				"Password: " + getPassword() + ".\n" +
				"ID: " + getId() + ".\n");
	}
	
	// compareTo method
	@Override
	public int compareTo(User user) {
		
		return this.username.compareTo(user.getUsername());
	}
	
	// edit method
	@Override
	public void editAccount() {
		
		setFirstName();
		setLastName();
		setUsername();
		setPassword();
	}
	
	// toString method
	@Override
	public String toString() {
		
		return  "Username: " + getUsername() + ".\n" +
				"First name: " + getFirstName() + ".\n" +
				"Last name: " + getLastName() + ".\n" +
				"Password: " + getPassword() + ".\n" +
				"ID: " + getId() + ".\n";
	}
	
	// Equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof User)) return false;
		User<?> user = (User<?>) obj;
		return Objects.equals(getUsername(), user.getUsername());
	}
	
	// hashCode method
	@Override
	public int hashCode() {
		
		return Objects.hash(getUsername());
	}
	
	/**
	 * @return User firstName
	 */
	public String getFirstName() {
		
		return firstName;
	}
	
	public void setFirstName() {
		
		this.firstName = JOptionPane.showInputDialog(
				null,
				"Enter your first name");
	}
	
	/**
	 * @return User lastName
	 */
	public String getLastName() {
		
		return lastName;
	}
	
	public void setLastName() {
		
		this.lastName = JOptionPane.showInputDialog(
				null,
				"Enter your last name");
	}
	
	/**
	 * @return User username
	 */
	public String getUsername() {
		
		return username;
	}
	
	public void setUsername() {
		
		this.username = JOptionPane.showInputDialog(
				null,
				"Enter your username");
	}
	
	/**
	 * @return User password
	 */
	public String getPassword() {
		
		return password;
	}
	
	public void setPassword() {
		
		this.password = JOptionPane.showInputDialog(
				null,
				"Enter your password name");
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
}
