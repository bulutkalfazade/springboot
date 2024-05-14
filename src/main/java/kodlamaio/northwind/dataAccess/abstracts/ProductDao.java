package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product,Integer> {
	
	//ToDo select * from products where product_name = example
	Product getByProductName(String productName);
	
	//ToDo select * from products where product_name = example and category_id = 2
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	 
	//ToDo select * from products where product_name = example or category_id = 2
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

	//ToDo select * from products where category_id in (1, 2, 3, 4)
	List<Product> getByCategoryIn(List<Integer> categories);
	
	//ToDo 
	List<Product> getByProductNameContains(String productName);
	
	//ToDo 
	List<Product> getByProductNameStartsWith(String productName);
	
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	//ToDo select * from products where product_name = example and category_id = example
	List<Product> getByNameAndCategory(String productName, int categoryId); 
	
	//select p.productId, p.productName, c.categoryName from Category c inner join Product p
	//on c.categoryId = p.categoryId
	@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName)  From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
}
