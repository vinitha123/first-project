package shopping.fashion.DAO;
import java.util.List;


import shopping.fashion.model.User;

public interface UserDAO {
	public List<User> findAllUsers();
	public User findUserById(int UserId);
	public User findUserByName(String UserName);
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(int UserId);

}
