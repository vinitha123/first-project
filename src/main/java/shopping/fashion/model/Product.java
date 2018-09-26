package shopping.fashion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity

public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private	int ProductId;
	@NotEmpty(message="ProductDescription is mandatory")
private	String ProductDescription;
	@NotEmpty(message="ProductName cannot be empty")
private	String ProductName;
private	int ProductSize;
	@Min(value=0,message="ProductQuantity cannot be less than 0")
private	int ProductQuantity;
@Min(value=1,message="Minimum value for ProductPrice is 1")
private	double ProductPrice;
public MultipartFile getImage() {
	return image;
}
public void setImage(MultipartFile image) {
	this.image = image;
}
@ManyToOne
private Category category;
@Transient
private MultipartFile image;
	public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public String getProductDescription() {
		return ProductDescription;
	}
	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getProductSize() {
		return ProductSize;
	}
	public void setProductSize(int productSize) {
		ProductSize = productSize;
	}
	public int getProductQuantity() {
		return ProductQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}
	public double getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(double productPrice) {
		ProductPrice = productPrice;
		
	}
	}
