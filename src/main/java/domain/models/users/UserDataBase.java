package domain.models.users;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UserDataBase {
	
	private static int numOfUsers = 1;
	
	private static List<User<?>> usersList = new LinkedList<User<?>>();
	
	private UserDataBase() {
	}
	
	public static void addUser(User<?> user) {
		boolean userExists = usersList.stream()
				.anyMatch(userDB -> userDB.getUserName().equals(user.getUserName()));
		if (!userExists) {
			usersList.add(user);
		}
	}
	
	public static void deleteUser(String userName) {
		usersList.stream()
				.filter(user -> user.getUserName().equals(userName))
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
