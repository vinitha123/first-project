package shopping.fashion.DAO;

import shopping.fashion.model.Customer;

public interface CustomerDAO {
	void registerCustomer(Customer customer);
	boolean isEmailUnique(String email);
}
