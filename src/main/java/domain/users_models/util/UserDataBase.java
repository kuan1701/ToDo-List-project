package domain.users_models.util;

import domain.users_models.users.User;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UserDataBase {
	
	private static List<User<?>> usersList = new LinkedList<User<?>>();
	
	private UserDataBase() {
	}
	
	public static void addUser(User<?> user) {
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
		usersList.forEach(System.out::println);
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
