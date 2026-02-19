package com.third.LibraryMember;

import java.sql.Date;
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
			System.out.println("\n--- Library Member Management System ---");
			System.out.println("1. Insert New Member");
			System.out.println("2. Fetch Member by ID");
			System.out.println("3. Update Member (Phone / Membership Type)");
			System.out.println("4. Delete Member by ID");
			System.out.println("5. Exit");

			System.out.print("Enter choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				insertMember(sc);
				break;
			case 2:
				fetchMember(sc);
				break;
			case 3:
				updateMember(sc);
				break;
			case 4:
				deleteMember(sc);
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

	private static void insertMember(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Member ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Name: ");
		String name = sc.nextLine();

		System.out.print("Enter Email: ");
		String email = sc.nextLine();

		System.out.print("Enter Phone Number: ");
		String phone = sc.nextLine();

		System.out.print("Enter Membership Type (Regular/Premium): ");
		String type = sc.nextLine();

		Date joinDate = new Date(System.currentTimeMillis());

		LibraryMember m = new LibraryMember(id, name, email, phone, type, joinDate);
		session.persist(m);

		tx.commit();
		session.close();

		System.out.println("Member inserted successfully");
	}

	private static void fetchMember(Scanner sc) {
		Session session = sf.openSession();

		System.out.print("Enter Member ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		LibraryMember m = session.get(LibraryMember.class, id);

		if (m != null) {
			System.out.println(m);
		} else {
			System.out.println("Member not found");
		}

		session.close();
	}

	private static void updateMember(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Member ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		LibraryMember m = session.get(LibraryMember.class, id);

		if (m != null) {
			System.out.println("1. Update Phone Number");
			System.out.println("2. Update Membership Type");
			int option = sc.nextInt();
			sc.nextLine();

			if (option == 1) {
				System.out.print("Enter new Phone Number: ");
				String newPhone = sc.nextLine();
				m.setPhoneNumber(newPhone);
			} else if (option == 2) {
				System.out.print("Enter new Membership Type: ");
				String newType = sc.nextLine();
				m.setMembershipType(newType);
			}

			session.merge(m);
			tx.commit();
			System.out.println("Member updated successfully");
		} else {
			System.out.println("Member not found");
		}
		session.close();
	}

	private static void deleteMember(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Member ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		LibraryMember m = session.get(LibraryMember.class, id);

		if (m != null) {
			session.remove(m);
			tx.commit();
			System.out.println("Member deleted successfully");
		} else {
			System.out.println("Member not found");
		}

		session.close();
	}
}
