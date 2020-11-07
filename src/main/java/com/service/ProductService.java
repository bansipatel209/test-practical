package com.service;

import com.enums.SortingDirection;

public interface ProductService {

	public Object getProducts(String productName, String categoryName, int page, int size, String sortBy,
			SortingDirection sortDirection);

}
