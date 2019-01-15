package com.msi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.msi.model.Customer;
import com.msi.model.Product;
import com.msi.service.ProductService;

@RestController
public class ProductController {

	private final ProductService jewelleryShopService;

	@Autowired
	public ProductController(ProductService jewelleryShopService) {
		this.jewelleryShopService = jewelleryShopService;
	}

	@GetMapping("/getDiscount/{type}/customerAge/{age}")
	public Product getQuestions(@PathVariable("type") String type,@PathVariable("age") int age) {
		
		Product product = new Product();
		product.setType(type);
		Customer customer=new Customer();
		customer.setAge(age);
		jewelleryShopService.getProductDiscount(product,customer);
		return product;
	}
}