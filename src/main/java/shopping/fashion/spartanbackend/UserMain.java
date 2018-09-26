package shopping.fashion.spartanbackend;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import shopping.fashion.DBConfig.DBConfig;
import shopping.fashion.model.Customer;
import shopping.fashion.model.User;
import shopping.fashion.DAO.UserDAO;

public class UserMain {
	public void userOut() {
		User user1=new User();


AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
UserDAO userDAO = (UserDAO) context.getBean("userDAO");
Scanner sc = new Scanner(System.in);

System.out.println("Please select a category to do the manipulation");
System.out.println("1.Add User /n 2.Delete User /n 3.Update User /n 4.View All Users /n 5.View Users by ID /n 6.View Users by Name");

int choice = sc.nextInt();
switch(choice){

case 1:
	System.out.println("Please Enter the user details to enter");
	System.out.println("User ID:");

	user1.setUserId(sc.nextInt());
	
	System.out.println("UserName:");
	user1.setUserName(sc.next());
	System.out.println("Phone Number");
	
	user1.setMobileNumber(sc.next());
	System.out.println("Email");
	
	user1.setEmail(sc.next());
	System.out.println("Password");
	
	user1.setPassword(sc.next());
	
	boolean result1 = userDAO.addUser(user1);
	if(result1 == true)
	{
		System.out.println("Details has been added successfully");
	}
	break;
case 2:
	
	List<User> userList1 = userDAO.findAllUsers();
	for(User user7 : userList1)
	{
		System.out.print("| Id:"+user7.getUserId()+"|");
		System.out.print("Name:"+user7.getUserName()+"|");
		System.out.print("PhoneNumber:"+user7.getMobileNumber()+"");
		System.out.print("Email:"+user7.getEmail()+"");
		
		System.out.println("");

	}
	System.out.println("Please enter the UserId to be deleted from the above Table");
	int UserId = sc.nextInt();
	boolean result = userDAO.deleteUser(UserId);
	if(result == true)
	{
		System.out.println("The row has been successfuly deleted");
	}
	break;
case 3:
	 List<User> userList2 = userDAO.findAllUsers();
	for(User user3 : userList2)
	{
		System.out.print("| Id:"+user3.getUserId()+"|");
		System.out.print("Name:"+user3.getUserName()+"|");
		System.out.print("PhoneNumber:"+user3.getMobileNumber()+"");
		System.out.print("Email:"+user3.getEmail()+"|");
		System.out.println("");

	}
	System.out.println("Please Enter the userId");
	user1.setUserId(sc.nextInt());
	System.out.println("Please Enter the user details for updation");
	
	System.out.println("UserName:");
	user1.setUserName(sc.next());
	System.out.println("Phone Number");

	user1.setMobileNumber(sc.next());
	System.out.println("Email");
	
	user1.setEmail(sc.next());
	System.out.println("Password");
	
	user1.setPassword(sc.next());
	
	boolean result2 = userDAO.updateUser(user1);
	if(result2 == true)
	{
		System.out.println("Details has been updated successfully");
	}
	break;
	
case 4:
	List<User> userList = userDAO.findAllUsers();
	for(User user : userList)
	{
		System.out.print("| Id:"+user.getUserId()+"|");
		System.out.print("Name:"+user.getUserName()+"|");
		System.out.print("PhoneNumber:"+user.getMobileNumber()+"");
		System.out.print("Email:"+user.getEmail()+"|");
		System.out.println("");

	}
	break;
	
case 5:
	System.out.println("Please enter the UserId to view User Details");
	int UserId3 = sc.nextInt();
	User user4 = userDAO.findUserById(UserId3);
	System.out.print("| Id:"+user4.getUserId()+"|");
	System.out.print("Name:"+user4.getUserName()+"|");
	
	System.out.print("PhoneNumber:"+user4.getMobileNumber()+"");
	System.out.print("Email:"+user4.getEmail()+"|");
	break;
case 6:
	System.out.println("Please enter the UserId to view User Details");
	String UserName = sc.next();
	User user5 = userDAO.findUserByName(UserName);
	System.out.print("| Id:"+user5.getUserId()+"|");
	System.out.print("Name:"+user5.getUserName()+"|");

	System.out.print("PhoneNumber:"+user5.getMobileNumber()+"");
	System.out.print("Email:"+user5.getEmail()+"|");
	break;
	
default: System.out.println("Please enter a valid input");
	
}



context.close();
sc.close();

}

}