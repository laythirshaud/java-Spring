package com.ProductCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ProductCategories.models.Category;
import com.ProductCategories.models.Product;
import com.ProductCategories.services.ProCatService;

@Controller
public class StoreController {
	private final ProCatService proCatService;

	public StoreController(ProCatService proCatService) {
		this.proCatService = proCatService;
	}

	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "product.jsp";
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "product.jsp";
		} else {
			Product product1 = proCatService.createProduct(product);
			return "redirect:/products/new";
		}
	}

	@RequestMapping("/category/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "category.jsp";
	}

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "category.jsp";
		} else {
			Category category1 = proCatService.createCategory(category);
			return "redirect:/category/new";
		}
	}
	
	@RequestMapping("products/{id}")
	public String showproduct(Model model,@PathVariable("id")Long id) {
		Product product1=proCatService.findProduct(id);
		model.addAttribute("productFromController",product1);
		List<Category> unlisted =proCatService.allCategoriesExept(product1);
		model.addAttribute("unlisted", unlisted);
		
		return "showproduct.jsp";
	}
	@RequestMapping("/addcategory/{id}")
		
	public String addCategories(@PathVariable("id")Long pro_id, @RequestParam("category")Long cat_id) {
		proCatService.add(pro_id, cat_id);
		return "redirect:/products/"+pro_id;
	}
	@RequestMapping("/categories/{id}")
    public String showCategory(@PathVariable("id")Long id, Model model){
        Category category=proCatService.findCategory(id);
        model.addAttribute("category",category);
        model.addAttribute("unlisted",proCatService.uncategorizedProducts(category));
        return "showcategory.jsp";
    }
	@RequestMapping(value = "/addproduct/{id}",method = RequestMethod.POST)
    public String addProduct(@PathVariable("id")Long cat_id, @RequestParam("product")Long pro_id,Model model){
        proCatService.add(pro_id,cat_id);
        return "redirect:/categories/"+cat_id;
    }
}
