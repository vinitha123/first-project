package shopping.fashion.spartanbackend;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import shopping.fashion.DBConfig.DBConfig;
import shopping.fashion.model.Product;
import shopping.fashion.DAO.ProductDAO;

public class ProductMain 
{
public void productOut()
{
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
	Product product=new Product();
	
    Scanner sc = new Scanner(System.in);
		
		System.out.println("Please select a category to do the manipulation");
		System.out.println("1.Add Products /n 2.Delete Products /n 3.Update Products /n 4.View All Products /n 5.View Products by ID /n 6.View Products by Name");
		
		int choice = sc.nextInt();
		
		switch(choice){
		case 1:
			System.out.println("Please Enter the user details to enter");
			System.out.println("Product ID:");

			product.setProductId(sc.nextInt());
			
			System.out.println("Product Name:");

			product.setProductName(sc.next());
			
			System.out.println("Product Description:");

			product.setProductDescription(sc.next());
			System.out.println("Product Size:");

			product.setProductSize(sc.nextInt());
			System.out.println("Product Quantity:");

			product.setProductQuantity(sc.nextInt());
			System.out.println("Product Price:");
			
			product.setProductPrice(sc.nextDouble());
			
			boolean result1 = productDAO.addProduct(product);
			if(result1 == true)
			{
				System.out.println("Details has been added successfully");
			}
			break;
		case 2:
			
			List<Product> productList1 = productDAO.findAllProducts();
			for(Product product1 : productList1)
			{
				System.out.print("| Id:"+product1.getProductId()+"|");
				System.out.print("Name:"+product1.getProductName()+"|");
				System.out.print("Description:"+product1.getProductDescription()+"|");
				System.out.print("Size:"+product1.getProductSize()+"|");
				System.out.print("Quantity:"+product1.getProductQuantity()+"");
				System.out.print("Price:"+product1.getProductPrice()+"");
				
				System.out.println("");

			}
			System.out.println("Please enter the ProductId to be deleted from the above Table");
			int ProductId = sc.nextInt();
			boolean result = productDAO.deleteProduct(ProductId);
			if(result == true)
			{
				System.out.println("The row has been successfuly deleted");
			}
			break;
		case 3:
			List<Product> productList2 = productDAO.findAllProducts();
			for(Product product2 : productList2)
			{
				System.out.print("| Id:"+product2.getProductId()+"|");
				System.out.print("Name:"+product2.getProductName()+"|");
				System.out.print("Description:"+product2.getProductDescription()+"|");
				System.out.print("Size:"+product2.getProductSize()+"|");
				System.out.print("Quantity:"+product2.getProductQuantity()+"");
				System.out.print("Price:"+product2.getProductPrice()+"");
				
				System.out.println("");

			}
			System.out.println("Please Enter the ProductId");
			product.setProductId(sc.nextInt());
			System.out.println("Please Enter the product details for updation");
			
			System.out.println("ProductName:");

			product.setProductName(sc.next());
			
			System.out.println("Product Description:");

			product.setProductDescription(sc.next());
			System.out.println("Product Size:");

			product.setProductSize(sc.nextInt());
			System.out.println("Product Quantity:");

			product.setProductQuantity(sc.nextInt());
			System.out.println("Product Price:");
			
			product.setProductPrice(sc.nextDouble());
			
			boolean result2 = productDAO.updateProduct(product);
			if(result2 == true)
			{
				System.out.println("Details has been updated successfully");
			}
			break;
			
		case 4:
			List<Product> productList = productDAO.findAllProducts();
			for(Product product3 : productList)
			{
				System.out.print("| Id:"+product3.getProductId()+"|");
				System.out.print("Name:"+product3.getProductName()+"|");
				System.out.print("Description:"+product3.getProductDescription()+"|");
				System.out.print("Size:"+product3.getProductSize()+"|");
				System.out.print("Quantity:"+product3.getProductQuantity()+"");
				System.out.print("Price:"+product3.getProductPrice()+"");
				
				System.out.println("");
			}
			break;
			
		case 5:
			System.out.println("Please enter the Product Id to view Product Details");
			int productId3 = sc.nextInt();
			Product product4 = productDAO.findProductById(productId3);
			System.out.print("| Id:"+product4.getProductId()+"|");
			System.out.print("Name:"+product4.getProductName()+"|");
			System.out.print("Description:"+product4.getProductDescription()+"|");
			System.out.print("Size:"+product4.getProductSize()+"|");
			System.out.print("Quantity:"+product4.getProductQuantity()+"");
			System.out.print("Price:"+product4.getProductPrice()+"");
			break;
		case 6:
			System.out.println("Please enter the ProductId to view User Details");
			String ProductName = sc.next();
			Product product5 = productDAO.findProductByName(ProductName);
			System.out.print("| Id:"+product5.getProductId()+"|");
			System.out.print("Name:"+product5.getProductName()+"|");
			System.out.print("Description:"+product5.getProductDescription()+"|");
			System.out.print("Size:"+product5.getProductSize()+"|");
			System.out.print("Quantity:"+product5.getProductQuantity()+"");
			System.out.print("Price:"+product5.getProductPrice()+"");

			break;
			
	 default: System.out.println("Please enter a valid input");
			
		}
		
		
		
		context.close();
		sc.close();
		
	
}
}
