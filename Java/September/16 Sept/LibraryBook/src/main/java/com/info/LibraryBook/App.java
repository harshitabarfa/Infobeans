package com.info.LibraryBook;

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
			System.out.println("\n---Library Management Menu---");
			System.out.println("1. Add Library with Books");
			System.out.println("2. Add Book to Existing Library");
			System.out.println("3. View All Libraries with Books");
			System.out.println("4. Update Book Price");
			System.out.println("5. Update Library Name");
			System.out.println("6. Delete Book by ID");
			System.out.println("7. Delete Library by ID");
			System.out.println("8. Find Books by Library Name");
			System.out.println("9. Find Library by Book Title");
			System.out.println("10. List Books with Price > Given Amount");
			System.out.println("11. List Libraries with More than N Books");
			System.out.println("0. Exit");

			System.out.print("\nEnter choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				addLibraryWithBooks(sc);
				break;
			case 2:
				addBookToLibrary(sc);
				break;
			case 3:
				viewAllLibrariesWithBooks();
				break;
			case 4:
				updateBookPrice(sc);
				break;
			case 5:
				updateLibraryName(sc);
				break;
			case 6:
				deleteBookById(sc);
				break;
			case 7:
				deleteLibraryById(sc);
				break;
			case 8:
				findBooksByLibraryName(sc);
				break;
			case 9:
				findLibraryByBookTitle(sc);
				break;
			case 10:
				listBooksWithPriceGreaterThan(sc);
				break;
			case 11:
				listLibrariesWithMoreThanNBooks(sc);
				break;
			case 0:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice!");
			}
		} while (choice != 0);
		sf.close();
	}

	private static void addLibraryWithBooks(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Library Name: ");
		String name = sc.nextLine();

		System.out.print("Enter Library Location: ");
		String location = sc.nextLine();

		Library library = new Library();
		library.setName(name);
		library.setLocation(location);

		System.out.print("How many books to add? ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			System.out.print("Enter Book Title: ");
			String title = sc.nextLine();

			System.out.print("Enter Author Name: ");
			String author = sc.nextLine();

			System.out.print("Enter Price: ");
			double price = sc.nextDouble();
			sc.nextLine();

			Book book = new Book();
			book.setTitle(title);
			book.setAuthor(author);
			book.setPrice(price);
			book.setLibrary(library);

			library.getBook().add(book);
		}

		session.persist(library);
		tx.commit();
		session.close();

		System.out.println("Library and books saved successfully.");
	}

	private static void addBookToLibrary(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Library ID: ");
		int libId = sc.nextInt();
		sc.nextLine();

		Library library = session.get(Library.class, libId);

		if (library != null) {
			System.out.print("Enter Book Title: ");
			String title = sc.nextLine();

			System.out.print("Enter Author Name: ");
			String author = sc.nextLine();

			System.out.print("Enter Price: ");
			double price = sc.nextDouble();
			sc.nextLine();

			Book book = new Book();
			book.setTitle(title);
			book.setAuthor(author);
			book.setPrice(price);
			book.setLibrary(library);

			library.getBook().add(book);
			session.persist(book);

			tx.commit();
			System.out.println("Book added to Library successfully.");
		} else {
			System.out.println("Library not found.");
		}
		session.close();
	}

	private static void viewAllLibrariesWithBooks() {
		Session session = sf.openSession();
		List<Library> l = session.createQuery("from Library", Library.class).getResultList();

		for (Library lib : l) {
			System.out.println("libraryLocation= " + lib.getLocation() + ", libraryName=" + lib.getName());
			for (Book b : lib.getBook()) {
				System.out.println("-> bookName=" + b.getTitle() + ", bookAuthor=" + b.getAuthor() + ", bookPrice="
						+ b.getPrice());
			}
		}
		session.close();
	}

	private static void updateBookPrice(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Book ID: ");
		int bookId = sc.nextInt();
		sc.nextLine();

		Book book = session.get(Book.class, bookId);

		if (book != null) {
			System.out.print("Enter new price: ");
			double newPrice = sc.nextDouble();
			sc.nextLine();

			book.setPrice(newPrice);
			session.update(book);

			tx.commit();
			System.out.println("Book price updated successfully.");
		} else {
			System.out.println("Book not found.");
		}
		session.close();
	}

	private static void updateLibraryName(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Library ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		Library library = session.get(Library.class, id);

		if (library != null) {
			System.out.print("Enter new Library Name: ");
			String newName = sc.nextLine();

			library.setName(newName);
			session.update(library);

			tx.commit();
			System.out.println("Library name updated successfully.");
		} else {
			System.out.println("Library not found.");
		}
		session.close();
	}

	private static void deleteBookById(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Book ID: ");
		int bookId = sc.nextInt();
		sc.nextLine();

		Book book = session.get(Book.class, bookId);

		if (book != null) {
			session.remove(book);
			tx.commit();
			System.out.println("Book deleted successfully.");
		} else {
			System.out.println("Book not found.");
		}
		session.close();
	}

	private static void deleteLibraryById(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Library ID: ");
		int libId = sc.nextInt();
		sc.nextLine();

		Library library = session.get(Library.class, libId);

		if (library != null) {
			session.remove(library);
			tx.commit();
			System.out.println("Library and its books deleted successfully.");
		} else {
			System.out.println("Library not found.");
		}
		session.close();
	}

	private static void findBooksByLibraryName(Scanner sc) {
		Session session = sf.openSession();

		System.out.print("Enter Library Name: ");
		String libName = sc.nextLine();

		List<Book> books = session.createQuery("from Book where library.name = :libName", Book.class)
				.setParameter("libName", libName).getResultList();

		for (Book b : books) {
			System.out.printf("Book: \"%s\" | Author: %s | Price: %.2f\n", b.getTitle(), b.getAuthor(), b.getPrice());
		}
		session.close();
	}

	private static void findLibraryByBookTitle(Scanner sc) {
		Session session = sf.openSession();

		System.out.print("Enter Book Title: ");
		String bookTitle = sc.nextLine();

		Library library = session.createQuery("select library from Book where title = :bookTitle", Library.class)
				.setParameter("bookTitle", bookTitle).uniqueResult();

		if (library != null) {
			System.out.printf("Library: %s | Location: %s\n", library.getName(), library.getLocation());
		} else {
			System.out.println("Book or Library not found.");
		}
		session.close();
	}

	private static void listBooksWithPriceGreaterThan(Scanner sc) {
		Session session = sf.openSession();

		System.out.print("Enter minimum price: ");
		double price = sc.nextDouble();
		sc.nextLine();

		List<Book> books = session.createQuery("from Book where price > :price", Book.class)
				.setParameter("price", price).getResultList();

		for (Book b : books) {
			System.out.printf("Book: \"%s\" | Author: %s | Price: %.2f | Library: %s\n", b.getTitle(), b.getAuthor(),
					b.getPrice(), b.getLibrary().getName());
		}
		session.close();
	}

	private static void listLibrariesWithMoreThanNBooks(Scanner sc) {
		Session session = sf.openSession();

		System.out.print("Enter minimum number of books: ");
		int n = sc.nextInt();
		sc.nextLine();

		List<Library> libraries = session.createQuery("from Library where size(book) > :n", Library.class)
				.setParameter("n", n).getResultList();

		for (Library l : libraries) {
			System.out.printf("Library: %s | Location: %s | Books Count: %d\n", l.getName(), l.getLocation(),
					l.getBook().size());
		}
		session.close();
	}
}
