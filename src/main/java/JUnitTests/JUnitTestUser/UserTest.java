package JUnitTests.JUnitTestUser;

import domain.users_models.exceptions.UserException;
import domain.users_models.users.User;
import domain.users_models.util.UserDataBase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(Theories.class)
public class UserTest {
	
	private final User<Object> user1 = new User.Builder<>()
			.withFirstName("Kuan")
			.withLastName("Chin")
			.withUsername("Kuan1701")
			.withPassword("17011993")
			.withID("id17011993")
			.build();
	
	private final User<Object> user2 = new User.Builder<>()
			.withFirstName("Robert")
			.withLastName("Chin")
			.withUsername("Robert1408")
			.withPassword("14082018")
			.withID("id14082018")
			.build();
	List<?> expected = UserDataBase.getUsers();
	
	public UserTest() throws UserException {
		
		UserDataBase.addUser(user1);
		UserDataBase.addUser(user2);
	}
	
	@DataPoints
	public static String[] input = new String[] {"Kuan", "Kuan", "Tiger"};
	List<User> expectedUserList = (List<User>) expected;
	
	
	@Theory
	public void userTests() {
		
		String inputName = input[0];
		String expected = input[1];
		String unexpected = input[2];
		String actual = user1.getFirstName();
		System.out.println("Method getFirstName return the correct variable: " + inputName);
		
		Assert.assertEquals(expected, actual);
		Assert.assertNotEquals(unexpected, actual);
		
		List<?> actualTaskList = UserDataBase.getUsers();
		Assert.assertEquals(expectedUserList, actualTaskList);
		System.out.println("Method getUsers return the correct variable.");
	}
	
	@Test
	public void printListOfUsers() {
		
		List<User<?>> actual = new ArrayList<>();
		actual.add(user1);
		actual.add(user2);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void printListOfUsers_NO_NULL() {

		Assert.assertNotNull(expected);
	}
	
	@Test
	public void getFirstName() throws UserException {
		
		String expected = user1.getFirstName();
		String actual = "Kuan";
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getUsersNum() {

		int expectedSize = expected.size();
		
		List<User<? extends Object>> actualUsersList = new ArrayList<>();
		actualUsersList.add(user1);
		actualUsersList.add(user2);
		int actual = actualUsersList.size();
		
		Assert.assertEquals(expectedSize, actual);
		
	}
}