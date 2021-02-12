package domain.interfaces;

import domain.models.users.User;

public interface iUserService {
	
	public void showInfo();
	
	public void editAccount(String firstName, String lastName, String userName, String password);
	
	public void deleteAccount(User user);
}
