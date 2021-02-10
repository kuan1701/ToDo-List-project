package domain.models.users;

public interface iUserService {
	
	public void showInfo();
	
	public void editAccount(String firstName, String lastName, String userName, String password);
	
	public void deleteAccount(User user);
}
