package shopping.fashion.DAO;

import java.util.List;

import shopping.fashion.model.CartItem;
import shopping.fashion.model.CustomerOrder;
import shopping.fashion.model.User;

public interface CartItemDAO {
	void addToCart(CartItem cartItem);
	User getUser(String email);
	List<CartItem>  getCart(String email);//select * from cartitem where user_email=?
	void removeCartItem(int cartItemId);
	CustomerOrder createCustomerOrder(CustomerOrder customerOrder);
}
