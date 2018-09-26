package shopping.fashion.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shopping.fashion.model.Category;
import shopping.fashion.model.Product;
import shopping.fashion.DAO.ProductDAO;
@Repository("productDAO")
@Transactional

public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Product> findAllProducts() {
	return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	public Product findProductById(int ProductId) {
		
		return (Product)sessionFactory.getCurrentSession().createQuery("from Product where ProductId="+ProductId).uniqueResult();
		
	}

	public Product findProductByName(String ProductName) {
		
		return (Product)sessionFactory.getCurrentSession().createQuery("from Product where ProductName='"+ProductName+"'").uniqueResult();
 
	}

	public boolean addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
		return true;
	}

	public boolean updateProduct(Product product) {
		sessionFactory.getCurrentSession().update(product);
		return true;
	}

	public boolean deleteProduct(int productId) {
	sessionFactory.getCurrentSession().delete(findProductById(productId));
		return true;
	}

	public List<Category> findAllCategories() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
		
	}
	public Product getProduct(int id) {
		Session session=sessionFactory.getCurrentSession();
		Product product=(Product)session.get(Product.class, id);
		//session.get(Product.class,id) -> select * from product where id=?
		return product;
	}

}
