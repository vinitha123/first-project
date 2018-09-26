package shopping.fashion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Category
{
	@Id
	
	private	int categoryId;
	private	String categoryName;
	String ParentCategory;
	@OneToMany(mappedBy="category")
	private List<Product> products;

	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
		@Override
		public String toString() {
		  return this.categoryId + " " + this.categoryName;
	}
		public String getParentCategory() {
			return ParentCategory;
		}
		public void setParentCategory(String parentCategory) {
			ParentCategory = parentCategory;
		}
		
		
		
	
}

