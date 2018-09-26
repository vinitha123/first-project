package shopping.fashion.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import shopping.fashion.DBConfig.DBConfig;
import shopping.fashion.model.User;
import shopping.fashion.DAO.UserDAO;

import junit.framework.TestCase;

public class UserDAOImplTest extends TestCase {
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	UserDAO userDAO = (UserDAO) context.getBean("userDAO");
	
	User user1=new User();
	public void testAddUser() {
		User user=new User();
	
	
		user.setEmail("hhh@email.com");
		user.setPassword("pass");
		
		boolean result1 = userDAO.addUser(user1);
		assertEquals(true,userDAO.addUser(user));
	}
	

	public void testFindAllUsers() {
	List<User>userList=userDAO.findAllUsers();
	assertNotNull(userList);
		
	}
	public void testFindUserById() {
		User user1=userDAO.findUserById(102);
		assertNotNull(user1);
		user1.getUserName();
		user1.getEmail();
		user1.getPassword();
		user1.getMobileNumber();
	int expectedId=22;
	int actualId=user1.getUserId();
		assertTrue(expectedId==actualId);
	}
			
	public void testFindUserByName() {
		
		User user2 = userDAO.findUserByName("imran");
		assertNotNull(user2);
		user2.getUserName();
		user2.getEmail();
		user2.getPassword();
		user2.getMobileNumber();
		String expectedName="imran";
		String actualName=user2.getUserName();
		assertTrue(expectedName.equals(actualName));
		
		
	}

	public void testUpdateUser() {
		User user3=userDAO.findUserById(102);
		user3.setMobileNumber("99020393");
		user3.setPassword("note");
		userDAO.updateUser(user3);
		userDAO.updateUser(user3);
		assertTrue(user3.getMobileNumber()=="99020393");
		assertTrue(user3.getPassword()=="note");
		
	}

	public void testDeleteUser() {
	User user4=userDAO.findUserById(17);
	user4.getUserName();
	user4.getEmail();
	user4.getPassword();
	user4.getMobileNumber();
	assertEquals(true,userDAO.deleteUser(user4.getUserId()));

	}
}