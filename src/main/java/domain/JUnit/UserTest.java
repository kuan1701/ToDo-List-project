package domain.JUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class UserTest {
	private User user;
	private User user1;
	private User user2;
	
	@Before
	public void setUp() throws Exception {
		user = new User("Евгений", 35, Sex.MALE);
		user1 = new User("Марина", 34, Sex.FEMALE);
		user2 = new User("Алина", 7, Sex.FEMALE);
	}
	
	@Test
	public void getAllUsers() {
		List<User> expected = User.getAllUsers();
		
		List<User> actual = new ArrayList<>();
		actual.add(user);
		actual.add(user1);
		actual.add(user2);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getAllUsers_NO_NULL() {
		List<User> expected = User.getAllUsers();
		Assert.assertNotNull(expected);
	}
	
	@Test
	public void getAllUsers_MALE() {
		List<User> expected = User.getAllUsers(Sex.MALE);
		
		List<User> actual = new ArrayList<>();
		actual.add(user);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getAllUsers_MALE_NO_NULL() {
		//добавим проверку на null
		List<User> expected = User.getAllUsers(Sex.MALE);
		Assert.assertNotNull(expected);
	}
	
	@Test
	public void getAllUsers_FEMALE() {
		List<User> expected = User.getAllUsers(Sex.FEMALE);
		
		List<User> actual = new ArrayList<>();
		actual.add(user1);
		actual.add(user2);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getAllUsers_FEMALE_NO_NULL() {
		//добавим проверку на null
		List<User> expected = User.getAllUsers(Sex.FEMALE);
		Assert.assertNotNull(expected);
	}
	
	@Test
	public void getHowManyUsers() {
		int expected = User.getHowManyUsers();
		
		int actual = 3;
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getHowManyUsers_MALE() {
		int expected = User.getHowManyUsers(Sex.MALE);
		
		int actual = 1;
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getHowManyUsers_FEMALE() {
		int expected = User.getHowManyUsers(Sex.FEMALE);
		
		int actual = 2;
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getAllAgeUsers() {
		int expected = User.getAllAgeUsers();
		
		int actual = 35 + 34 + 7;
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getAllAgeUsers_MALE() {
		int expected = User.getAllAgeUsers(Sex.MALE);
		
		int actual = 35;
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getAllAgeUsers_FEMALE() {
		int expected = User.getAllAgeUsers(Sex.FEMALE);
		
		int actual = 34 + 7;
		
		Assert.assertEquals(expected, actual);
	}
}