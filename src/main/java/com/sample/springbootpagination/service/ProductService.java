package com.sample.springbootpagination.service;

import org.springframework.data.domain.Page;

import com.sample.springbootpagination.entity.Product;

public interface ProductService {

	public Page<Product> getProductsPaginated(int page, int size);

}
