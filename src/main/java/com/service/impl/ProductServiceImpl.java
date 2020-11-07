package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.domain.Category;
import com.domain.Product;
import com.enums.SortingDirection;
import com.repository.ProductRepository;
import com.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Object getProducts(String productName, String categoryName, int page, int size, String sortBy,
			SortingDirection sortDirection) {

		Pageable pageable = PageRequest.of(page, size);
		Page<Product> products = productRepository.findAll(new Specification<Product>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

				List<Predicate> predicates = new ArrayList<>();
				Join<Product, Category> productCategory = root.join("category");

				if (productName != null && !productName.isEmpty()) {
					predicates.add(criteriaBuilder.like(root.get("productName"), "%"+productName+"%"));
				}
				if (categoryName != null && !categoryName.isEmpty()) {
					predicates.add(criteriaBuilder.like(root.get("categoryName"), "%"+categoryName+"%"));
				}
				if (sortDirection.equals(SortingDirection.ASC)) {
					if (sortBy.equals("productName")) {
						query.orderBy(criteriaBuilder.asc(root.get("productName")));
					} else if (sortBy.equals("categoryName")) {
						query.orderBy(criteriaBuilder.asc(root.get("categoryName")));
					}
				} else if (sortDirection.equals(SortingDirection.DESC)) {
					if (sortBy.equals("productName")) {
						query.orderBy(criteriaBuilder.desc(root.get("productName")));
					} else if (sortBy.equals("categoryName")) {
						query.orderBy(criteriaBuilder.desc(root.get("categoryName")));
					}
				}
				query.distinct(true);
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		}, pageable);

		return products.getContent();
	}

}
