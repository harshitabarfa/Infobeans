package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService ps;

	@GetMapping("/getAllProduct")
	public List<Product> getAllProduct() {
		List<Product> list = ps.getAllProduct();
		return list;
	}

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product p) {
		return ps.addProduct(p);
	}

	@GetMapping("/getProductById/{id}")
	public Product getProductById(@PathVariable int id) {
		return ps.getProductById(id);
	}

	@DeleteMapping("/removeProduct/{id}")
	public String removeProduct(@PathVariable("id") int id) {
		return this.ps.removeProduct(id);
	}

	@GetMapping("/getProductByCategory/{category}")
	public List<Product> getProductByCategory(@PathVariable String category) {
		return ps.getProductByCategory(category);
	}

	@PutMapping("/updateById/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable("id") int id) {
		return ps.updateP(product, id);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Product>> searchProducts(@RequestParam(required = false) String name,
			@RequestParam(required = false) String category, @RequestParam(required = false) Double price) {
		List<Product> p = ps.findByNameCategoryAndPrice(name, category, price);
		return ResponseEntity.status(200).body(p);
	}
}
