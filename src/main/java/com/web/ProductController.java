package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enums.SortingDirection;
import com.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/GetProductDetails")
	public Object getProductDetails(@RequestParam(required = false) String productName,
			@RequestParam(required = false) String categoryName, @RequestParam int page, @RequestParam int size,
			@RequestParam String sortBy, @RequestParam SortingDirection sortDirection) {
		return productService.getProducts(productName, categoryName, page, size, sortBy, sortDirection);
	}

}
