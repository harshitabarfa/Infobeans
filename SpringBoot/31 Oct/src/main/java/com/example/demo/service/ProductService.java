package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;

@Service
public class ProductService {
	public static List<Product> list = new ArrayList<>();

	static {
		list.add(new Product(1, "TV", "Electronic", 20000));
		list.add(new Product(2, "T-Shirt", "Cloth", 30000));
		list.add(new Product(3, "Freeze", "Electronic", 40000));
	}

	public List<Product> getAllProduct() {
		return list;
	}

	public Product addProduct(Product product) {
		list.add(product);
		return product;
	}

	public Product getProductById(int id) {
		Iterator itr = list.iterator();

		Product product = null;
		while (itr.hasNext()) {
			product = (Product) itr.next();
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}

	public String removeProduct(int id) {
		Iterator itr = list.iterator();

		Product product = null;
		while (itr.hasNext()) {
			product = (Product) itr.next();
			if (product.getId() == id) {
				itr.remove();
				return "Product deleted successfully!";
			}
		}
		return null;
	}

	public List<Product> getProductByCategory(String category) {
		List<Product> psc = new ArrayList<>();

		Iterator<Product> itr = list.iterator();
		while (itr.hasNext()) {
			Product product = itr.next();
			if (product.getCategory().equalsIgnoreCase(category)) {
				psc.add(product);
			}
		}
		return psc;
	}

	public Product updateP(Product product, int id) {
		Iterator itr = list.iterator();

		while (itr.hasNext()) {
			Product p = (Product) itr.next();
			if (p.getId() == id) {
				p.setName(product.getName());
				p.setCategory(product.getCategory());
				p.setPrice(product.getPrice());
				return product;
			}
		}
		return null;
	}

	public List<Product> findByNameCategoryAndPrice(String name, String category, Double price) {
		List<Product> allProducts = getAllProduct();
		List<Product> result = new ArrayList<>();

		for (Product product : allProducts) {
			boolean matchName = (name == null || name.isEmpty()) || product.getName().equalsIgnoreCase(name);

			boolean matchCategory = (category == null || category.isEmpty())
					|| product.getCategory().equalsIgnoreCase(category);

			boolean matchPrice = (price == null || price == 0) || Double.compare(product.getPrice(), price) == 0;

			if (matchName && matchCategory && matchPrice) {
				result.add(product);
			}
		}
		return result;
	}
}
