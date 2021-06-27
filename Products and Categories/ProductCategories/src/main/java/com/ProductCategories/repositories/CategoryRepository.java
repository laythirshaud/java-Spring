package com.ProductCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ProductCategories.models.Category;
import com.ProductCategories.models.Product;
@Repository
public interface CategoryRepository  extends CrudRepository<Category, Long> {
	List<Category> findAll();
	List<Category> findByProductsNotContains(Product product);
	
}
