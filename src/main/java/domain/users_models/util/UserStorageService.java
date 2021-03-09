package domain.users_models.util;

import domain.users_models.interfaces.iUsersStorageService;
import domain.users_models.users.User;

import java.util.List;

public class UserStorageService implements iUsersStorageService {
	
	private static int numOfUsers = 1;
	private static final String STORAGE_FILENAME = "D:\\ToDo-List-project\\src\\main\\java\\resources\\users.txt";
	
	@Override
	public void writeUsers(List<User<?>> usersList) {
		
		UserSerializationService.serialize(usersList, STORAGE_FILENAME);
		System.out.println("Users are saved.\n");
	}
	
	@Override
	public List<User<?>> readUsers() {
		
		List<User<?>> deserialized = (List<User<?>>) UserSerializationService.deserialize(STORAGE_FILENAME);
		
		for (User<?> deserializedUsersList: deserialized) {
			
			int currentUserNum = numOfUsers++;
			System.out.println("User " + currentUserNum + ".\n" + deserializedUsersList + "\n");
		}
		return deserialized;
	}
}
