package com.first.AuthorBiography;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {
	private static SessionFactory sf;

	public static void main(String[] args) {
		System.out.println("Hello World!");

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n--- AUTHOR & BIOGRAPHY MANAGEMENT SYSTEM ---");
			System.out.println("1. Add New Author and Biography");
			System.out.println("2. List All Authors with Biographies");
			System.out.println("3. Update Author and Biography");
			System.out.println("4. Delete Author");
			System.out.println("5. Exit");

			System.out.print("\nEnter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				addAuthor(sc);
				break;

			case 2:
				listAllAuthors(sc);
				break;

			case 3:
				updateAuthor(sc);
				break;

			case 4:
				deleteAuthor(sc);
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

	private static void addAuthor(Scanner sc) {
		try (Session session = sf.openSession()) {
			Transaction tx = session.beginTransaction();

			System.out.print("Enter Author Name: ");
			String name = sc.nextLine();

			System.out.print("Enter Author Email: ");
			String email = sc.nextLine();

			System.out.print("Enter Biography Text: ");
			String bioText = sc.nextLine();

			System.out.print("Enter Awards: ");
			String awards = sc.nextLine();

			Biography b = new Biography(bioText, awards);
			Author a = new Author(name, email, b);

			session.persist(a);
			tx.commit();

			System.out.println("\nAuthor and Biography added successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void listAllAuthors(Scanner sc) {
		try (Session session = sf.openSession()) {
			List<Author> l = session.createQuery("from Author", Author.class).getResultList();
			for (Author a : l) {
				System.out.println(a);
				System.out.println("Biography: " + a.getBiography());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void updateAuthor(Scanner sc) {
		try (Session session = sf.openSession()) {
			Transaction tx = session.beginTransaction();

			System.out.print("Enter Author ID to update: ");
			int id = sc.nextInt();
			sc.nextLine();

			Author a = session.get(Author.class, id);

			if (a != null) {
				System.out.print("Enter new Author Name: ");
				String newName = sc.nextLine();

				System.out.print("Enter new Author Email: ");
				String newEmail = sc.nextLine();

				System.out.print("Enter new Biography Text: ");
				String newBioText = sc.nextLine();

				System.out.print("Enter new Awards: ");
				String newAwards = sc.nextLine();

				a.setName(newName);
				a.setEmail(newEmail);
				a.getBiography().setBioText(newBioText);
				a.getBiography().setAwards(newAwards);

				session.update(a);
				tx.commit();

				System.out.println("\nAuthor and Biography updated successfully");

			} else {
				System.out.println("Author not found!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void deleteAuthor(Scanner sc) {
		try (Session session = sf.openSession()) {
			Transaction tx = session.beginTransaction();

			System.out.print("Enter Author ID to delete: ");
			int deleteId = sc.nextInt();
			sc.nextLine();

			Author a = session.get(Author.class, deleteId);

			if (a != null) {
				session.remove(a);
				tx.commit();
				System.out.println("\nAuthor and Biography deleted successfully");
			} else {
				System.out.println("Author not found!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
