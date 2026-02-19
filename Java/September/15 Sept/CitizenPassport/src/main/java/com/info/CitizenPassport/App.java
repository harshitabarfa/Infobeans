package com.info.CitizenPassport;

import java.time.LocalDate;
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
			System.out.println("\n---Citizen-Passport Management---");
			System.out.println("1. Add Citizen with Passport");
			System.out.println("2. View All Citizens with Passport");
			System.out.println("3. Update Citizen Age by ID");
			System.out.println("4. Update Passport Issue Date by Number");
			System.out.println("5. Delete Citizen by ID");
			System.out.println("6. Delete Passport by Number");
			System.out.println("7. Find Citizen by Passport Number (HQL)");
			System.out.println("8. Find Passport by Citizen Name (HQL)");
			System.out.println("9. List Citizens Older Than 25 (HQL)");
			System.out.println("10. List Passports Issued After 2020 (HQL)");
			System.out.println("0. Exit");

			System.out.print("\nEnter choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				addCitizenWithPassport(sc);
				break;
			case 2:
				viewAllCitizens();
				break;
			case 3:
				updateCitizenAge(sc);
				break;
			case 4:
				updatePassportIssueDate(sc);
				break;
			case 5:
				deleteCitizenById(sc);
				break;
			case 6:
				deletePassportByNumber(sc);
				break;
			case 7:
				findCitizenByPassportNumber(sc);
				break;
			case 8:
				findPassportByCitizenName(sc);
				break;
			case 9:
				listCitizensOlderThan25();
				break;
			case 10:
				listPassportsAfter2020();
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

	private static void addCitizenWithPassport(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Citizen c = new Citizen();
		Passport p = new Passport();

		System.out.print("Enter Citizen name: ");
		c.setName(sc.nextLine());

		System.out.print("Enter Citizen age: ");
		c.setAge(sc.nextInt());
		sc.nextLine();

		System.out.print("Enter Passport number: ");
		p.setNumber(sc.nextLine());

		System.out.print("Enter Passport issue date (yyyy-mm-dd): ");
		p.setIssueDate(LocalDate.parse(sc.nextLine()));

		c.setPassport(p);
		p.setCitizen(c);

		session.persist(c);

		tx.commit();
		session.close();

		System.out.println("Citizen and Passport added successfully.");
	}

	private static void viewAllCitizens() {
		Session session = sf.openSession();

		List<Citizen> l = session.createQuery("from Citizen", Citizen.class).getResultList();
		for (Citizen c : l) {
			System.out.println(c);
		}
		session.close();
	}

	private static void updateCitizenAge(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Citizen ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		Citizen c = session.get(Citizen.class, id);
		if (c != null) {
			System.out.print("Enter new age: ");
			c.setAge(sc.nextInt());
			session.merge(c);
			System.out.println("Citizen age updated.");
		} else {
			System.out.println("Citizen not found.");
		}

		tx.commit();
		session.close();
	}

	private static void updatePassportIssueDate(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Passport Number: ");
		String number = sc.nextLine();

		Passport p = session.createQuery("from Passport where number = :number", Passport.class)
				.setParameter("number", number).uniqueResult();

		if (p != null) {
			System.out.print("Enter new issue date (yyyy-mm-dd): ");
			p.setIssueDate(LocalDate.parse(sc.nextLine()));
			session.merge(p);
			System.out.println("Passport issue date updated.");
		} else {
			System.out.println("Passport not found.");
		}

		tx.commit();
		session.close();
	}

	private static void deleteCitizenById(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Citizen ID to delete: ");
		int id = sc.nextInt();
		sc.nextLine();

		Citizen c = session.get(Citizen.class, id);
		if (c != null) {
			session.remove(c);
			System.out.println("Citizen and Passport deleted.");
		} else {
			System.out.println("Citizen not found.");
		}

		tx.commit();
		session.close();
	}

	private static void deletePassportByNumber(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Passport Number to delete: ");
		String number = sc.nextLine();

		Passport p = session.createQuery("from Passport where number = :number", Passport.class)
				.setParameter("number", number).uniqueResult();

		if (p != null) {
			Citizen c = p.getCitizen();
			if (c != null) {
				c.setPassport(null);
				session.merge(c);
			}
			session.remove(p);
			System.out.println("Passport deleted, association cleared.");
		} else {
			System.out.println("Passport not found.");
		}

		tx.commit();
		session.close();
	}

	private static void findCitizenByPassportNumber(Scanner sc) {
		Session session = sf.openSession();

		System.out.print("Enter Passport Number: ");
		String number = sc.nextLine();

		Citizen c = session.createQuery("select p.citizen from Passport p where p.number = :number", Citizen.class)
				.setParameter("number", number).uniqueResult();

		if (c != null) {
			System.out.println(c);
		} else {
			System.out.println("No Citizen found for this Passport number.");
		}

		session.close();
	}

	private static void findPassportByCitizenName(Scanner sc) {
		Session session = sf.openSession();

		System.out.print("Enter Citizen Name: ");
		String name = sc.nextLine();

		Passport p = session.createQuery("select c.passport from Citizen c where c.name = :name", Passport.class)
				.setParameter("name", name).uniqueResult();

		if (p != null) {
			System.out.println("Passport: " + p.getNumber());
		} else {
			System.out.println("No Passport found for this Citizen name.");
		}

		session.close();
	}

	private static void listCitizensOlderThan25() {
		Session session = sf.openSession();

		List<String> names = session.createQuery("select c.name from Citizen c where c.age > 25", String.class)
				.getResultList();

		for (String name : names) {
			System.out.println("Citizen: " + name);
		}

		session.close();
	}

	private static void listPassportsAfter2020() {
		Session session = sf.openSession();

		LocalDate cutoffDate = LocalDate.of(2020, 12, 31);

		List<String> numbers = session
				.createQuery("select p.number from Passport p where p.issuedate > :date", String.class)
				.setParameter("date", cutoffDate).getResultList();

		for (String number : numbers) {
			System.out.println("Passport Number: " + number);
		}

		session.close();
	}
}
