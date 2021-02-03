package domain.users;

public class User{
	
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	
	//Using "Builder Pattern"
	public static class Builder {
		private User newUser;
		
		public Builder withFirstName(String firstName) {
			newUser.firstName = firstName;
			return this;
		}
		
		public Builder withLastName(String lastName) {
			newUser.lastName = lastName;
			return this;
		}
		
		public Builder withUserName(String userName) {
			newUser.userName = userName;
			return this;
		}
		
		public Builder withPassword(String password) {
			newUser.password = password;
			return this;
		}
		
		public User build() {
			System.out.println();
			return newUser;
		}
	}
}
