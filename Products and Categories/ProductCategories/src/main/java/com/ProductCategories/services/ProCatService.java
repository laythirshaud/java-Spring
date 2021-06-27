package com.ProductCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ProductCategories.models.Category;
import com.ProductCategories.models.Product;
import com.ProductCategories.repositories.CategoryRepository;
import com.ProductCategories.repositories.ProductRepository;

@Service
public class ProCatService {
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;

	public ProCatService(CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	public List<Product> findAllProduct() {
		return productRepository.findAll();
	}

	public List<Category> findAllCategory() {
		return categoryRepository.findAll();
	}

	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}

	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}

	public List<Category> allCategoriesExept(Product product) {
		return categoryRepository.findByProductsNotContains(product);
	}

	public Product add(Long pro_id, Long cat_id) {
		Product product = productRepository.findById(pro_id).orElse(null);
		Category category = categoryRepository.findById(cat_id).orElse(null);
		List<Category> cat = product.getCategories();
		cat.add(category);
		product.setCategories(cat);

		return productRepository.save(product);
	}

	public List<Product> uncategorizedProducts(Category category) {
		return productRepository.findByCategoriesNotContains(category);
	}

}
