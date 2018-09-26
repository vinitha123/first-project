package shopping.fashion.test;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import shopping.fashion.DBConfig.DBConfig;
import shopping.fashion.model.Category;
import shopping.fashion.DAO.CategoryDAO;

import junit.framework.TestCase;

public class CategoryDAOImplTest extends TestCase {
	Category Category1 = new Category();
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	CategoryDAO CategoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	Scanner sc = new Scanner(System.in);
@Test
	public void testFindAllCategorys() {
		List<Category> productCategoryList = CategoryDAO.findAllCategories();
		for(Category productCategory : productCategoryList)
		{
			System.out.print("| Id:"+productCategory.getCategoryId()+"|");
			System.out.print("Name:"+productCategory.getCategoryName()+"|");
			System.out.print("Parent :"+productCategory.getParentCategory()+"|");
			System.out.println("");

		}
	}
@Test
	public void testFindCategoryById() {
		System.out.println("Please enter the CategoryId to view Category Details");
		int CategoryId3 = sc.nextInt();
		Category Category = CategoryDAO.findCategoryById(CategoryId3);
		System.out.print("| Id:"+Category.getCategoryId()+"|");
		System.out.print("Name:"+Category.getCategoryName()+"|");
		System.out.print("Parent :"+Category.getParentCategory()+"|");
		
	}
@Test
	public void testFindCategoryByName() {
		System.out.println("Please enter the CategoryName to view Category Details");
		String CategoryName = sc.next();
		Category Category2 = CategoryDAO.findCategoryByName(CategoryName);
		System.out.print("| Id:"+Category2.getCategoryId()+"|");
		System.out.print("Name:"+Category2.getCategoryName()+"|");
		System.out.print("Parent :"+Category2.getParentCategory()+"|");
		
	}
@Test
	public void testAddCategory() {
		System.out.println("Please Enter the productCategory details to enter");
		System.out.println("ProductCategory ID:");
		Category1.setCategoryId(sc.nextInt());
		System.out.println("CategoryName:");
        Category1.setCategoryName(sc.next());
		System.out.println("ParentCategory:");
        Category1.setParentCategory(sc.next());
		boolean result1 = CategoryDAO.addCategory(Category1);
		if(result1 == true)
		{
			System.out.println("Details has been added successfully");
		}
	}
@Test
	public void testUpdateCategory() {
		
	}

	public void testDeleteCategory() {
		List<Category> CategoryList1 = CategoryDAO.findAllCategories();
		for(Category Category : CategoryList1)
		{
			System.out.print("| Id:"+Category.getCategoryId()+"|");
			System.out.print("Name:"+Category.getCategoryName()+"|");
			System.out.print("Parent :"+Category.getParentCategory()+"|");
			System.out.println("");

		}
		System.out.println("Please enter the ProductCategoryId to be deleted from the above Table");
		int ProductCategoryId = sc.nextInt();
		boolean result = CategoryDAO.deleteCategory(ProductCategoryId);
		if(result == true)
		{
			System.out.println("The row has been successfuly deleted");
		}
		
	}

}
