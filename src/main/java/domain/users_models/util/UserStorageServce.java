package domain.users_models.util;

import domain.tasks_models.tasks.TaskItem;
import domain.tasks_models.util.SerializationTaskService;
import domain.users_models.interfaces.iUsersStorageService;
import domain.users_models.users.User;

import java.util.List;

public class UserStorageServce implements iUsersStorageService {
	
	private static final String STORAGE_FILENAME = "D:\\ToDo-List-project\\src\\main\\java\\resources\\users.txt";
	
	@Override
	public void writeUsers(List<User<?>> usersList) {
		
		UserSerializationService.serialize(usersList, STORAGE_FILENAME);
		System.out.println("Users are saved.\n");
	}
	
	@Override
	public List<User<?>> readUsers() {
		
		List<User<?>> deserialized = (List<User<?>>) UserSerializationService.deserialize(STORAGE_FILENAME);
		
		System.out.println(deserialized.toString()
				.replace("[", "")
				.replace("]", "")
				.replace(",", ""));
		System.out.println("Users are loaded.\n");
		return deserialized;
	}
}
