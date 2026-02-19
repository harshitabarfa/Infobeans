package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService ps;

	@GetMapping("/getAllProduct")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> list = ps.getAllProduct();

		if (list == null || list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.ok(list);
		}
	}

	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product p) {
		Product product = ps.addProduct(p);

		return ResponseEntity.status(201).body(product);
	}

	@GetMapping("/getProductById/{id}")
	public ResponseEntity<?> getProductById(@PathVariable int id) {
		Product product = ps.getProductById(id);

		if (product == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found!");
		} else {
			return ResponseEntity.ok(product);
		}
	}

	@DeleteMapping("/removeProduct/{id}")
	public ResponseEntity<String> removeProduct(@PathVariable int id) {
		String msg = ps.removeProduct(id);

		if (msg.equalsIgnoreCase("Product not found!")) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found!");
		} else {
			return ResponseEntity.ok(msg);
		}
	}

	@GetMapping("/getProductByCategory/{category}")
	public ResponseEntity<?> getProductByCategory(@PathVariable String category) {
		List<Product> list = ps.getProductByCategory(category);

		if (list == null || list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No products found in this category!");
		} else {
			return ResponseEntity.ok(list);
		}
	}

	@PutMapping("/updateById/{id}")
	public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable("id") int id) {
		Product updated = ps.updateP(product, id);
		if (updated == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found for update!");
		} else {
			return ResponseEntity.ok(updated);
		}
	}
}
