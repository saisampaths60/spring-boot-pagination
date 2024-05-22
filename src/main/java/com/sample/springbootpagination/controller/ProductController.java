package com.sample.springbootpagination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sample.springbootpagination.entity.Product;
import com.sample.springbootpagination.response.PageResponse;
import com.sample.springbootpagination.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public PageResponse<Product> getProducts(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {

		Page<Product> products = productService.getProductsPaginated(page, size);
		String nextUrl = null;
		if (products.hasNext()) {
			nextUrl = UriComponentsBuilder.fromPath("/products").queryParam("page", page + 1).queryParam("size", size)
					.toUriString();
		}
		return new PageResponse<>(products.getContent(), nextUrl);
	}
}