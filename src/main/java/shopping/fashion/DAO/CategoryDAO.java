package shopping.fashion.DAO;

import java.util.List;

import shopping.fashion.model.Category;

public interface CategoryDAO 
{
	public List<Category> findAllCategories();
	public Category findCategoryById(int CategoryId);
	public Category findCategoryByName(String CategoryName);
	public boolean addCategory(Category Category);
	public boolean updateCategory(Category Category);
	public boolean deleteCategory(int CategoryId);

}
