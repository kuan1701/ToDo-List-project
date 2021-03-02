package Application;

import domain.users_models.exceptions.UserNameException;
import domain.users_models.interfaces.iUsersStorageService;
import domain.users_models.util.UserDataBase;
import domain.users_models.util.UserStorageServce;


public class Users {
	
	private static final String FILENAME = "D:\\ToDo-List-project\\src\\main\\java\\resources\\users.txt";
	private static final iUsersStorageService iUsersStorageService = new UserStorageServce();
	
	public static void main(String[] args) throws UserNameException {
		
		// Displaying and creating users
		System.out.println("-------------------");
		System.out.println("       Users       ");
		System.out.println("-------------------");
		
		UserDataBase.createUser(17011993);
		UserDataBase.createUser("id17011993");
		
		UserDataBase.deleteUser("kuan");

		// Save tasks
		iUsersStorageService.writeUsers(UserDataBase.getUsers());
		
		// Read tasks
		iUsersStorageService.readUsers();

		
	}
}
