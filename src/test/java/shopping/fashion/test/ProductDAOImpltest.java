package shopping.fashion.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import shopping.fashion.DBConfig.DBConfig;
import shopping.fashion.model.Product;
import shopping.fashion.model.Customer;
import shopping.fashion.DAO.ProductDAO;
import shopping.fashion.DAO.UserDAO;

import junit.framework.TestCase;

public class ProductDAOImpltest extends TestCase {
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
	Product product1=new Product();

	public void testFindAllProducts() {
		List<Product>productList=productDAO.findAllProducts();
		assertNotNull(productList);	
	}

	public void testFindProductById() {
		Product product1=productDAO.findProductById(19);
		assertNotNull(product1);
		product1.getProductName();
		product1.getProductDescription();
		product1.getProductSize();
		product1.getProductQuantity();
		product1.getProductPrice();
	int expectedId=19;
	int actualId=product1.getProductId();
		assertTrue(expectedId==actualId);		
	}

	public void testFindProductByName() {
		Product product2 = productDAO.findProductByName("glass");
		assertNotNull(product2);
		product2.getProductName();
		product2.getProductDescription();
		product2.getProductSize();
		product2.getProductQuantity();
		product2.getProductPrice();
		String expectedName="glass";
		String actualName=product2.getProductName();
		assertTrue(expectedName.equals(actualName));	
	}

	public void testAddProduct() {
		Product product=new Product();
		product.setProductId(19);
		product.setProductName("imran");
		product.setProductDescription("@email.com");
		product.setProductSize(100);
		product.setProductQuantity(20);
		//boolean result1 = userDAO.addUser(user1);
		assertEquals(true,productDAO.addProduct(product));
	}

        public void testUpdateProduct() {
		Product product3=productDAO.findProductById(19);
		product3.setProductName("glass");
		product3.setProductDescription("sunglass");
		product3.setProductSize(100);
		product3.setProductQuantity(10);
		product3.setProductPrice(2000.0);
		productDAO.updateProduct(product3);
		productDAO.updateProduct(product3);
		assertTrue(product3.getProductDescription()=="sunglass");
		assertTrue(product3.getProductPrice()==2000.0);
	}

	public void testDeleteProduct() {
		Product product4=productDAO.findProductById(202);
		product4.getProductName();
		product4.getProductDescription();
		product4.getProductSize();
		product4.getProductQuantity();
		assertEquals(true,productDAO.deleteProduct(product4.getProductId()));

		
		}
	}


