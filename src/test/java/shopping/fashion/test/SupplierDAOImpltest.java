package shopping.fashion.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import shopping.fashion.DBConfig.DBConfig;
import shopping.fashion.model.Product;
import shopping.fashion.model.Supplier;
import shopping.fashion.DAO.SupplierDAO;

import junit.framework.TestCase;

public class SupplierDAOImpltest extends TestCase {
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	Supplier supplier=new Supplier();
	public void testFindAllSuppliers() {
		List<Supplier>supplierList=supplierDAO.findAllSuppliers();
		assertNotNull(supplierList);		
	}

	public void testFindSupplierById() {
		Supplier supplier1=supplierDAO.findSupplierById(11);
		assertNotNull(supplier1);
		supplier1.getSupplierName();
		supplier1.getSupplierAddress();
		supplier1.getSupplierMailId();
		supplier1.getSupplierMobNo();
	int expectedId=11;
	int actualId=supplier1.getSupplierId();
		assertTrue(expectedId==actualId);	
	}

	public void testFindSupplierByName() {
		Supplier supplier2 = supplierDAO.findSupplierByName("dd");
		assertNotNull(supplier2);
		supplier2.getSupplierName();
		supplier2.getSupplierAddress();
		supplier2.getSupplierMailId();
		supplier2.getSupplierMobNo();
		String expectedName="dd";
		String actualName=supplier2.getSupplierName();
		assertTrue(expectedName.equals(actualName));		
	}

	public void testAddSupplier() {
		Supplier supplier=new Supplier();
		supplier.setSupplierId(12);
		supplier.setSupplierName("momo");
		supplier.setSupplierMailId("mo@gmail.com");
		supplier.setSupplierMobNo("202020");;
		supplier.setSupplierAddress("chennai");
		//boolean result1 = userDAO.addUser(user1);
		assertEquals(true,supplierDAO.addSupplier(supplier));	
	}

	public void testUpdateSupplier() {
		Supplier supplier3=supplierDAO.findSupplierById(11);
		supplier3.setSupplierName("ram");
		supplier3.setSupplierAddress("chennai");
		supplier3.setSupplierMailId("ram@gmail.com");
		supplier3.setSupplierMobNo("787128");
		supplierDAO.updateSupplier(supplier3);
		supplierDAO.updateSupplier(supplier3);
		assertTrue(supplier3.getSupplierName()=="ram");
		assertTrue(supplier3.getSupplierMobNo()=="787128");
	}

	public void testDeleteSupplier() {
		Supplier supplier4=supplierDAO.findSupplierById(22);
		supplier4.getSupplierName();
		supplier4.getSupplierAddress();
		supplier4.getSupplierMailId();
		supplier4.getSupplierMobNo();
		assertEquals(true,supplierDAO.deleteSupplier(supplier4.getSupplierId()));

		
		}
	}


