package com.example.jpatuts;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpatuts.entites.ProductEntity;
import com.repositories.ProductRepository;

@SpringBootTest
class JpaTutsApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testProductRepository() {
		// You can write tests for your ProductRepository here
		ProductEntity productEntity = ProductEntity.builder()
				.sku("SKU1234")
				.title("Sample Productf")
				.price(BigDecimal.valueOf(18.99))
				.quantity(100)
				.build();
		ProductEntity savedProduct = productRepository.save(productEntity);
		System.out.println("Saved Product: " + savedProduct);
	}

	@Test
	void getProductById() {
		Long productId = 1L; // Replace with an actual product ID from your database
		ProductEntity productEntity = productRepository.findById(productId).orElse(null);
		System.out.println("Product with ID " + productId + ": " + productEntity);
	}

	@Test
	void getAllProducts() {
		System.out.println("All Products: " + productRepository.findAll());
	}

	@Test
	void getProductsByTitle() {
		String title = "Pepsi"; // Replace with an actual product title from your database
		List<ProductEntity> products = productRepository.findByTitleOrderByPriceAsc(title);
		System.out.println("Products with Title '" + title + "': " + products);
	}
	@Test
	void findByCreatedAtAfter() {
		// Implement this test to find products created after a certain date
		LocalDateTime inputTime = LocalDateTime.of(2024, 1,1,0,0);
		List<ProductEntity> products = productRepository.findByCreatedAtAfter(inputTime);
		System.out.println("Products created after 2024-01-01: " + products);
	}

}
