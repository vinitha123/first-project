package shopping.fashion.DAO;

import java.util.List;

import shopping.fashion.model.Category;
import shopping.fashion.model.Product;

public interface ProductDAO {
public List<Product> findAllProducts();
public Product findProductById(int ProductId);
public Product findProductByName(String ProductName);
public boolean addProduct(Product product);
public boolean updateProduct(Product product);
public boolean deleteProduct(int productId);
List<Category> findAllCategories();
Product getProduct(int id);
}
