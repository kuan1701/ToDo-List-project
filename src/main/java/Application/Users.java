package Application;

import domain.users_models.exceptions.UserException;
import domain.users_models.interfaces.iUsersStorageService;
import domain.users_models.users.User;
import domain.users_models.util.UserDataBase;
import domain.users_models.util.UserStorageService;


public class Users {
	
	private static final String FILENAME = "D:\\ToDo-List-project\\src\\main\\java\\resources\\users.txt";
	private static final iUsersStorageService iUsersStorageService = new UserStorageService();
	
	public static void main(String[] args) throws UserException {
		
		// Displaying and creating users
		System.out.println("-------------------");
		System.out.println("       Users       ");
		System.out.println("-------------------");
		
		User<Object> user = new User.Builder<>()
				.withFirstName("efewf")
				.withLastName("dawdawd")
				.withUsername("awdawd")
				.withPassword("adada")
				.withID("ewfwef")
				.build();
		
		UserDataBase.addUser(user);

		// Save users
		iUsersStorageService.writeUsers(UserDataBase.getUsers());
		
		// Read users
		iUsersStorageService.readUsers();

		
	}
}
