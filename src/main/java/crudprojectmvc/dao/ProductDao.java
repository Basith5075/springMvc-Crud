package crudprojectmvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import crudprojectmvc.model.Product;

@Component
public class ProductDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	// Creating or updating the product in the DB.
	@Transactional
	public void createUpdateProduct(Product prod) {
		
		hibernateTemplate.saveOrUpdate(prod);
		
	}
	
	// Get all products 
	
	public List<Product> getAllProducts(){
		
		List<Product> prodList = hibernateTemplate.loadAll(Product.class);
		
		return prodList;
	}
	
	// Delete a product 
	@Transactional
	public void deleteProduct(int pid) {
		
		Product prod = hibernateTemplate.load(Product.class, pid);
		hibernateTemplate.delete(prod);
	}
	
	// Get a product by its ID.
	
	public Product getProdByID(int id) {
		
		Product prod = hibernateTemplate.get(Product.class, id);
		
		return prod;
	}
	
	@Transactional
	public Product updateProduct(Product prod) {
		
		hibernateTemplate.update(prod);
		
		return prod;
	}
	

}
