package com.second.Library;

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
			System.out.println("\n--- Library Book Management System ---");
			System.out.println("1. Insert New Book");
			System.out.println("2. Fetch Book by ID");
			System.out.println("3. Update Book Quantity or Price");
			System.out.println("4. Delete Book by ID");
			System.out.println("5. Exit");

			System.out.print("Enter choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				insertBook(sc);
				break;
			case 2:
				fetchBook(sc);
				break;
			case 3:
				updateBook(sc);
				break;
			case 4:
				deleteBook(sc);
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

	private static void insertBook(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Book ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter title: ");
		String title = sc.nextLine();

		System.out.print("Enter author: ");
		String author = sc.nextLine();

		System.out.print("Enter genre: ");
		String genre = sc.nextLine();

		System.out.print("Enter price: ");
		double price = sc.nextDouble();
		sc.nextLine();

		System.out.print("Enter published year: ");
		int year = sc.nextInt();

		System.out.print("Enter quantity: ");
		int qty = sc.nextInt();

		Library l = new Library(id, title, author, genre, price, year, qty);
		session.persist(l);

		tx.commit();
		session.close();

		System.out.println("Book inserted successfully");
	}

	private static void fetchBook(Scanner sc) {
		Session session = sf.openSession();

		System.out.print("Enter product id: ");
		int id = Integer.parseInt(sc.nextLine());

		Library l = session.get(Library.class, id);

		if (l != null) {
			System.out.print(l);
		} else {
			System.out.print("Book not found");
		}

		session.close();
	}

	private static void updateBook(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter book id: ");
		int id = Integer.parseInt(sc.nextLine());

		Library l = session.get(Library.class, id);

		if (l != null) {
			System.out.println("1. Update quantity");
			System.out.println("2. Update price");
			int option = sc.nextInt();

			if (option == 1) {
				System.out.print("Enter new quantity: ");
				int newQty = sc.nextInt();

				l.setQuantity(newQty);
			} else if (option == 2) {
				System.out.print("Enter new price: ");
				double newPrice = sc.nextDouble();

				l.setPrice(newPrice);
			}

			session.merge(l);
			tx.commit();
			System.out.println("Book updated successfully");
		} else {
			System.out.println("Book not found");
		}
		session.close();
	}

	private static void deleteBook(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter book id to delete: ");
		int id = Integer.parseInt(sc.nextLine());

		Library l = session.get(Library.class, id);

		if (l != null) {
			session.remove(l);
			tx.commit();
			
			System.out.println("Book deleted successfully");
		} else {
			System.out.println("Book not found");
		}
		session.close();
	}
}
