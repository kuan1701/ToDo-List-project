package domain.users_models.util;

import domain.users_models.exceptions.UserNameException;
import domain.users_models.users.User;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UserDataBase {
	
	private static int numOfUsers = 1;
	
	private static List<User<?>> usersList = new LinkedList<User<?>>();
	
	private UserDataBase() {
	}
	
	public static <T> void createUser(T id) throws UserNameException {

			User<T> user = new User.Builder<T>()
						.withFirstName()
						.withLastName()
						.withUsername()
						.withPassword()
						.withID(id)
						.build();
		
		boolean userExists = usersList.stream()
				.anyMatch(userDB -> userDB.getUsername().equals(user.getUsername()));
		if (!userExists) {
			usersList.add(user);
		}
	}
	
	public static void deleteUser(String username) {
		usersList.stream()
				.filter(user -> user.getUsername().equals(username))
				.findFirst()
				.ifPresent(usersList::remove);
	}
	
	public static void printListOfUsers() {
		
		for (User<?> user : usersList) {
			int currentUserNum = numOfUsers++;
			System.out.println("User " + currentUserNum + ".\n" + user + "\n");
		}
	}
	
	public static void sort() {
		
		Collections.sort(usersList);
	}
	
	public static List<User<?>> getUsers() {
		
		return usersList;
	}
	
	public static void setUsers(List<User<?>> usersList) {
		
		UserDataBase.usersList = usersList;
	}
}
