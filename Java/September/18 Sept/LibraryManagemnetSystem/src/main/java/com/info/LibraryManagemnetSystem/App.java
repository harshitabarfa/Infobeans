package com.info.LibraryManagemnetSystem;

import jakarta.persistence.*;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyUnit");
		EntityManager em = factory.createEntityManager();

		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n---Library Management System---");
			System.out.println("1. Add New Book");
			System.out.println("2. View Book by ID");
			System.out.println("3. Update Book");
			System.out.println("4. Delete Book");
			System.out.println("0. Exit");

			System.out.print("\nEnter choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				addBook(em, sc);
				break;
			case 2:
				viewBook(em, sc);
				break;
			case 3:
				updateBook(em, sc);
				break;
			case 4:
				deleteBook(em, sc);
				break;
			case 0:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice!");
			}
		} while (choice != 0);
		factory.close();
	}

	private static void addBook(EntityManager em, Scanner sc) {
		System.out.print("Enter Title: ");
		String title = sc.nextLine();

		System.out.print("Enter Author: ");
		String author = sc.nextLine();

		System.out.print("Enter Price: ");
		double price = sc.nextDouble();
		sc.nextLine();

		System.out.print("Enter Published Year: ");
		int year = sc.nextInt();

		Book b = new Book();
		b.setTitle(title);
		b.setAuthor(author);
		b.setPrice(price);
		b.setPublishedYear(year);

		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		System.out.println("Book added successfully!");
	}

	private static void viewBook(EntityManager em, Scanner sc) {
		System.out.print("Enter Book ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		Book b = em.find(Book.class, id);
		if (b != null) {
			System.out.println(b);
		} else {
			System.out.println("Book not found!");
		}
	}

	private static void updateBook(EntityManager em, Scanner sc) {
		System.out.print("Enter Book ID to Update: ");
		int id = sc.nextInt();
		sc.nextLine();

		Book book = em.find(Book.class, id);
		if (book != null) {
			System.out.print("Enter new Title: ");
			book.setTitle(sc.nextLine());

			System.out.print("Enter new Author: ");
			book.setAuthor(sc.nextLine());

			System.out.print("Enter new Price: ");
			book.setPrice(sc.nextDouble());

			System.out.print("Enter new Published Year: ");
			book.setPublishedYear(sc.nextInt());

			em.getTransaction().begin();
			em.merge(book);
			em.getTransaction().commit();
			System.out.println("Book updated successfully!");
		} else {
			System.out.println("Book not found.");
		}
	}

	private static void deleteBook(EntityManager em, Scanner sc) {
		System.out.print("Enter Book ID to Delete: ");
		int id = sc.nextInt();

		Book book = em.find(Book.class, id);
		if (book != null) {
			em.getTransaction().begin();
			em.remove(book);
			em.getTransaction().commit();
			System.out.println("Book deleted.");
		} else {
			System.out.println("Book not found.");
		}
	}
}
