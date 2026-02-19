package com.first.Product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

public class App {
	private static SessionFactory sf;

	public static void main(String[] args) {
		System.out.println("Hello World!");

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n--- Product Inventory Menu ---");
			System.out.println("1. Insert Product");
			System.out.println("2. Fetch Product by ID");
			System.out.println("3. Update Product Quantity");
			System.out.println("4. Delete Product by ID");
			System.out.println("5. Exit");

			System.out.print("Enter choice: ");
			choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
			case 1:
				insertProduct(sc);
				break;
			case 2:
				fetchProduct(sc);
				break;
			case 3:
				updateProduct(sc);
				break;
			case 4:
				deleteProduct(sc);
				break;
			case 5:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice!");
			}

		} while (choice != 5);

		sf.close();
		sc.close();
	}

	private static void insertProduct(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter product id: ");
		int id = Integer.parseInt(sc.nextLine());

		System.out.print("Enter product name: ");
		String name = sc.nextLine();

		System.out.print("Enter category: ");
		String category = sc.nextLine();

		System.out.print("Enter price: ");
		double price = Double.parseDouble(sc.nextLine());

		System.out.print("Enter quantity: ");
		int quantity = Integer.parseInt(sc.nextLine());

		Product p = new Product(id, name, category, price, quantity);
		session.persist(p);

		tx.commit();
		session.close();
		System.out.println("Product inserted successfully!");
	}

	private static void fetchProduct(Scanner sc) {
		Session session = sf.openSession();

		System.out.print("Enter product id: ");
		int id = Integer.parseInt(sc.nextLine());

		Product p = session.get(Product.class, id);

		if (p != null) {
			System.out.println(p);
		} else {
			System.out.println("Product not found");
		}

		session.close();
	}

	private static void updateProduct(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter product id to update: ");
		int id = Integer.parseInt(sc.nextLine());

		Product p = session.get(Product.class, id);

		if (p != null) {
			System.out.print("Enter new quantity: ");
			int newQuantity = Integer.parseInt(sc.nextLine());

			p.setQuantity(newQuantity);
			session.merge(p);

			System.out.println("Quantity updated successfully");
		} else {
			System.out.println("Product not found");
		}

		tx.commit();
		session.close();
	}

	private static void deleteProduct(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter product id to delete: ");
		int id = Integer.parseInt(sc.nextLine());

		Product p = session.get(Product.class, id);

		if (p != null) {
			session.remove(p);

			System.out.println("Product deleted successfully!");
		} else {
			System.out.println("Product not found");
		}

		tx.commit();
		session.close();
	}
}
