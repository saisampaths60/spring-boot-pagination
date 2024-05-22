package com.sample.springbootpagination.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sample.springbootpagination.entity.Product;
import com.sample.springbootpagination.repository.ProductRepository;
import com.sample.springbootpagination.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Page<Product> getProductsPaginated(int page, int size) {
		return productRepository.findAll(PageRequest.of(page, size));
	}

}
