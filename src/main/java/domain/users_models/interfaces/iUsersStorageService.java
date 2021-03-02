package domain.users_models.interfaces;

import domain.tasks_models.tasks.TaskItem;
import domain.users_models.users.User;

import java.util.List;

public interface iUsersStorageService {

	void writeUsers(List<User<?>> usersList);
	
	List<User<?>> readUsers();
}
