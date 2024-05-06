package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product,Integer> {
	
	//ToDo select * from products where product_name = example
	Product getByProductName(String productName);
	
	//ToDo select * from products where product_name = example and category_id = 2
	Product getByProductNameAndCategoryId(String productName, int categoryId);
	 
	
	//ToDo select * from products where product_name = example or category_id = 2
	List<Product> getByProductNameOrCategoryId(String productName, int categoryId);

	//ToDo select * from products where category_id in (1, 2, 3, 4)
	List<Product> getByCategoryIdIn(List<Integer> categories);
	
	//ToDo 
	List<Product> getByProductNameContains(String productName);
	
	//ToDo 
	List<Product> getByProductNameStartsWith(String productName);
	
	@Query("From Product where productName=:productName and categoryId=:categoryId")
	//ToDo select * from products where product_name = example and category_id = example
	List<Product> getByNameAndCategory(String productName, int categoryId);
}
